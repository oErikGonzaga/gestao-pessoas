package com.gonzaga.gestaopessoas.controller;

import com.gonzaga.gestaopessoas.model.Endereco;
import com.gonzaga.gestaopessoas.model.Pessoa;
import com.gonzaga.gestaopessoas.service.EnderecoService;
import com.gonzaga.gestaopessoas.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/pessoas")
public class GestaoPessoaController {

    private final PessoaService pessoaService;
    private final EnderecoService enderecoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa criar(@RequestBody Pessoa pessoa){
        return pessoaService.criar(pessoa);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean editar(@PathVariable Long id,
                          @RequestParam(value = "nome", required = false) String nome,
                          @RequestParam(value = "nascimento", required = false) String nascimento){

        return pessoaService.editar(id, nome, nascimento);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pessoa consultar(@PathVariable Long id){
        return pessoaService.consultar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @PostMapping("{idPessoa}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco criar(@PathVariable Long idPessoa,
                          @RequestBody Endereco endereco){
        return enderecoService.criar(endereco, idPessoa);
    }

    @GetMapping("{idPessoa}/enderecos")
    @ResponseStatus(HttpStatus.OK)
    public List<Endereco> listar(@PathVariable Long idPessoa){
        return enderecoService.listar(idPessoa);
    }
}