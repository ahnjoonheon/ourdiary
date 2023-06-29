package com.example.domain.user;

import com.example.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "email_verification")
public class EmailVerification extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long verificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String verificationCode;
    private LocalDateTime expiresAt;

    @Builder
    public EmailVerification(Long verificationId, User user, String verificationCode, LocalDateTime expiresAt) {
        this.verificationId = verificationId;
        this.user = user;
        this.verificationCode = verificationCode;
        this.expiresAt = expiresAt;
    }
}
