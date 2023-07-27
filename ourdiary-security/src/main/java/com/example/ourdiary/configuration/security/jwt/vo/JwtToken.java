package com.example.ourdiary.configuration.security.jwt.vo;

public class JwtToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String stringify() {
        return token;
    }
}
