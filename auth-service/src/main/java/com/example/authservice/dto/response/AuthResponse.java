package com.example.authservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;   // ← короткоживущий JWT (например, 15–30 мин)
    private String refreshToken;  // ← долгоживущий токен (например, 7 дней)
    private String message;       // ← опционально: "Успешный вход", "Регистрация прошла успешно"
}
