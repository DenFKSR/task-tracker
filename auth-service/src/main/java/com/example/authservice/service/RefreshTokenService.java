package com.example.authservice.service;

import com.example.authservice.entity.RefreshToken;
import com.example.authservice.entity.User;
import com.example.authservice.exception.CustomException;
import com.example.authservice.repository.RefreshTokenRepository;
import com.example.authservice.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;

    /**
     * Проверяет refresh-токен и возвращает новый accessToken
     */
    public String validateAndCreateAccessToken(String refreshTokenValue) {
        Optional<RefreshToken> optionalToken = refreshTokenRepository.findByToken(refreshTokenValue);

        if (optionalToken.isEmpty()) {
            throw new CustomException("Неверный refresh-токен");
        }

        RefreshToken token = optionalToken.get();

        // Проверяем срок действия
        if (token.getExpiryDate().before(new java.util.Date())) {
            refreshTokenRepository.delete(token);
            throw new CustomException("Refresh-токен истёк");
        }

        // Генерируем новый accessToken
        return jwtUtil.generateAccessToken(token.getUser().getUsername());
    }

    /**
     * Удаляет refresh-токен пользователя (например, при logout)
     */
    public void deleteByUser(User user) {
        refreshTokenRepository.deleteByUser(user);
    }
}
