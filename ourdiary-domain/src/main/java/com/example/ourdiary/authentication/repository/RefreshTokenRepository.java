package com.example.ourdiary.authentication.repository;

import com.example.ourdiary.authentication.entity.RefreshToken;
import com.example.ourdiary.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
