CREATE TABLE refresh_token
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    member_Id  BIGINT   NOT NULL,
    token      TEXT     NOT NULL,
    expired_at DATETIME NOT NULL,
    status     varchar(20) DEFAULT 'ENABLED',
    created_at DATETIME    DEFAULT CURRENT_TIMESTAMP,
    craeted_by BIGINT   NOT NULL,
    updated_at DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by BIGINT   NOT NULL,
    FOREIGN KEY (member_Id) REFERENCES member (id)
);