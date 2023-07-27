package com.example.ourdiary.authentication.service;

import com.example.ourdiary.authentication.entity.RefreshToken;
import com.example.ourdiary.authentication.repository.RefreshTokenRepository;
import com.example.ourdiary.configuration.security.jwt.JwtTokenProvider;
import com.example.ourdiary.configuration.security.jwt.vo.JwtTokens;
import com.example.ourdiary.member.entity.Member;
import jakarta.servlet.http.Cookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, RefreshTokenRepository refreshTokenRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public JwtTokens issueToken(Member member) {
        String username = member.getEmail();
        String password = member.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.generateTokens(username, ((UserDetails) authentication.getPrincipal()).getAuthorities());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cookie> login(Member member) {
        JwtTokens jwtTokens = issueToken(member);



        return jwtTokenProvider.setTokens(jwtTokens);
    }

    @Override
    public List<Cookie> logout() {
        return jwtTokenProvider.initTokens();
    }
}
