package com.example.ourdiary.member.repository;

import com.example.ourdiary.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryDslRepository {
    Optional<Member> findByEmail(String email);
}
