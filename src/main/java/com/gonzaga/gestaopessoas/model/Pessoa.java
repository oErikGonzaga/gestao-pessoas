package com.gonzaga.gestaopessoas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate nascimento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Endereco> endereco;

}
