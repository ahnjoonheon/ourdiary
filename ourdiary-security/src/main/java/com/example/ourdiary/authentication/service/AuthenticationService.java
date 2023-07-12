package com.example.ourdiary.authentication.service;

import com.example.ourdiary.configuration.security.jwt.vo.JwtToken;
import com.example.ourdiary.member.entity.Member;

public interface AuthenticationService {
    JwtToken login(Member member);
}
