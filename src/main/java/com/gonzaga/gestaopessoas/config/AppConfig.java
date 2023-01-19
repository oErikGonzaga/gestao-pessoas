package com.gonzaga.gestaopessoas.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients({"com.gonzaga.gestaopessoas.client"})
public class AppConfig {
}