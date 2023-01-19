package com.gonzaga.gestaopessoas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String logradouro;

    @Column(length = 8, nullable = false)
    private String cep;

    private String numero;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private Boolean principal;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private Pessoa pessoa;

}