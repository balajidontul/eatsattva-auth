package com.eatsattva.authservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties("rsa")
public record RsaKeyProperties(Resource privateKey,
                               Resource publicKey) {
}
