package com.example.ourdiary.admin.api.user.dto;

public record RegisterUserResponse(
        Long id,
        String username,
        String email,
        String profilePic,
        String nickname) {
}
