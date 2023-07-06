-- 사용자 관리
CREATE TABLE member
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name         VARCHAR(50)  NOT NULL,
    email            VARCHAR(100) NOT NULL,
    password         VARCHAR(100) NOT NULL,
    profile_pic      VARCHAR(200),
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

ALTER TABLE member
    ADD CONSTRAINT uk_member_email UNIQUE (email);

-- 일기장 관리
CREATE TABLE diaries
(
    diary_id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id          BIGINT       NOT NULL,
    diary_name       VARCHAR(100) NOT NULL,
    description      VARCHAR(500),
    background_image VARCHAR(200),
    theme            VARCHAR(50),
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE diary_participants
(
    participant_id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    diary_id         BIGINT NOT NULL,
    member_id          BIGINT NOT NULL,
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE entries
(
    entry_id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    diary_id         BIGINT       NOT NULL,
    title            VARCHAR(200) NOT NULL,
    content          TEXT,
    tags             VARCHAR(500),
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE comments
(
    comment_id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    entry_id         BIGINT NOT NULL,
    member_id          BIGINT NOT NULL,
    comment_text     TEXT,
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE tags
(
    tag_id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    tag_name         VARCHAR(50) NOT NULL,
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE entry_tags
(
    entry_id         BIGINT NOT NULL,
    tag_id           BIGINT NOT NULL,
    PRIMARY KEY (entry_id, tag_id),
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);

CREATE TABLE sentiment_report
(
    report_id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    entry_id           BIGINT        NOT NULL,
    sentiment_category VARCHAR(50)   NOT NULL,
    sentiment_score    DECIMAL(5, 4) NOT NULL,
    created_at         DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by         BIGINT,
    last_modified_at   DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by   BIGINT
);

CREATE TABLE app_lock
(
    lock_id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_id          BIGINT       NOT NULL,
    lock_type        VARCHAR(20)  NOT NULL,
    lock_value       VARCHAR(200) NOT NULL,
    created_at       DATETIME DEFAULT CURRENT_TIMESTAMP,
    created_by       BIGINT,
    last_modified_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    last_modified_by BIGINT
);
