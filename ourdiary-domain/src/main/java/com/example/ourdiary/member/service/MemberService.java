package com.example.ourdiary.member.service;

import com.example.ourdiary.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    Member registerUser(Member member);

    List<Member> searchUserBy(String userAttribute);

    Page<Member> searchUserBy(Member member, Pageable pageable);

    void resetPassword(String email);
}
