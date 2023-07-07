package com.example.ourdiary.authentication.jwt;

import com.example.ourdiary.constant.Authority;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Value("${ourdiary.authorities}")
    private List<String> authorities;

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final int ADMIN_SERVER_PORT = 8080;
        final int USER_SERVER_PORT = 8081;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String token = jwtTokenProvider.resolveToken(request);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(Authority.ROLE_ADMIN.name());
                if (request.getServerPort() == ADMIN_SERVER_PORT) {
                    authority = new SimpleGrantedAuthority(Authority.ROLE_ADMIN.name());
                } else if (request.getServerPort() == USER_SERVER_PORT) {
                    authority = new SimpleGrantedAuthority(Authority.ROLE_USER.name());
                }
                if (authentication.getAuthorities().contains(authority)) {
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    throw new ServletException("Unauthorized access");
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
