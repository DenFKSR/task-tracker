package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String roles;
    Boolean enabled;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
