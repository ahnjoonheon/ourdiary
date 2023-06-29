package com.example.domain.user;

import com.example.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String profilePic;
    private String nickname;
    private LocalDateTime lastLoginAt;

    @Builder
    public User(Long userId, String name, String email, String password, String profilePic, String nickname, LocalDateTime lastLoginAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.nickname = nickname;
        this.lastLoginAt = lastLoginAt;
    }
}
