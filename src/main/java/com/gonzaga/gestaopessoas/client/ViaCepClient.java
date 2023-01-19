package com.gonzaga.gestaopessoas.client;

import com.gonzaga.gestaopessoas.response.EnderecoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViaCepClient {

    @GetMapping("ws/{cep}/json/")
    Optional<EnderecoResponse> getAddressByCep(@PathVariable("cep") String cep);
}