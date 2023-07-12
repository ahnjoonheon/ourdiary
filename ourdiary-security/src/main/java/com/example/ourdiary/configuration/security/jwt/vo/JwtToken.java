package com.example.ourdiary.configuration.security.jwt.vo;

public class JwtToken {
    private String token;

    public JwtToken() {
    }

    public JwtToken(String token) {
        this.token = token;
    }

    public boolean hasBearerPrefix() {
        return token != null && token.startsWith("Bearer ");
    }
    
    public JwtToken removeBearerPrefix() {
        this.token = this.token.substring(7);
        return this;
    }

    public String stringify() {
        return token;
    }

    public String getToken() {
        return token;
    }
}
