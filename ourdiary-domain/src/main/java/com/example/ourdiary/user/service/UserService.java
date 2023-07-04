package com.example.ourdiary.user.service;

import com.example.ourdiary.user.entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    List<User> getUser(String userAttribute);
}
