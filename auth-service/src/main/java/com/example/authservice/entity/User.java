package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Содержит данные пользователя
 */
@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    /**
     * Уникальный идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Логин пользователя
     */
    @Column(name = "user_name")
    String username;

    /**
     * Пароль вводимый пользователем
     */
    String password;

    /**
     * Адрес электронной почты пользователя
     */
    String email;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    String lastName;

    /**
     * Роль пользователя
     */
    String roles;

    /**
     * Флаг, указывающий, активен ли аккаунт пользователя.
     */
    Boolean enabled;

    /**
     * Дата и время создания аккаунта пользователя.
     */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /**
     * Дата и время последнего обновления данных пользователя.
     */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
