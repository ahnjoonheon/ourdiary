package com.example.ourdiary.admin.api.user.dto;

public record UserSearchRequest(
        String username,
        String email,
        String nickname
) {
}
