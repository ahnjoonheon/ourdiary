package com.example.ourdiary.user.service;

import com.example.ourdiary.user.entity.User;
import com.example.ourdiary.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> searchUserBy(String userAttribute) {
        return userRepository.findTop5By(userAttribute);
    }

    @Override
    public Page<User> searchUserBy(User user, Pageable pageable) {
        return userRepository.findBy(user, pageable);
    }
}
