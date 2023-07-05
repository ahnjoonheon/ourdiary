package com.example.ourdiary.admin.api.user.mapper;

import com.example.ourdiary.admin.api.user.dto.*;
import com.example.ourdiary.user.entity.User;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(RegisterUserRequest registerUserRequest);

    RegisterUserResponse toRegisterUserResponse(User user);

    List<UserAutocompleteResponse> toUserAutocompleteResponse(List<User> users);

    UserSearchResponse toUserSearchResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toUser(UserSearchRequest userSearchRequest);
}
