package com.example.ourdiary.admin.api.user.dto;

public record UserSearchResponse(
        Long id,
        String username,
        String nickname,
        String email,
        String profilePic
        ) {
}
