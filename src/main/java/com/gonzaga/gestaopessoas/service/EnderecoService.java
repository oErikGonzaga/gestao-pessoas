package com.gonzaga.gestaopessoas.service;

import com.gonzaga.gestaopessoas.model.Endereco;

import java.util.List;

public interface EnderecoService {

    Endereco criar(Endereco endereco, Long idPessoa);
    List<Endereco> listar(Long idPessoa);

}
