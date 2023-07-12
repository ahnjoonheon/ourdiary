package com.example.ourdiary.member.dto;

public record MemberSearchRequest(
        String name,
        String email,
        String nickname
) {
}
