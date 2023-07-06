package com.example.ourdiary.member.service;

import com.example.ourdiary.member.entity.Member;
import com.example.ourdiary.member.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final UserRepository userRepository;

    public MemberServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Member registerUser(Member member) {
        return userRepository.save(member);
    }

    @Override
    public List<Member> searchUserBy(String userAttribute) {
        return userRepository.findTop5By(userAttribute);
    }

    @Override
    public Page<Member> searchUserBy(Member member, Pageable pageable) {
        return userRepository.findBy(member, pageable);
    }
}
