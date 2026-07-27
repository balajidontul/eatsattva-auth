package com.eatsattva.authservice;

import com.eatsattva.authservice.config.RsaKeyProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class eatsattvaauthserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(eatsattvaauthserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner test(RsaKeyProperties properties) {
        return args -> {
            System.out.println(properties.privateKey());
            System.out.println(properties.publicKey());
        };
    }

}
