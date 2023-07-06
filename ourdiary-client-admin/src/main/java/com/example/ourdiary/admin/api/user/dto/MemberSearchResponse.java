package com.example.ourdiary.admin.api.user.dto;

public record MemberSearchResponse(
        Long id,
        String name,
        String nickname,
        String email,
        String profilePic
        ) {
}
