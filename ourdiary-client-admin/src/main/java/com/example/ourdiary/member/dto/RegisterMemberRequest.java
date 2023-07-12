package com.example.ourdiary.member.dto;


public record RegisterMemberRequest(
        String name,
        String email,
        String password,
        String profilePic,
        String nickname
) {
}
