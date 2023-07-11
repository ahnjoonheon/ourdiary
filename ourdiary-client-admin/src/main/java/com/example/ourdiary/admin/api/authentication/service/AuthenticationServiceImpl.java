package com.example.ourdiary.admin.api.authentication.service;

import com.example.ourdiary.admin.configuration.jwt.JwtTokenProvider;
import com.example.ourdiary.admin.configuration.jwt.vo.JwtToken;
import com.example.ourdiary.member.entity.Member;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional(readOnly = true)
    @Override
    public JwtToken login(Member member) {
        String username = member.getEmail();
        String password = member.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtTokenProvider.generateToken(username, ((User) authentication.getPrincipal()).getAuthorities());
    }
}
