package com.example.ourdiary.authentication.domain;

import com.example.ourdiary.BaseEntity;
import com.example.ourdiary.constant.TokenStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Convert(converter = JwtToken.JwtTokenConverter.class)
    @Column(name = "token", nullable = false)
    private JwtToken token;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TokenStatus status = TokenStatus.ENABLED;

    @Builder
    public RefreshToken(Long id, String username, JwtToken token, LocalDateTime expiredAt, TokenStatus status) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiredAt = expiredAt;
        this.status = status;
    }

    public static RefreshToken create(String username, JwtToken token, LocalDateTime expiredAt) {
        return RefreshToken.builder()
                .username(username)
                .token(token)
                .expiredAt(expiredAt)
                .status(TokenStatus.ENABLED)
                .build();
    }

    public void disable() {
        this.status = TokenStatus.DISABLED;
    }
}