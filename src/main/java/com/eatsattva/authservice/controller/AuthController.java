package com.eatsattva.authservice.controller;

import com.eatsattva.authservice.dto.request.LoginRequest;
import com.eatsattva.authservice.dto.request.SignupRequest;
import com.eatsattva.authservice.dto.response.LoginResponse;
import com.eatsattva.authservice.dto.response.SignUpResponse;
import com.eatsattva.authservice.service.LoginService;
import com.eatsattva.authservice.service.SignUpService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    SignUpService signUpService;

    @Autowired
    LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody @Valid SignupRequest signupRequest) {
        SignUpResponse signUpResponse = signUpService.doSignUp(signupRequest);
        return new ResponseEntity<>(signUpResponse, HttpStatus.CREATED);
    };

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        LoginResponse loginResponse = loginService.doLogin(loginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }


}