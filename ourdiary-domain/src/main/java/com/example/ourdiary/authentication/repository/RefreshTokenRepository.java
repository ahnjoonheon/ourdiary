package com.example.ourdiary.authentication.repository;

import com.example.ourdiary.authentication.domain.JwtToken;
import com.example.ourdiary.authentication.domain.RefreshToken;
import com.example.ourdiary.constant.TokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByTokenAndStatus(JwtToken token, TokenStatus status);
}
