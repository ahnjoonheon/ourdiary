package com.example.ourdiary.admin.api.authentication.mapper;

import com.example.ourdiary.admin.api.authentication.dto.LoginRequest;
import com.example.ourdiary.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Mapping(target = "profilePic", ignore = true)
    @Mapping(target = "nickname", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    Member toMember(LoginRequest loginRequest);
}
