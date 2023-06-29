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
@Table(name = "diary")
public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @ManyToOne
    @JoinColumn(name = "diary_book_id")
    private DiaryBook diaryBook;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String content;
    private String tags;

    @Builder
    public Diary(Long diaryId, DiaryBook diaryBook, User user, String title, String content, String tags) {
        this.diaryId = diaryId;
        this.diaryBook = diaryBook;
        this.user = user;
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
}
