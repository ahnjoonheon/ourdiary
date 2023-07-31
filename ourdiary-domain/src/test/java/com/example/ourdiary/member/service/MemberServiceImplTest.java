package com.example.ourdiary.member.service;

import com.example.ourdiary.DomainEventPublisher;
import com.example.ourdiary.member.domain.Member;
import com.example.ourdiary.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@DisplayName("MemberService 테스트")
@ExtendWith(MockitoExtension.class)
class MemberServiceImplTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private Member mockMember;

    @Mock
    private DomainEventPublisher domainEventPublisher;

    @InjectMocks
    private MemberServiceImpl memberService;

    @Test
    void registerUser() throws IOException {
        // Given
        given(memberRepository.save(any(Member.class))).willReturn(mockMember);

        MockMultipartFile mockMultipartFile = new MockMultipartFile("profilePicture", "test.jpg", "image/jpeg", "test".getBytes());
        // When
        final Member member = memberService.registerUser(this.mockMember, mockMultipartFile);

        // Then
        assertThat(member).isNotNull();
    }

    @Test
    void searchUserWithPageable() {
        // Given
        Page<Member> memberPage = new PageImpl<>(List.of(mockMember, mockMember));
        given(this.memberRepository.findBy(any(Member.class),any(Pageable.class))).willReturn(memberPage);

        // When
        final Page<Member> result = this.memberService.searchUserBy(mockMember, PageRequest.of(0, 10));

        // Then
        assertThat(result.getSize()).isEqualTo(2);
    }

    @Test
    void searchUserBy() {
        given(this.memberRepository.findTop5By(any(String.class))).willReturn(List.of(mockMember, mockMember));

        // When
        final List<Member> result = this.memberService.searchUserBy("test");

        // Then
        assertThat(result).hasSize(2);
    }

    @Test
    void resetPassword() {
        // Given
        given(memberRepository.findByEmail(anyString())).willReturn(Optional.of(mockMember));

        // When
        memberService.resetPassword("test@example.com");

        // Then
        verify(mockMember).resetPassword(anyString());
    }
}