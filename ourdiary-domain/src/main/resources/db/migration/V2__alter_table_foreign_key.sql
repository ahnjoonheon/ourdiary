-- ADD CONSTRAINT phrases
ALTER TABLE diaries ADD CONSTRAINT fk_diaries_member FOREIGN KEY (member_id) REFERENCES member(id);
ALTER TABLE diary_participants ADD CONSTRAINT fk_diary_participants_diaries FOREIGN KEY (diary_id) REFERENCES diaries(diary_id);
ALTER TABLE diary_participants ADD CONSTRAINT fk_diary_participants_member FOREIGN KEY (member_id) REFERENCES member(id);
ALTER TABLE entries ADD CONSTRAINT fk_entries_diaries FOREIGN KEY (diary_id) REFERENCES diaries(diary_id);
ALTER TABLE comments ADD CONSTRAINT fk_comments_entries FOREIGN KEY (entry_id) REFERENCES entries(entry_id);
ALTER TABLE comments ADD CONSTRAINT fk_comments_member FOREIGN KEY (member_id) REFERENCES member(id);
ALTER TABLE entry_tags ADD CONSTRAINT fk_entry_tags_entries FOREIGN KEY (entry_id) REFERENCES entries(entry_id);
ALTER TABLE entry_tags ADD CONSTRAINT fk_entry_tags_tags FOREIGN KEY (tag_id) REFERENCES tags(tag_id);
ALTER TABLE sentiment_report ADD CONSTRAINT fk_sentiment_report_entries FOREIGN KEY (entry_id) REFERENCES entries(entry_id);
ALTER TABLE app_lock ADD CONSTRAINT fk_app_lock_member FOREIGN KEY (member_id) REFERENCES member(id);

ALTER TABLE tags ADD CONSTRAINT uk_tags_tag_name UNIQUE (tag_name);