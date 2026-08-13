package com.eatsattva.authservice.security;

import com.eatsattva.authservice.entity.Auth;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CustomUserDetails implements UserDetails {

    private Auth auth;

    public CustomUserDetails(Auth auth) {
        this.auth = auth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return auth.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return auth.getPhoneNumber();
    }
}
