package com.example.ourdiary.member.dto;

public record RegisterMemberResponse(
        Long id,
        String name,
        String email,
        String profilePic,
        String nickname) {
}
