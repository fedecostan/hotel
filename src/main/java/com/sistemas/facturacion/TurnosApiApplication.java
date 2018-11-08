package com.sistemas.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sistemas.facturacion")
@SpringBootApplication
public class TurnosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurnosApiApplication.class, args);
    }
}
