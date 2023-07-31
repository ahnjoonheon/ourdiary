package com.example.ourdiary.member.repository;

import com.example.ourdiary.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberQueryDslRepository {
    List<Member> findTop5By(String userAttribute);

    Page<Member> findBy(Member member, Pageable pageable);
}
