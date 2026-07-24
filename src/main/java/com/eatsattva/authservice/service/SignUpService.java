package com.eatsattva.authservice.service;

import com.eatsattva.authservice.dto.request.SignupRequest;
import com.eatsattva.authservice.dto.response.SignUpResponse;
import com.eatsattva.authservice.entity.Auth;
import com.eatsattva.authservice.repository.AuthRepo;
import com.eatsattva.authservice.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SignUpService {

    AuthRepo authRepo;
    private PasswordEncoder passwordEncoder;

    public SignUpResponse doSignUp(SignupRequest signupRequest){


        String hash = passwordEncoder.encode(signupRequest.password());

        Auth auth = Auth.builder()
                        .hid(UUID.randomUUID())
                        .email(signupRequest.email())
                        .passwordHash(hash)
                        .role(Role.CUSTOMER)
                        .enabled(true)
                        .emailVerified(false)
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .build();

        auth = authRepo.save(auth);

        return SignUpResponse.builder()
                .email(auth.getEmail())
                .emailVerified(auth.isEmailVerified())
                .message("User registered Successfully").build();
    }

    @Autowired
    void signUpService(AuthRepo authRepo){
        this.authRepo = authRepo;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
