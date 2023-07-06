package com.example.ourdiary.admin.api.user.controller;

import com.example.ourdiary.admin.api.user.dto.*;
import com.example.ourdiary.admin.api.user.mapper.UserMapper;
import com.example.ourdiary.member.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final MemberService memberService;

    private final UserMapper userMapper;

    public UserRestController(MemberService memberService, UserMapper userMapper) {
        this.memberService = memberService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<RegisterMemberResponse> registerUser(@RequestBody RegisterMemberRequest registerMemberRequest) {
        return ResponseEntity.ok(userMapper.toRegisterMemberResponse(memberService.registerUser(userMapper.toMember(registerMemberRequest))));
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<MemberAutocompleteResponse>> searchUserBy(UserAutocompleteRequest userAutocompleteRequest) {
        return ResponseEntity.ok(userMapper.toMemberAutocompleteResponse(memberService.searchUserBy(userAutocompleteRequest.userAttribute())));
    }

    @GetMapping
    public ResponseEntity<Page<MemberSearchResponse>> searchUserBy(MemberSearchRequest memberSearchRequest, Pageable pageable) {
        return ResponseEntity.ok(memberService.searchUserBy(userMapper.toMember(memberSearchRequest), pageable).map(userMapper::toMemberSearchResponse));
    }
}
