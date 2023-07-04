package com.example.ourdiary.user.service;

import com.example.ourdiary.user.entity.User;
import com.example.ourdiary.user.repository.UserRepository;
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
    public List<User> getUser(User user) {
        return userRepository.findAllBy(user);
    }
}
