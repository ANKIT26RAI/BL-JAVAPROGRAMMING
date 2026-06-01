package com.fundoo.notes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TokenBlacklistService {

    private final StringRedisTemplate redisTemplate;

    private static final String BLACKLIST_PREFIX = "blacklisted_token:";
    private static final String ACTIVE_TOKEN_PREFIX = "active_token:";

    public void cacheActiveToken(String token, String email, long expirationMillis) {
        redisTemplate.opsForValue().set(
                ACTIVE_TOKEN_PREFIX + token,
                email,
                expirationMillis,
                TimeUnit.MILLISECONDS
        );
    }

    public boolean isTokenActive(String token) {
        Boolean exists = redisTemplate.hasKey(ACTIVE_TOKEN_PREFIX + token);
        return Boolean.TRUE.equals(exists);
    }

    public void removeActiveToken(String token) {
        redisTemplate.delete(ACTIVE_TOKEN_PREFIX + token);
    }

    public void blacklistToken(String token, long expirationMillis) {
        redisTemplate.opsForValue().set(
                BLACKLIST_PREFIX + token,
                "blacklisted",
                expirationMillis,
                TimeUnit.MILLISECONDS
        );
    }

    public boolean isTokenBlacklisted(String token) {
        Boolean exists = redisTemplate.hasKey(BLACKLIST_PREFIX + token);
        return Boolean.TRUE.equals(exists);
    }
}