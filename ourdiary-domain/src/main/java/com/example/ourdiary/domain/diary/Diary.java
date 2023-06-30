package com.example.ourdiary.domain.diary;

import com.example.ourdiary.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "diaries")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "diary_name", nullable = false, length = 100)
    private String diaryName;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "background_image", length = 200)
    private String backgroundImage;

    @Column(name = "theme", length = 50)
    private String theme;

}