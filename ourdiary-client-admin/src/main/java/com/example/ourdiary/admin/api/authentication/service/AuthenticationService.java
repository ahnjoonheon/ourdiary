package com.example.ourdiary.admin.api.authentication.service;

import com.example.ourdiary.admin.configuration.jwt.vo.JwtToken;
import com.example.ourdiary.member.entity.Member;

public interface AuthenticationService {
    JwtToken login(Member member);
}
