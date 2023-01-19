package com.gonzaga.gestaopessoas.service.impl;

import com.gonzaga.gestaopessoas.client.ViaCepClient;
import com.gonzaga.gestaopessoas.exception.EnderecoCadastroException;
import com.gonzaga.gestaopessoas.exception.PessoaNotFoundException;
import com.gonzaga.gestaopessoas.model.Endereco;
import com.gonzaga.gestaopessoas.repository.EnderecoRepository;
import com.gonzaga.gestaopessoas.repository.PessoaRepository;
import com.gonzaga.gestaopessoas.service.EnderecoService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final ViaCepClient viaCepClient;
    private final EnderecoRepository repository;
    private final PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public Endereco criar(Endereco endereco, Long idPessoa) {

        try {
            var enderecoViaCep = viaCepClient.getAddressByCep(endereco.getCep()).orElseThrow(() -> {
                throw new EnderecoCadastroException("Endereço não encontrado");
            });

            if (enderecoViaCep.isErro())
                throw new EnderecoCadastroException("Endereço não encontrado");

            var pessoa = pessoaRepository.findById(idPessoa).orElseThrow(PessoaNotFoundException::new);
            endereco.setPessoa(pessoa);

            if (StringUtils.isBlank(endereco.getLogradouro()))
                endereco.setLogradouro(enderecoViaCep.getLogradouro());

            if (StringUtils.isBlank(endereco.getCidade()))
                endereco.setCidade(enderecoViaCep.getLocalidade());

        } catch (FeignException e){
            throw new EnderecoCadastroException("Endereço não encontrado");
        }

        return repository.save(endereco);
    }

    @Override
    public List<Endereco> listar(Long idPessoa) {

        var pessoa = pessoaRepository.findById(idPessoa).orElseThrow(PessoaNotFoundException::new);

        return repository.findAllByPessoaId(pessoa.getId());
    }
}
