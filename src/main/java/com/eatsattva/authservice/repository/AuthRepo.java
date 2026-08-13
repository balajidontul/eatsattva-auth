package com.eatsattva.authservice.repository;

import com.eatsattva.authservice.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepo extends JpaRepository<Auth, Long> {

    Optional<Auth> findByPhoneNumber(String phoneNumber);
}
