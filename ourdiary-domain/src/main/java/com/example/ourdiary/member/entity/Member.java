package com.example.ourdiary.member.entity;

import com.example.ourdiary.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serial;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member", indexes = {
        @Index(name = "uk_member_email", columnList = "email", unique = true)
})
public class Member extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -5533781566000935006L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Convert(converter = PathConverter.class)
    @Column(name = "profile_pic_path", length = 200)
    private Path profilePicPath;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @OneToMany(mappedBy = "member")
    private List<MemberAuthority> authorities = new ArrayList<>();

    @Builder
    public Member(Long id, String name, String email, String password, Path profilePicPath, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicPath = profilePicPath;
        this.nickname = nickname;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }

    public void resetPassword(String password, PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void saveProfilePic(Path profilePicPath) {
        this.profilePicPath = profilePicPath;
    }

    public Member update(Member member) {
        this.name = member.getName();
        this.nickname = member.getNickname();
        return this;
    }


}