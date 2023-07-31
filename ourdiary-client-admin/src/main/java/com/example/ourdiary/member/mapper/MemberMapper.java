package com.example.ourdiary.member.mapper;

import com.example.ourdiary.member.domain.Member;
import com.example.ourdiary.member.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "profilePicPath", ignore = true)
    @Mapping(target = "id", ignore = true)
    Member toMember(MemberRequest memberRequest);

    @Mapping(target = "profilePicPath", source = "profilePicPath")
    MemberResponse toRegisterMemberResponse(Member member);
    @Mapping(target = "profilePicPath", source = "profilePicPath")
    MemberAutocompleteResponse toMemberAutocompleteResponse(Member member);

    @Mapping(target = "profilePicPath", source = "profilePicPath")
    MemberSearchResponse toMemberSearchResponse(Member member);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "profilePicPath", ignore = true)
    Member toMember(MemberSearchRequest memberSearchRequest);
}
