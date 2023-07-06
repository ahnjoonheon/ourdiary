package com.example.ourdiary.user.repository;

import com.example.ourdiary.user.entity.QUser;
import com.example.ourdiary.user.entity.User;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class UserQueryDslRepositoryImpl implements UserQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public UserQueryDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<User> findTop5By(String userAttribute) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(containsUsername(userAttribute));
        booleanBuilder.or(containsEmail(userAttribute));
        booleanBuilder.or(containsNickname(userAttribute));
        return jpaQueryFactory.selectFrom(QUser.user)
                .where(booleanBuilder)
                .limit(5)
                .fetch();
    }

    private static BooleanExpression containsEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return QUser.user.email.containsIgnoreCase(email);
    }

    private static BooleanExpression containsUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return QUser.user.username.containsIgnoreCase(username);
    }

    private static BooleanExpression containsNickname(String nickname) {
        if (StringUtils.isEmpty(nickname)) {
            return null;
        }
        return QUser.user.nickname.containsIgnoreCase(nickname);
    }

    @Override
    public Page<User> findBy(User user, Pageable pageable) {
        List<User> users = getUsersBy(user, pageable);
        Long count = getCountBy(user);
        return new PageImpl<>(users, pageable, count);
    }

    private Long getCountBy(User user) {
        return jpaQueryFactory.select(QUser.user.count())
                .from(QUser.user)
                .where(containsUsername(user.getUsername()),
                        containsNickname(user.getNickname()),
                        containsEmail(user.getEmail())
                )
                .fetchOne();
    }

    private List<User> getUsersBy(User user, Pageable pageable) {
        return jpaQueryFactory.selectFrom(QUser.user)
                .where(containsUsername(user.getUsername()),
                        containsNickname(user.getNickname()),
                        containsEmail(user.getEmail())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


}
