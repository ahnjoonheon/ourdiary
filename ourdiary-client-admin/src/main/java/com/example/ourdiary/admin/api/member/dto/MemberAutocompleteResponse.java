package com.example.ourdiary.admin.api.member.dto;


public record MemberAutocompleteResponse(
        Long id,
        String name,
        String email,
        String nickname,
        String profilePic
) {
}
