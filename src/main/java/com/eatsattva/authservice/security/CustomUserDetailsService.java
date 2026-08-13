package com.eatsattva.authservice.security;

import com.eatsattva.authservice.entity.Auth;
import com.eatsattva.authservice.repository.AuthRepo;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    AuthRepo authRepo;

    @Autowired
    public CustomUserDetailsService(AuthRepo authRepo){
        this.authRepo = authRepo;

    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Auth auth = authRepo.findByPhoneNumber(username).orElseThrow(()->
                new UsernameNotFoundException("User not found: " + username));
        return new CustomUserDetails(auth);
    }
}
