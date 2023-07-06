package com.example.ourdiary.admin.api.user.dto;

public record RegisterMemberResponse(
        Long id,
        String name,
        String email,
        String profilePic,
        String nickname) {
}
