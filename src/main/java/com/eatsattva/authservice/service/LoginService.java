package com.eatsattva.authservice.service;

import com.eatsattva.authservice.dto.request.LoginRequest;
import com.eatsattva.authservice.dto.response.LoginResponse;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.Instant;
import java.time.InstantSource;

@Service
public class LoginService {

    private final JwtEncoder jwtEncoder;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(JwtEncoder jwtEncoder, AuthenticationManager authenticationManager) {
        this.jwtEncoder = jwtEncoder;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse doLogin(LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.phoneNumber(), loginRequest.password()));

        JwsHeader header = JwsHeader.with(SignatureAlgorithm.RS256)
                .type("JWT")
                .build();

        Instant now = Instant.now();
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .subject(authentication.getName())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(900))
                .build();

        Jwt jwt = jwtEncoder.encode(JwtEncoderParameters.from(header,jwtClaimsSet));
        return new LoginResponse(jwt.getTokenValue(), "Bearer", 900);
    }

}
