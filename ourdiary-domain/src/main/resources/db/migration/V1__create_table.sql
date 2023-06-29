-- users Table
CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    profile_pic VARCHAR(200),
    nickname VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login_at TIMESTAMP
);

-- diary_books Table
CREATE TABLE diary_book (
    diary_book_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200) NOT NULL,
    background_image VARCHAR(200),
    background_color VARCHAR(7),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- email_verifications Table
CREATE TABLE email_verification (
    verification_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    verification_code VARCHAR(50) NOT NULL,
    expires_at TIMESTAMP NOT NULL
);

-- diary_book_members Table
CREATE TABLE diary_book_member (
    diary_book_id BIGINT,
    user_id BIGINT,
    role VARCHAR(20) NOT NULL,
    PRIMARY KEY (diary_book_id, user_id)
);

-- diaries Table
CREATE TABLE diary (
    diary_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diary_book_id BIGINT,
    user_id BIGINT,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    tags VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- diary_photos Table
CREATE TABLE diary_photo (
    photo_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diary_id BIGINT,
    photo_url VARCHAR(200) NOT NULL,
    description VARCHAR(100),
    tags VARCHAR(100),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- comments Table
CREATE TABLE comment (
    comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diary_id BIGINT,
    user_id BIGINT,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- emotion_reports Table
CREATE TABLE emotion_report (
    report_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    diary_id BIGINT,
    emotion_data JSON NOT NULL,
    generated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- stickers Table
CREATE TABLE sticker (
    sticker_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    sticker_url VARCHAR(200) NOT NULL,
    is_dynamic BOOLEAN NOT NULL
);

-- diary_stickers Table
CREATE TABLE diary_sticker (
    diary_id BIGINT,
    sticker_id BIGINT,
    PRIMARY KEY (diary_id, sticker_id)
);
