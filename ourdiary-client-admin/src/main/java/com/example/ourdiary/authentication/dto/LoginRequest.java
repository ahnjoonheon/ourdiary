package com.example.ourdiary.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "로그인")
public record LoginRequest(
        @Schema(description = "이메일", type = "string", example = "test0000@gmail.com")
        String email,
        @Schema(description = "비밀번호", type = "string", example = "0000")
        String password) {
}
