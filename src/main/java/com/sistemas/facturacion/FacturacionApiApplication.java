package com.sistemas.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sistemas.facturacion")
@SpringBootApplication
public class FacturacionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacturacionApiApplication.class, args);
    }
}
