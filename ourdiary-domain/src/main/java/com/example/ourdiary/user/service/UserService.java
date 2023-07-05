package com.example.ourdiary.user.service;

import com.example.ourdiary.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    List<User> searchUserBy(String userAttribute);

    Page<User> searchUserBy(User user, Pageable pageable);
}
