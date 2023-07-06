package com.example.ourdiary.admin.api.user.mapper;

import com.example.ourdiary.admin.api.user.dto.*;
import com.example.ourdiary.member.entity.Member;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "memberAuthorities", ignore = true)
    @Mapping(target = "id", ignore = true)
    Member toMember(RegisterMemberRequest registerMemberRequest);

    RegisterMemberResponse toRegisterMemberResponse(Member member);

    List<MemberAutocompleteResponse> toMemberAutocompleteResponse(List<Member> members);

    MemberSearchResponse toMemberSearchResponse(Member member);

    @Mapping(target = "memberAuthorities", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "profilePic", ignore = true)
    Member toMember(MemberSearchRequest memberSearchRequest);
}
