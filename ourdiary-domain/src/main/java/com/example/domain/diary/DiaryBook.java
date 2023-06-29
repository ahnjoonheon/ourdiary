package com.example.domain.diary;

import com.example.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "diary_book")
public class DiaryBook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryBookId;
    private String name;
    private String description;
    private String backgroundImage;
    private String backgroundColor;

    @Builder
    public DiaryBook(Long diaryBookId, String name, String description, String backgroundImage, String backgroundColor) {
        this.diaryBookId = diaryBookId;
        this.name = name;
        this.description = description;
        this.backgroundImage = backgroundImage;
        this.backgroundColor = backgroundColor;
    }
}
