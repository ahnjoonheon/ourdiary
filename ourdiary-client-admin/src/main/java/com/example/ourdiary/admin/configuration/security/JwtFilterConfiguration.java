package com.example.ourdiary.admin.configuration.security;

import com.example.ourdiary.authentication.jwt.JwtAuthenticationFilter;
import com.example.ourdiary.authentication.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfiguration {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtFilterConfiguration(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtTokenProvider);
    }

    @Bean JwtAuthorizationFilter jwtAuthorizationFilter() {
        return new JwtAuthorizationFilter();
    }
}
