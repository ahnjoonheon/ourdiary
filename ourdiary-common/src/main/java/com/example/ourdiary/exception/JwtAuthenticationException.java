package com.example.ourdiary.exception;

public class JwtAuthenticationException extends RuntimeException{
    public JwtAuthenticationException() {
        super("Invalid JWT Token");
    }

    public JwtAuthenticationException(String message) {
        super(message);
    }
}
