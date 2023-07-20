package com.example.ourdiary.member.dto;

public record MemberSearchResponse(
        Long id,
        String name,
        String nickname,
        String email,
        String profilePicPath
        ) {
}
