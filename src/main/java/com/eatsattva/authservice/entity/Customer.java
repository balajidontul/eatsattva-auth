package com.eatsattva.authservice.entity;

import com.eatsattva.authservice.util.Role;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    Long id;
    UUID publicId;
    String firstName;
    String lastName;
    String email;
    String password_hash;
    Role role;
    Boolean enabled;
    Boolean emailVerified;
    Date createdDate;
    Date updatedDate;
}
