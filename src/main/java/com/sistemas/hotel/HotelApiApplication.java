package com.sistemas.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sistemas.hotel")
@SpringBootApplication
public class HotelApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelApiApplication.class, args);
    }
}
