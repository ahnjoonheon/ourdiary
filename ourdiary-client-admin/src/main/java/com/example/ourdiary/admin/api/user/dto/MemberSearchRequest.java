package com.example.ourdiary.admin.api.user.dto;

public record MemberSearchRequest(
        String name,
        String email,
        String nickname
) {
}
