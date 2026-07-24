package com.eatsattva.authservice.dto.response;

import lombok.Builder;

@Builder
public class SignUpResponse {
    String email;
    boolean emailVerified;
    String message;
}
