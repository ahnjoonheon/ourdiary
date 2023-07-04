package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.QUser;
import com.example.ourdiary.user.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import java.util.List;

public class UserQueryDslRepositoryImpl implements UserQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<User> findAllBy(String userAttribute) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.hasText(userAttribute)) {
            builder.and(QUser.user.nickname.contains(userAttribute).or(QUser.user.username.contains(userAttribute)).or(QUser.user.email.contains(userAttribute)));
        }

        return jpaQueryFactory.selectFrom(QUser.user)
                .where(builder)
                .fetch();
    }
}
