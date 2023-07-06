package com.example.ourdiary.member.dto;

import com.example.ourdiary.member.entity.Member;
import com.querydsl.core.annotations.QueryProjection;

import java.io.Serializable;

/**
 * DTO for {@link Member}
 */
public record UserAutocompleteDto(
        Long id,
        String name,
        String email,
        String profilePic,
        String nickname) implements Serializable {
    @QueryProjection
    public UserAutocompleteDto {
        // Record constructor for Projection
    }
}