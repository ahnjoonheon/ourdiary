package com.example.ourdiary.admin.api.user.dto;

public record UserAutocompleteRequest(
        String username,
        String email,
        String nickname
) {
}
