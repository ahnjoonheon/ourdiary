package com.example.ourdiary.admin.api.user.dto;

public record UserAutocompleteResponse (
        Long id,
        String username,
        String email,
        String nickname
) {
}
