package com.example.ourdiary.admin.api.authentication.controller;

import com.example.ourdiary.admin.api.authentication.mapper.AuthMapper;
import com.example.ourdiary.admin.api.authentication.dto.LoginRequest;
import com.example.ourdiary.admin.api.authentication.dto.LoginResponse;
import com.example.ourdiary.authentication.jwt.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

    public AuthRestController(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, AuthMapper authMapper) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.authMapper = authMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.email();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.password()));

        String token = jwtTokenProvider.generateToken(username, ((User) authentication.getPrincipal()).getAuthorities());


        return ResponseEntity.ok(new LoginResponse(username, token));
    }
}
