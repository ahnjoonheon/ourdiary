package com.example.ourdiary.admin.api.member.dto;

public record MemberSearchRequest(
        String name,
        String email,
        String nickname
) {
}
