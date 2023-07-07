package com.example.ourdiary.admin.api.member.dto;

public record MemberSearchResponse(
        Long id,
        String name,
        String nickname,
        String email,
        String profilePic
        ) {
}
