package com.example.ourdiary.tag.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tags", indexes = {
        @Index(name = "uk_tags_tag_name", columnList = "tag_name", unique = true)
})
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false)
    private Long id;

    @Column(name = "tag_name", nullable = false, length = 50)
    private String tagName;

}