package com.fundoo.notes.service;

import com.fundoo.notes.dto.AuthResponse;
import com.fundoo.notes.dto.ForgotPasswordRequest;
import com.fundoo.notes.dto.LoginRequest;
import com.fundoo.notes.dto.RegisterRequest;
import com.fundoo.notes.dto.ResetPasswordRequest;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenBlacklistService tokenBlacklistService;
    private final PasswordResetService passwordResetService;

    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(token, "User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtService.generateToken(user.getEmail());

        tokenBlacklistService.cacheActiveToken(
                token,
                user.getEmail(),
                jwtService.getExpirationTime()
        );

        return new AuthResponse(token, "Login successful");
    }

    public String logout(String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Invalid authorization header");
        }

        String token = authHeader.substring(7).trim();

        tokenBlacklistService.removeActiveToken(token);

        tokenBlacklistService.blacklistToken(token, jwtService.getExpirationTime());

        return "Logout successful. Token removed from Redis cache and blacklisted.";
    }

    public String forgotPassword(ForgotPasswordRequest request) {

        return passwordResetService.generateResetToken(request.getEmail());
    }

    public String resetPassword(ResetPasswordRequest request) {

        return passwordResetService.resetPassword(
                request.getToken(),
                request.getNewPassword()
        );
    }
}