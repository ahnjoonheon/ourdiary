package com.example.ourdiary.admin.api.user.dto;


public record RegisterUserRequest(
        String username,
        String email,
        String password,
        String profilePic,
        String nickname
) {
}
