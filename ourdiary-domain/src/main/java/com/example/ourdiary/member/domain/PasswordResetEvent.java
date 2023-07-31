package com.example.ourdiary.member.domain;

public record PasswordResetEvent(String email, String userName, String initPassword) {
    public static PasswordResetEvent issue(String email, String userName, String initPassword) {
        return new PasswordResetEvent(email, userName, initPassword);
    }
}
