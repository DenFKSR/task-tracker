package com.example.authservice.controllers;

import com.example.authservice.dto.request.LoginRequest;
import com.example.authservice.dto.request.RegisterRequest;
import com.example.authservice.dto.request.RefreshTokenRequest;
import com.example.authservice.dto.response.AuthResponse;
import com.example.authservice.exception.CustomException;
import com.example.authservice.service.AuthService;
import com.example.authservice.service.RefreshTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;

    /**
     * Регистрация нового пользователя
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Аутентификация (вход) и получение JWT-токенов
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Обновление access-токена с помощью refresh-токена
     */
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        try {
            String newAccessToken = refreshTokenService.validateAndCreateAccessToken(request.getRefreshToken());
            AuthResponse response = new AuthResponse(newAccessToken, null, "Токен успешно обновлён");
            return ResponseEntity.ok(response);
        } catch (CustomException e) {
            AuthResponse errorResponse = new AuthResponse(null, null, e.getMessage());
            return ResponseEntity.status(401).body(errorResponse);
        }
    }
}
