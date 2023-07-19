package com.example.ourdiary.member.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

@Schema(description = "회원 등록")
public record RegisterMemberRequest(
        @Schema(description = "이름", type = "string", example = "홍길동")
        String name,
        @Schema(description = "이메일", type = "string", example = "universal304015@gmail.com")
        String email,
        @Schema(description = "비밀번호", type = "string", example = "1234")
        String password,
        @Schema(description = "닉네임", type = "string", example = "홍길동")
        String nickname,
        @Schema(description = "프로필 사진", type = "file", example = "프로필 사진")
        MultipartFile profilePic
) {
}
