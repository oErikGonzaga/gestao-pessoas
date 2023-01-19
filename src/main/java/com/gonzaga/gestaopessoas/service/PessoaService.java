package com.gonzaga.gestaopessoas.service;

import com.gonzaga.gestaopessoas.model.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa criar(Pessoa pessoa);
    boolean editar(Long id, String nome, String nascimento);
    Pessoa consultar(Long id);
    List<Pessoa> listar();
}
