package com.eatsattva.authservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class JwtConfig {

    @Bean
    JwtEncoder jwtEncoder(RSAPrivateKey rsaPrivateKey, RSAPublicKey rsaPublicKey){
        return NimbusJwtEncoder
                .withKeyPair(rsaPublicKey, rsaPrivateKey)
                .build();

    }

}
