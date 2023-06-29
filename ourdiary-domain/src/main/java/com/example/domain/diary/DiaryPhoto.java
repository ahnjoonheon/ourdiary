package com.example.domain.diary;

import com.example.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "diary_photo")
public class DiaryPhoto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long photoId;

    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    private String photoUrl;
    private String description;
    private String tags;

    @Builder
    public DiaryPhoto(Long photoId, Diary diary, String photoUrl, String description, String tags) {
        this.photoId = photoId;
        this.diary = diary;
        this.photoUrl = photoUrl;
        this.description = description;
        this.tags = tags;
    }
}
