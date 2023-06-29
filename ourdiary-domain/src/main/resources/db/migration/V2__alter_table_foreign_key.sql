-- Alter Table for Foreign Key
ALTER TABLE email_verifications ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE diary_book_members ADD FOREIGN KEY (diary_book_id) REFERENCES diary_books(diary_book_id), ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE diaries ADD FOREIGN KEY (diary_book_id) REFERENCES diary_books(diary_book_id), ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE diary_photos ADD FOREIGN KEY (diary_id) REFERENCES diaries(diary_id);
ALTER TABLE comments ADD FOREIGN KEY (diary_id) REFERENCES diaries(diary_id), ADD FOREIGN KEY (user_id) REFERENCES users(user_id);
ALTER TABLE emotion_reports ADD FOREIGN KEY (diary_id) REFERENCES diaries(diary_id);
ALTER TABLE diary_stickers ADD FOREIGN KEY (diary_id) REFERENCES diaries(diary_id), ADD FOREIGN KEY (sticker_id) REFERENCES stickers(sticker_id);