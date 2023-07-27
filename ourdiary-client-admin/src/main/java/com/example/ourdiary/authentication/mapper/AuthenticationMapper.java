package com.example.ourdiary.authentication.mapper;

import com.example.ourdiary.authentication.dto.LoginRequest;
import com.example.ourdiary.authentication.dto.TokenResponse;
import com.example.ourdiary.configuration.security.jwt.vo.JwtToken;
import com.example.ourdiary.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {

    @Mapping(target = "profilePicPath", ignore = true)
    @Mapping(target = "nickname", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "id", ignore = true)
    Member toMember(LoginRequest loginRequest);


    @Mapping(target = "token", source = "token")
    TokenResponse toTokenResponse(JwtToken jwtToken);
}
