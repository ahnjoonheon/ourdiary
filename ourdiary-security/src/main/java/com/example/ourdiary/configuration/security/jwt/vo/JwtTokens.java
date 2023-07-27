package com.example.ourdiary.configuration.security.jwt.vo;

import lombok.Builder;

public record JwtTokens(JwtToken accessToken, JwtToken refreshToken) {

    @Builder
    public JwtTokens {
        if (accessToken == null || refreshToken == null) {
            throw new IllegalArgumentException("accessToken and refreshToken must not be null");
        }
    }
}
