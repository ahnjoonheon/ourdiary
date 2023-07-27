package com.example.ourdiary.authentication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "비밀번호 초기화")
public record ResetPasswordRequest(
        @Schema(description = "이메일", type = "string", example = "universal304015@gmail.com")
        String email
) {
}
