package com.example.ourdiary.authentication.mapper;

import com.example.ourdiary.authentication.dto.TokenResponse;
import com.example.ourdiary.authentication.vo.JwtTokens;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    @Mapping(target = "accessToken", source = "accessToken.token")
    @Mapping(target = "refreshToken", source = "refreshToken.token")
    TokenResponse toTokenResponse(JwtTokens jwtTokens);
}
