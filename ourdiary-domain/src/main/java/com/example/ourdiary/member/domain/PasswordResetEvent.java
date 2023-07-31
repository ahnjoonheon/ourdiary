package com.example.ourdiary.member.domain;

public record PasswordResetEvent(String email, String initPassword) {
    public static PasswordResetEvent issue(String email, String initPassword) {
        return new PasswordResetEvent(email, initPassword);
    }
}
