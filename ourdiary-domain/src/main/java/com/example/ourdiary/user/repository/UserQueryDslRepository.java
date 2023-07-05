package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserQueryDslRepository {
    List<User> findTop5By(String userAttribute);

    Page<User> findBy(User user, Pageable pageable);
}
