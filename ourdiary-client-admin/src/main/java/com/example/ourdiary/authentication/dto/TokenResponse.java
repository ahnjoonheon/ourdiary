package com.example.ourdiary.authentication.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken) {
}
