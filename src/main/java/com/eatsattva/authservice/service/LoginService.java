package com.eatsattva.authservice.service;

import com.eatsattva.authservice.dto.request.LoginRequest;
import com.eatsattva.authservice.dto.response.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginResponse doLogin(LoginRequest loginRequest){

        
        return new LoginResponse();
    }

}
