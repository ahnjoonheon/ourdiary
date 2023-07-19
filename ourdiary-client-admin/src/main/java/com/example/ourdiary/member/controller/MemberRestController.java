package com.example.ourdiary.member.controller;

import com.example.ourdiary.member.dto.*;
import com.example.ourdiary.member.mapper.MemberMapper;
import com.example.ourdiary.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "회원", description = "회원 API")
@RestController
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;

    private final MemberMapper memberMapper;

    public MemberRestController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @Operation(summary = "회원 등록", description = "회원을 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = RegisterMemberResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid status value",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content)
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RegisterMemberResponse> registerUser(@ModelAttribute RegisterMemberRequest registerMemberRequest) throws IOException {
        return ResponseEntity.ok(
                memberMapper.toRegisterMemberResponse(memberService.registerUser(memberMapper.toMember(registerMemberRequest), registerMemberRequest.profilePic()))
        );
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
