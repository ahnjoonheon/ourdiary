package com.example.ourdiary.authentication.controller;

import com.example.ourdiary.authentication.dto.LoginRequest;
import com.example.ourdiary.authentication.dto.ResetPasswordRequest;
import com.example.ourdiary.authentication.dto.TokenResponse;
import com.example.ourdiary.authentication.mapper.AuthenticationMapper;
import com.example.ourdiary.authentication.service.AuthenticationService;
import com.example.ourdiary.configuration.security.jwt.vo.JwtToken;
import com.example.ourdiary.member.dto.MemberResponse;
import com.example.ourdiary.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
    private final MemberService memberService;
    private final AuthenticationService authenticationService;
    private final AuthenticationMapper authenticationMapper;

    public AuthenticationRestController(MemberService memberService, AuthenticationService authenticationService, AuthenticationMapper authenticationMapper) {
        this.memberService = memberService;
        this.authenticationService = authenticationService;
        this.authenticationMapper = authenticationMapper;
    }

    @Profile({"local", "dev"})
    @Operation(summary = "토큰 발행", description = "토큰을 발행합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = JwtToken.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content)
    })
    @PostMapping("/token")
    public ResponseEntity<TokenResponse> getToken(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationMapper.toTokenResponse(
                authenticationService.issueToken(authenticationMapper.toMember(loginRequest))));
    }

    //    @Profile({"prod"})
    @Operation(summary = "로그인", description = "로그인합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = MemberResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Cookie jwtTokenCookie = authenticationService.login(authenticationMapper.toMember(loginRequest));
        response.addCookie(jwtTokenCookie);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logout(HttpServletResponse response) {
        Cookie initializedCookie = authenticationService.logout();
        response.addCookie(initializedCookie);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/reset-password")
    public ResponseEntity<HttpStatus> resetPassword(ResetPasswordRequest resetPasswordRequest) {
        memberService.resetPassword(resetPasswordRequest.email());
        return ResponseEntity.ok().build();
    }
}
