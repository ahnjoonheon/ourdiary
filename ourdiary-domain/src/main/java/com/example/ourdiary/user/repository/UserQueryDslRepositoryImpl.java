package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.QUser;
import com.example.ourdiary.user.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

public class UserQueryDslRepositoryImpl implements UserQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<User> findAllBy(User user) {
        BooleanBuilder builder = new BooleanBuilder();
        if (user.getUsername() != null) {
            builder.or(QUser.user.nickname.contains(user.getUsername()).or(QUser.user.username.contains(user.getUsername())).or(QUser.user.email.contains(user.getUsername())));
        }
        if (user.getNickname() != null) {
            builder.or(QUser.user.nickname.contains(user.getNickname()).or(QUser.user.username.contains(user.getNickname())).or(QUser.user.email.contains(user.getNickname())));
        }
        if (user.getEmail() != null) {
            builder.or(QUser.user.nickname.contains(user.getEmail()).or(QUser.user.username.contains(user.getEmail())).or(QUser.user.email.contains(user.getEmail())));
        }

        return jpaQueryFactory.selectFrom(QUser.user)
                .where(builder)
                .fetch();
    }
}
