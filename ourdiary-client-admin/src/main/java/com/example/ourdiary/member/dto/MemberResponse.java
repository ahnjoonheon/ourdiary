package com.example.ourdiary.member.dto;

public record MemberResponse(
        Long id,
        String name,
        String email,
        String profilePicPath,
        String nickname) {
}
