package com.example.ourdiary.admin.api.member.dto;


public record RegisterMemberRequest(
        String name,
        String email,
        String password,
        String profilePic,
        String nickname
) {
}
