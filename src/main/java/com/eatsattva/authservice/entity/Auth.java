package com.eatsattva.authservice.entity;

import com.eatsattva.authservice.util.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.engine.internal.Nullability;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "auth_db")
@Builder
@AllArgsConstructor
@Getter
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID hid;

    @Column(nullable = false, updatable = true, length = 255)
    private String email;

    @Column
    private String passwordHash;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private boolean emailVerified;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    public Auth() {

    }
}
