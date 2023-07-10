package com.example.ourdiary.member.service;

import com.example.ourdiary.member.entity.Member;
import com.example.ourdiary.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member registerUser(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> searchUserBy(String userAttribute) {
        return memberRepository.findTop5By(userAttribute);
    }

    @Override
    public Page<Member> searchUserBy(Member member, Pageable pageable) {
        return memberRepository.findBy(member, pageable);
    }
}
