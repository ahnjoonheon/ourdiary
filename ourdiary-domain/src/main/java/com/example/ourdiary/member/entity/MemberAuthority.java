package com.example.ourdiary.member.entity;

import com.example.ourdiary.constant.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member_authority", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_authority", columnNames = {"member_id", "authority"})
})
public class MemberAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Authority authority;

    public MemberAuthority(Member member, Authority authority) {
        this.member = member;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Authority getAuthority() {
        return authority;
    }
}
