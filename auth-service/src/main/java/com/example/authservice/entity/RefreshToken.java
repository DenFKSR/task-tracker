package com.example.authservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Представляет refresh-токен, используемый для получения новых access-токенов
 * без необходимости повторной аутентификации пользователя.
 * Каждый refresh-токен привязан к конкретному пользователю и имеет ограниченный срок действия.
 */
@Getter
@Setter
@Entity
@Table(name = "refresh_token")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshToken {

    /**
     * Уникальный идентификатор записи refresh-токена.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Сам refresh-токен в виде строки.
     */
    String token;

    /**
     * Пользователь, которому принадлежит данный refresh-токен.
     * Связь один-к-одному: один пользователь — один активный refresh-токен (в рамках данной модели)
     */
    @OneToOne//
    @JoinColumn(name = "user_id")
    User user;

    /**
     * Дата и время истечения срока действия refresh-токена.
     */
    @Column(name = "expiry_date")
    Date expiryDate;

    /**
     * Дата и время создания refresh-токена.
     */
    @Column(name = "created_at")
    LocalDateTime createdAt;
}
