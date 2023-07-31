package com.example.ourdiary.member.repository;

import com.example.ourdiary.member.domain.Member;
import com.example.ourdiary.member.domain.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class MemberQueryDslRepositoryImpl implements MemberQueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public MemberQueryDslRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Member> findTop5By(String userAttribute) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.or(containsName(userAttribute))
                .or(containsEmail(userAttribute))
                .or(containsNickname(userAttribute));
        return jpaQueryFactory.selectFrom(QMember.member)
                .where(booleanBuilder)
                .limit(5)
                .fetch();
    }

    private static BooleanExpression containsEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return QMember.member.email.containsIgnoreCase(email);
    }

    private static BooleanExpression containsName(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return QMember.member.name.containsIgnoreCase(username);
    }

    private static BooleanExpression containsNickname(String nickname) {
        if (StringUtils.isEmpty(nickname)) {
            return null;
        }
        return QMember.member.nickname.containsIgnoreCase(nickname);
    }

    @Override
    public Page<Member> findBy(Member member, Pageable pageable) {
        List<Member> members = getUsersBy(member, pageable);
        Long count = getCountBy(member);
        return new PageImpl<>(members, pageable, count);
    }

    private Long getCountBy(Member member) {
        return jpaQueryFactory.select(QMember.member.count())
                .from(QMember.member)
                .where(containsName(member.getName()),
                        containsNickname(member.getNickname()),
                        containsEmail(member.getEmail())
                )
                .fetchOne();
    }

    private List<Member> getUsersBy(Member member, Pageable pageable) {
        return jpaQueryFactory.selectFrom(QMember.member)
                .where(containsName(member.getName()),
                        containsNickname(member.getNickname()),
                        containsEmail(member.getEmail())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }


}
