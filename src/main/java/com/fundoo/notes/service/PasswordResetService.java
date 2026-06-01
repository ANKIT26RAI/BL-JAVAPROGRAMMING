package com.fundoo.notes.service;

import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final StringRedisTemplate redisTemplate;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    private static final String RESET_TOKEN_PREFIX = "password_reset_token:";

    public String generateResetToken(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        String token = UUID.randomUUID().toString();

        redisTemplate.opsForValue().set(
                RESET_TOKEN_PREFIX + token,
                user.getEmail(),
                10,
                TimeUnit.MINUTES
        );

        emailService.sendPasswordResetEmail(user.getEmail(), token);

        return "Password reset token has been sent to your registered email.";
    }

    public String resetPassword(String token, String newPassword) {

        String email = redisTemplate.opsForValue().get(RESET_TOKEN_PREFIX + token);

        if (email == null) {
            throw new RuntimeException("Invalid or expired reset token");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);

        redisTemplate.delete(RESET_TOKEN_PREFIX + token);

        return "Password reset successful";
    }
}