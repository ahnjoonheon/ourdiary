package com.example.ourdiary.admin.api.user.controller;

import com.example.ourdiary.admin.api.user.dto.*;
import com.example.ourdiary.admin.api.user.mapper.UserMapper;
import com.example.ourdiary.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UserRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        return ResponseEntity.ok(userMapper.toRegisterUserResponse(userService.registerUser(userMapper.toUser(registerUserRequest))));
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<UserAutocompleteResponse>> searchUserBy(UserAutocompleteRequest userAutocompleteRequest) {
        return ResponseEntity.ok(userMapper.toUserAutocompleteResponse(userService.searchUserBy(userAutocompleteRequest.userAttribute())));
    }

    @GetMapping
    public ResponseEntity<Page<UserSearchResponse>> searchUserBy(UserSearchRequest userSearchRequest, Pageable pageable) {
        return ResponseEntity.ok(userService.searchUserBy(userMapper.toUser(userSearchRequest), pageable).map(userMapper::toUserSearchResponse));
    }
}
