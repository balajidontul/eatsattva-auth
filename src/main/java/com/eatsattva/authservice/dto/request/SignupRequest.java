package com.eatsattva.authservice.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SignupRequest(@NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank String phoneNumber,
                            @NotBlank String password ){

}
