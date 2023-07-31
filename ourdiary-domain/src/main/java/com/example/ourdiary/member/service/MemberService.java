package com.example.ourdiary.member.service;

import com.example.ourdiary.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MemberService {
    Member registerUser(Member member, MultipartFile multipartFile) throws IOException;

    Member updateUser(Member member, MultipartFile profilePicture) throws IOException;

    List<Member> searchUserBy(String userAttribute);

    Page<Member> searchUserBy(Member member, Pageable pageable);

    void resetPassword(String email);
}
