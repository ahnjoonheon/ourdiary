package com.example.ourdiary.authentication.entity;

import com.example.ourdiary.BaseEntity;
import com.example.ourdiary.constant.TokenStatus;
import com.example.ourdiary.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TokenStatus status;

    @Builder
    public RefreshToken(Long id, String username, String token, LocalDateTime expiredAt, TokenStatus status) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiredAt = expiredAt;
        this.status = status;
    }
}