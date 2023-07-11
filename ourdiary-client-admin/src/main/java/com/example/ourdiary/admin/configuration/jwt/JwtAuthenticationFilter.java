package com.example.ourdiary.admin.configuration.jwt;

import com.example.ourdiary.admin.configuration.jwt.vo.JwtToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        JwtToken jwtToken = jwtTokenProvider.resolveToken(request);
        if (jwtToken != null && jwtTokenProvider.validateToken(jwtToken)) {
                SecurityContextHolder.getContext().setAuthentication(jwtTokenProvider.getAuthentication(jwtToken));
        }
        filterChain.doFilter(request, response);
    }
}
