package com.example.ourdiary.admin.api.user.dto;


public record RegisterMemberRequest(
        String name,
        String email,
        String password,
        String profilePic,
        String nickname
) {
}
