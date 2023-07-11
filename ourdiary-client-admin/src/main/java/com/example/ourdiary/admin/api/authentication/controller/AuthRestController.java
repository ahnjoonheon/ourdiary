package com.example.ourdiary.admin.api.authentication.controller;

import com.example.ourdiary.admin.api.authentication.dto.LoginRequest;
import com.example.ourdiary.admin.api.authentication.dto.ResetPasswordRequest;
import com.example.ourdiary.admin.api.authentication.mapper.AuthMapper;
import com.example.ourdiary.admin.api.authentication.service.AuthenticationService;
import com.example.ourdiary.admin.configuration.jwt.vo.JwtToken;
import com.example.ourdiary.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;
    private final AuthMapper authMapper;

    public AuthRestController(MemberService memberService, AuthenticationService authenticationService, AuthMapper authMapper) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
        this.authMapper = authMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody LoginRequest loginRequest) {
        JwtToken jwtToken = authenticationService.login(authMapper.toMember(loginRequest));
        return ResponseEntity.ok(jwtToken);
    }

    @GetMapping("/reset-password")
    public ResponseEntity<HttpStatus> resetPassword(ResetPasswordRequest resetPasswordRequest) {
        memberService.resetPassword(resetPasswordRequest.email());
        return ResponseEntity.ok().build();
    }
}
