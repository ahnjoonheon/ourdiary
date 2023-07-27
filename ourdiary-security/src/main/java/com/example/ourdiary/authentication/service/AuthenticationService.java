package com.example.ourdiary.authentication.service;

import com.example.ourdiary.configuration.security.jwt.vo.JwtTokens;
import com.example.ourdiary.member.entity.Member;
import jakarta.servlet.http.Cookie;

import java.util.List;

public interface AuthenticationService {
    JwtTokens issueToken(Member member);
    List<Cookie> login(Member member);

    List<Cookie> logout();

}
