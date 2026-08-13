package com.eatsattva.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration
public class RsaKeyConfig{

    @Bean
    public RSAPrivateKey rsaPrivateKey(RsaKeyProperties rsaKeyProperties){
        return PemKeyLoader.readPrivateKey(rsaKeyProperties.privateKey());
    }

    @Bean
    public RSAPublicKey rsaPublicKey(RsaKeyProperties rsaKeyProperties){
        return PemKeyLoader.readPublicKey(rsaKeyProperties.publicKey());
    }

}
