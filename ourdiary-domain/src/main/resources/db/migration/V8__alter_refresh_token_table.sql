ALTER TABLE refresh_token DROP FOREIGN KEY refresh_token_ibfk_1;
ALTER TABLE refresh_token DROP COLUMN member_Id;
ALTER TABLE refresh_token ADD COLUMN username varchar(100) NOT NULL AFTER id;