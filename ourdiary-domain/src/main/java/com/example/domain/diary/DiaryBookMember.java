package com.example.domain.diary;

import com.example.domain.BaseEntity;
import com.example.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "diary_book_member")
@IdClass(DiaryBookMemberId.class)
public class DiaryBookMember extends BaseEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "diary_book_id")
    private DiaryBook diaryBook;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String role;

    @Builder
    public DiaryBookMember(DiaryBook diaryBook, User user, String role) {
        this.diaryBook = diaryBook;
        this.user = user;
        this.role = role;
    }
}
