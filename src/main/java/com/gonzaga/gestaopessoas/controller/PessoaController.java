package com.gonzaga.gestaopessoas.controller;

import com.gonzaga.gestaopessoas.model.Pessoa;
import com.gonzaga.gestaopessoas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/pessoas")
public class PessoaController {

    private final PessoaService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Pessoa pessoa){

        var pessoaCriada = service.criar(pessoa);

        return Objects.isNull(pessoaCriada) ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pessoa não encontrada") :
                ResponseEntity.ok(pessoaCriada);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean editar(@PathVariable Long id,
                          @RequestParam(value = "nome", required = false) String nome,
                          @RequestParam(value = "nascimento", required = false) String nascimento){

        return service.editar(id, nome, nascimento);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa consultar(@PathVariable Long id){
        return service.consultar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listar(){
        return service.listar();
    }
}