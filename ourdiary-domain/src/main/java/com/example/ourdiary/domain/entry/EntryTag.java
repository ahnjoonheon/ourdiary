package com.example.ourdiary.domain.entry;

import com.example.ourdiary.domain.tag.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entry_tags")
public class EntryTag {
    @EmbeddedId
    private EntryTagId id;

    @MapsId("entryId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

}