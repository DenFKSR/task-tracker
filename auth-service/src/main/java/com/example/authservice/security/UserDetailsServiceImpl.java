package com.example.authservice.security;

import com.example.authservice.entity.User;
import com.example.authservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        // Возвращаешь Spring Security-совместимый объект
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(), // должен быть BCrypt-хэш!
                new ArrayList<>()   // роли можно добавить позже
        );
    }
}