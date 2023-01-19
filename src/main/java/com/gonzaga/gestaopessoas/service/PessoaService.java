package com.gonzaga.gestaopessoas.service;

import com.gonzaga.gestaopessoas.model.Pessoa;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService {

    Pessoa criar(Pessoa pessoa);
    Pessoa editar(Long id, String nome, LocalDate nascimento);
    Pessoa consultar(Long id);
    List<Pessoa> listar();
}
