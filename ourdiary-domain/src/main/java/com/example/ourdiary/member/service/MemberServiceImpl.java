package com.example.ourdiary.member.service;

import com.example.ourdiary.constant.FilePath;
import com.example.ourdiary.exception.MemberNotFoundException;
import com.example.ourdiary.file.FileService;
import com.example.ourdiary.member.entity.Member;
import com.example.ourdiary.member.repository.MemberRepository;
import com.example.ourdiary.message.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageService messageService;
    private final FileService fileService;

    public MemberServiceImpl(MemberRepository memberRepository, PasswordEncoder passwordEncoder, MessageService messageService, FileService fileService) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.messageService = messageService;
        this.fileService = fileService;
    }

    @Transactional
    @Override
    public Member registerUser(Member member, MultipartFile profilePicture) throws IOException {
        member.encodePassword(passwordEncoder);
        member.saveProfilePic(fileService.upload(profilePicture, FilePath.PROFILE_IMAGE.getPath()));
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> searchUserBy(String userAttribute) {
        return memberRepository.findTop5By(userAttribute);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Member> searchUserBy(Member member, Pageable pageable) {
        return memberRepository.findBy(member, pageable);
    }

    @Transactional
    @Override
    public void resetPassword(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException(messageService.get("exception.email-not-found", email)));
        member.resetPassword("0000",passwordEncoder);
    }
}
