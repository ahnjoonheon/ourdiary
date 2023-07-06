CREATE TABLE member_authority
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    member_id BIGINT NOT NULL,
    authority VARCHAR(30) NOT NULL
);

ALTER TABLE member_authority ADD CONSTRAINT fk_memeber_id FOREIGN KEY (member_id) REFERENCES member(id);
ALTER TABLE member_authority ADD CONSTRAINT uk_memeber_authority UNIQUE (member_id, authority);
