package com.example.ourdiary.configuration.security.jwt.vo;

public record JwtToken(String token) {

    public String stringify() {
        return token;
    }
}
