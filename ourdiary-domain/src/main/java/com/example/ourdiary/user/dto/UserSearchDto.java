package com.example.ourdiary.user.dto;

import com.querydsl.core.annotations.QueryProjection;

public record UserSearchDto(
        String username,
        String email,
        String profilePic,
        String nickname
) {
    @QueryProjection
    public UserSearchDto {
        // Record constructor for Projection
    }
}
