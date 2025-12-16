package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "refreshtoken")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long token;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    Date expiryDate;
    LocalDateTime createdAt;
}
