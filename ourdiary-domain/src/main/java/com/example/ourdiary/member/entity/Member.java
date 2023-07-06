package com.example.ourdiary.member.entity;

import com.example.ourdiary.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member", indexes = {
        @Index(name = "uk_member_email", columnList = "email", unique = true)
})
public class Member extends BaseEntity {
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

    @Column(name = "profile_pic", length = 200)
    private String profilePic;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @OneToMany(mappedBy = "member")
    private List<MemberAuthority> memberAuthorities;

    @Builder
    public Member(Long id, String name, String email, String password, String profilePic, String nickname, List<MemberAuthority> memberAuthorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePic = profilePic;
        this.nickname = nickname;
        this.memberAuthorities = memberAuthorities;
    }
}