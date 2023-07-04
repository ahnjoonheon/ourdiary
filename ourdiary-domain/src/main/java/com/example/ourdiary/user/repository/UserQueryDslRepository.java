package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.User;

import java.util.List;

public interface UserQueryDslRepository {
    List<User> findAllBy(User user);
}
