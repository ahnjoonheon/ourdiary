package com.example.ourdiary.member.dto;


public record MemberAutocompleteResponse(
        Long id,
        String name,
        String email,
        String nickname,
        String profilePicPath
) {
}
