package com.example.ourdiary.member.repository;

import com.example.ourdiary.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Member, Long>, UserQueryDslRepository {
    Optional<Member> findByEmail(String email);
}
