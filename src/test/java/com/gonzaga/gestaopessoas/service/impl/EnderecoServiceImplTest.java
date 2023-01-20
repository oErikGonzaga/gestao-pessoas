package com.gonzaga.gestaopessoas.service.impl;

import com.gonzaga.gestaopessoas.client.ViaCepClient;
import com.gonzaga.gestaopessoas.exception.EnderecoCadastroException;
import com.gonzaga.gestaopessoas.model.Endereco;
import com.gonzaga.gestaopessoas.model.Pessoa;
import com.gonzaga.gestaopessoas.repository.EnderecoRepository;
import com.gonzaga.gestaopessoas.repository.PessoaRepository;
import com.gonzaga.gestaopessoas.response.EnderecoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class EnderecoServiceImplTest {

    @InjectMocks
    private EnderecoServiceImpl service;

    @Mock private ViaCepClient viaCepClient;
    @Mock private EnderecoRepository repository;
    @Mock private PessoaRepository pessoaRepository;

    @Test
    void membersNotNull() {
        Assertions.assertNotNull(service);
        Assertions.assertNotNull(viaCepClient);
        Assertions.assertNotNull(repository);
        Assertions.assertNotNull(pessoaRepository);
    }

    @Test
    void quandoCepInvalidoDeveLancarEnderecoCadastroException() {
        Endereco endereco = new Endereco();
        endereco.setCep("00000");

        EnderecoCadastroException exception = Assertions.assertThrows(EnderecoCadastroException.class, () -> {
            when(viaCepClient.getAddressByCep(endereco.getCep())).thenReturn(Optional.empty());
            service.criar(endereco, 1L);
        });

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Endereço não encontrado", exception.getMessage());
        verify(viaCepClient, times(1)).getAddressByCep(endereco.getCep());
        verify(repository, times(0)).save(endereco);
    }

    @Test
    void quandoRetornoViacepComErroDeveLancarEnderecoCadastroException() {
        Endereco endereco = new Endereco();
        endereco.setCep("00000");

        EnderecoCadastroException exception = Assertions.assertThrows(EnderecoCadastroException.class, () -> {
            EnderecoResponse enderecoResponse = new EnderecoResponse();
            enderecoResponse.setErro(true);

            when(viaCepClient.getAddressByCep(endereco.getCep())).thenReturn(Optional.of(enderecoResponse));
            service.criar(endereco, 1L);
        });

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Endereço não encontrado", exception.getMessage());
        verify(viaCepClient, times(1)).getAddressByCep(endereco.getCep());
        verify(repository, times(0)).save(endereco);
    }

    @Test
    void deveCadastrarEndereco() {
        Long idPessoa = 20L;

        Endereco endereco = new Endereco();
        endereco.setCep("02010100");
        endereco.setCidade("cidade");
        endereco.setLogradouro("Logra");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste nome");
        pessoa.setNascimento(LocalDate.of(1982, 5, 10));

        Endereco enderecoSalvo = new Endereco();
        enderecoSalvo.setId(1234L);

        EnderecoResponse enderecoResponse = new EnderecoResponse();

        when(viaCepClient.getAddressByCep(endereco.getCep())).thenReturn(Optional.of(enderecoResponse));
        when(pessoaRepository.findById(idPessoa)).thenReturn(Optional.of(pessoa));
        when(repository.save(endereco)).thenReturn(enderecoSalvo);

        var resultado = service.criar(endereco, idPessoa);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(1234, enderecoSalvo.getId());
        verify(viaCepClient, times(1)).getAddressByCep(endereco.getCep());
        verify(repository, times(1)).save(endereco);
        verify(pessoaRepository, times(1)).findById(idPessoa);
    }

}