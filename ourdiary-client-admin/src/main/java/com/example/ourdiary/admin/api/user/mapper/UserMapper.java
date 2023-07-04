package com.example.ourdiary.admin.api.user.mapper;

import com.example.ourdiary.admin.api.user.dto.RegisterUserRequest;
import com.example.ourdiary.admin.api.user.dto.RegisterUserResponse;
import com.example.ourdiary.admin.api.user.dto.UserAutocompleteResponse;
import com.example.ourdiary.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(RegisterUserRequest registerUserRequest);
    RegisterUserResponse toRegisterUserResponse(User user);

    List<UserAutocompleteResponse> toUserAutocompleteResponse(List<User> users);



}
