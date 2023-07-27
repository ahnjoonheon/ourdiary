package com.example.ourdiary.authentication.service;

import com.example.ourdiary.configuration.security.jwt.vo.JwtToken;
import com.example.ourdiary.member.entity.Member;
import jakarta.servlet.http.Cookie;

public interface AuthenticationService {
    JwtToken issueToken(Member member);
    Cookie login(Member member);

    Cookie logout();

}
