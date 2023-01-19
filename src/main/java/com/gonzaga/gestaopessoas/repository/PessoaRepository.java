package com.gonzaga.gestaopessoas.repository;

import com.gonzaga.gestaopessoas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    Pessoa findFirstByNome(String nome);
    Pessoa findFirstByNascimento(LocalDate nascimento);


}
