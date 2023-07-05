package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserQueryDslRepository {

}
