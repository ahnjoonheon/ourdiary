package com.example.ourdiary.member.domain;

import com.example.ourdiary.BaseEntity;
import com.example.ourdiary.constant.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member_authority", uniqueConstraints = {
        @UniqueConstraint(name = "uk_user_authority", columnNames = {"member_id", "authority"})
})
public class MemberAuthority extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -5533781566000935006L;
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
}
