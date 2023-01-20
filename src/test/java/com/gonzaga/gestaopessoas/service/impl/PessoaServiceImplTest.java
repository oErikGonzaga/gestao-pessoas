package com.gonzaga.gestaopessoas.service.impl;

import com.gonzaga.gestaopessoas.exception.PessoaCadastroException;
import com.gonzaga.gestaopessoas.exception.PessoaNotFoundException;
import com.gonzaga.gestaopessoas.model.Pessoa;
import com.gonzaga.gestaopessoas.repository.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class PessoaServiceImplTest {

    @InjectMocks
    private PessoaServiceImpl service;

    @Mock
    private PessoaRepository repository;

    @Test
    void membersNotNull() {
        Assertions.assertNotNull(service);
        Assertions.assertNotNull(repository);
    }

    @Test
    void quandoIdInformadoNoCriarPessoaDeveLancarPessoaCadastroException() {
        PessoaCadastroException exception = Assertions.assertThrows(PessoaCadastroException.class, () -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(123L);
            service.criar(pessoa);
        });

        Assertions.assertNotNull(exception);
        Assertions.assertEquals("Tentativa de cadastro incorreta", exception.getMessage());
    }

    @Test
    void deveCriarPessoaQuandoRequestCorreto() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste nome");
        pessoa.setNascimento(LocalDate.of(1982, 5, 10));

        Pessoa pessoaSalva = new Pessoa();
        pessoaSalva.setId(1L);

        when(repository.save(pessoa)).thenReturn(pessoaSalva);

        Pessoa resultado = service.criar(pessoa);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(1, resultado.getId());
        verify(repository, times(1)).save(pessoa);
    }

    @Test
    void quandoPessoaNaoExistirDeveLancarPessoaNotFoundException() {
        PessoaNotFoundException exception = Assertions.assertThrows(PessoaNotFoundException.class, () -> {
            Long id = 10L;
            when(repository.findById(id)).thenReturn(Optional.empty());
            service.consultar(id);
        });

        Assertions.assertNotNull(exception);
    }

    @Test
    void quandoPessoaPresenteDeveRetornar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("teste nome");
        pessoa.setNascimento(LocalDate.of(1982, 5, 10));

        Optional<Pessoa> pessoaOptional = Optional.of(pessoa);
        Long id = 10L;
        when(repository.findById(id)).thenReturn(pessoaOptional);
        var resultado = service.consultar(id);

        Assertions.assertNotNull(resultado);
        Assertions.assertEquals(pessoa.getNome(), resultado.getNome());
        verify(repository, times(1)).findById(id);
    }

}
