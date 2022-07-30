package com.amazingavocado.holymolymvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HolymolymvpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolymolymvpApplication.class, args);

    }

}
