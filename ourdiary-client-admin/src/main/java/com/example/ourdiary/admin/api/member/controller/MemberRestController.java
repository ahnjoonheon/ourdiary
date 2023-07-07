package com.example.ourdiary.admin.api.member.controller;

import com.example.ourdiary.admin.api.member.dto.*;
import com.example.ourdiary.admin.api.member.mapper.MemberMapper;
import com.example.ourdiary.member.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;

    private final MemberMapper memberMapper;

    public MemberRestController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity<RegisterMemberResponse> registerUser(@RequestBody RegisterMemberRequest registerMemberRequest) {
        return ResponseEntity.ok(memberMapper.toRegisterMemberResponse(memberService.registerUser(memberMapper.toMember(registerMemberRequest))));
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<MemberAutocompleteResponse>> searchUserBy(MemberAutocompleteRequest memberAutocompleteRequest) {
        return ResponseEntity.ok(memberMapper.toMemberAutocompleteResponse(memberService.searchUserBy(memberAutocompleteRequest.userAttribute())));
    }

    @GetMapping
    public ResponseEntity<Page<MemberSearchResponse>> searchUserBy(MemberSearchRequest memberSearchRequest, Pageable pageable) {
        return ResponseEntity.ok(memberService.searchUserBy(memberMapper.toMember(memberSearchRequest), pageable).map(memberMapper::toMemberSearchResponse));
    }
}
