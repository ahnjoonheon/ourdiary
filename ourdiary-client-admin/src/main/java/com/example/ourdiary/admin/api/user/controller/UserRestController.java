package com.example.ourdiary.admin.api.user.controller;

import com.example.ourdiary.admin.api.user.dto.RegisterUserRequest;
import com.example.ourdiary.admin.api.user.dto.RegisterUserResponse;
import com.example.ourdiary.admin.api.user.dto.UserAutocompleteRequest;
import com.example.ourdiary.admin.api.user.dto.UserAutocompleteResponse;
import com.example.ourdiary.admin.api.user.mapper.UserMapper;
import com.example.ourdiary.user.service.UserService;
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
    public ResponseEntity<List<UserAutocompleteResponse>> getUser(UserAutocompleteRequest userAutocompleteRequest) {
        return ResponseEntity.ok(userMapper.toUserAutocompleteResponse(userService.getUser(userAutocompleteRequest.userAttribute())));
    }
}
