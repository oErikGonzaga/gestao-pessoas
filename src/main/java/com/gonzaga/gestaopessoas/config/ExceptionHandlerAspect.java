package com.gonzaga.gestaopessoas.config;

import com.gonzaga.gestaopessoas.exception.PessoaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAspect {
    @ExceptionHandler(PessoaNotFoundException.class)
    public final ResponseEntity<String> handle(PessoaNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
    }
}
