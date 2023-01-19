package com.gonzaga.gestaopessoas.service.impl;

import com.gonzaga.gestaopessoas.exception.PessoaCadastroException;
import com.gonzaga.gestaopessoas.exception.PessoaNotFoundException;
import com.gonzaga.gestaopessoas.model.Pessoa;
import com.gonzaga.gestaopessoas.repository.PessoaRepository;
import com.gonzaga.gestaopessoas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;

    @Override
    public Pessoa criar(Pessoa pessoa) {

        if (Objects.nonNull(pessoa.getId()))
            throw new PessoaCadastroException("Tentativa de cadastro incorreta");

        return repository.save(pessoa);
    }

    @Override
    public Pessoa editar(Long id, String nome, LocalDate nascimento) {

        var pessoa = consultar(id);
        boolean isAtualizado = false;

        if (Objects.nonNull(nome) && !("".equals(nome)) && !(nome.equals(pessoa.getNome()))) {
            pessoa.setNome(nome);
            isAtualizado = true;
        }

        if (Objects.nonNull(nascimento) && !(nascimento.equals(pessoa.getNascimento()))) {
            pessoa.setNascimento((nascimento));
            isAtualizado = true;
        }

        return repository.save(pessoa);
    }

    @Override
    public Pessoa consultar(Long id) {
        return repository.findById(id).orElseThrow(PessoaNotFoundException::new);
    }

    @Override
    public List<Pessoa> listar() {
        return repository.findAll();
    }
}
