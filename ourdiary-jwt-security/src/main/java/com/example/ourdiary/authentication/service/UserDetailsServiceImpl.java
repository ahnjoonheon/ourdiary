package com.example.ourdiary.authentication.service;

import com.example.ourdiary.member.entity.Member;
import com.example.ourdiary.member.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("E-Mail Not Found : %s".formatted(username)));
        return new User(member.getEmail(), member.getPassword(), member.getAuthorities());
    }
}
