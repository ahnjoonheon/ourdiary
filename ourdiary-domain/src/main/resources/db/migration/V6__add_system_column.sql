alter table member_authority add column created_at DATETIME DEFAULT CURRENT_TIMESTAMP;
alter table member_authority add column created_by BIGINT;
alter table member_authority add column last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;
alter table member_authority add column last_modified_by BIGINT;