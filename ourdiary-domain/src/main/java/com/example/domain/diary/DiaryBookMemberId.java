package com.example.domain.diary;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class DiaryBookMemberId implements Serializable {

    private Long diaryBook;
    private Long user;

    @Builder
    public DiaryBookMemberId(Long diaryBook, Long user) {
        this.diaryBook = diaryBook;
        this.user = user;
    }
}
