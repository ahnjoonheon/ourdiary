package com.example.ourdiary.member.mapper;

import com.example.ourdiary.member.dto.*;
import com.example.ourdiary.member.entity.Member;
import com.example.ourdiary.member.mapper.qualifier.PathToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.nio.file.Path;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(target = "profilePicPath", ignore = true)
    @Mapping(target = "id", ignore = true)
    Member toMember(MemberRequest memberRequest);

    @Mapping(target = "profilePicPath", source = "profilePicPath", qualifiedBy = PathToString.class)
    MemberResponse toRegisterMemberResponse(Member member);
    @Mapping(target = "profilePicPath", source = "profilePicPath", qualifiedBy = PathToString.class)
    MemberAutocompleteResponse toMemberAutocompleteResponse(Member member);

    @Mapping(target = "profilePicPath", source = "profilePicPath", qualifiedBy = PathToString.class)
    MemberSearchResponse toMemberSearchResponse(Member member);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "profilePicPath", ignore = true)
    Member toMember(MemberSearchRequest memberSearchRequest);

    @PathToString
    default String stringToPath(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }
}
