package com.example.ourdiary.user.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.io.Serializable;

/**
 * DTO for {@link com.example.ourdiary.user.entity.User}
 */
public record UserAutocompleteDto(
        Long id,
        String username,
        String email,
        String profilePic,
        String nickname) implements Serializable {
    @QueryProjection
    public UserAutocompleteDto {
        // Record constructor for Projection
    }
}