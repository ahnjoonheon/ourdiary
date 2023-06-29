# 데이터베이스 테이블 설계

## Users Table (사용자 정보)

| Column Name    | Data Type | Description                     |
|----------------|-----------|---------------------------------|
| user_id (PK)   | INT       | 사용자 고유 ID                  |
| name           | VARCHAR   | 사용자 이름                     |
| email          | VARCHAR   | 사용자 이메일                   |
| password       | VARCHAR   | 사용자 비밀번호 (해싱)           |
| profile_pic    | VARCHAR   | 프로필 사진 URL                 |
| nickname       | VARCHAR   | 사용자 닉네임                   |
| created_at     | TIMESTAMP | 계정 생성 시간                  |
| last_login_at  | TIMESTAMP | 마지막 로그인 시간              |

## EmailVerifications Table (이메일 인증)

| Column Name      | Data Type | Description                  |
|------------------|-----------|------------------------------|
| verification_id (PK) | INT       | 이메일 인증 고유 ID           |
| user_id (FK)     | INT       | 사용자 고유 ID (Users 참조)  |
| verification_code   | VARCHAR   | 인증 코드                    |
| expires_at       | TIMESTAMP | 인증 코드 만료 시간           |

## DiaryBooks Table (일기장 정보)

| Column Name    | Data Type | Description                 |
|----------------|-----------|-----------------------------|
| diary_book_id (PK) | INT       | 일기장 고유 ID              |
| name           | VARCHAR   | 일기장 이름                 |
| description    | VARCHAR   | 일기장 설명                 |
| background_image  | VARCHAR   | 배경화면 URL                |
| background_color  | VARCHAR   | 배경 색상                  |
| created_at     | TIMESTAMP | 일기장 생성 시간            |

## DiaryBookMembers Table (일기장 참여자 정보)

| Column Name    | Data Type | Description                 |
|----------------|-----------|-----------------------------|
| diary_book_id (FK) | INT       | 일기장 고유 ID (DiaryBooks 참조)  |
| user_id (FK)   | INT       | 사용자 고유 ID (Users 참조) |
| role           | VARCHAR   | 사용자 역할 (owner, member) |

## Diaries Table (일기 정보)

| Column Name    | Data Type | Description                  |
|----------------|-----------|------------------------------|
| diary_id (PK)  | INT       | 일기 고유 ID                 |
| diary_book_id (FK) | INT       | 일기장 고유 ID (DiaryBooks 참조) |
| user_id (FK)   | INT       | 사용자 고유 ID (Users 참조)  |
| title          | VARCHAR   | 일기 제목                    |
| content        | TEXT      | 일기 내용                    |
| tags           | VARCHAR[] | 태그 배열                    |
| created_at     | TIMESTAMP | 일기 작성 시간               |
| updated_at     | TIMESTAMP | 일기 수정 시간               |

## DiaryPhotos Table (일기에 첨부된 사진 정보)

| Column Name    | Data Type | Description               |
|----------------|-----------|---------------------------|
| photo_id (PK)  | INT       | 사진 고유 ID              |
| diary_id (FK)  | INT       | 일기 고유 ID (Diaries 참조) |
|

 photo_url      | VARCHAR   | 사진 URL                  |
| description    | VARCHAR   | 사진 설명                 |
| tags           | VARCHAR[] | 사진 태그 배열             |
| uploaded_at    | TIMESTAMP | 사진 업로드 시간          |

## Comments Table (댓글 정보)

| Column Name    | Data Type | Description                  |
|----------------|-----------|------------------------------|
| comment_id (PK)| INT       | 댓글 고유 ID                 |
| diary_id (FK)  | INT       | 일기 고유 ID (Diaries 참조)  |
| user_id (FK)   | INT       | 사용자 고유 ID (Users 참조)  |
| content        | TEXT      | 댓글 내용                    |
| created_at     | TIMESTAMP | 댓글 작성 시간               |
| updated_at     | TIMESTAMP | 댓글 수정 시간               |

## EmotionReports Table (감정분석 리포트 정보)

| Column Name    | Data Type | Description                  |
|----------------|-----------|------------------------------|
| report_id (PK) | INT       | 리포트 고유 ID               |
| diary_id (FK)  | INT       | 일기 고유 ID (Diaries 참조)  |
| emotion_data   | JSON      | 감정 데이터 (JSON 형태)      |
| generated_at   | TIMESTAMP | 리포트 생성 시간             |

## Stickers Table (스티커 정보)

| Column Name    | Data Type | Description                  |
|----------------|-----------|------------------------------|
| sticker_id (PK)| INT       | 스티커 고유 ID               |
| name           | VARCHAR   | 스티커 이름                  |
| sticker_url    | VARCHAR   | 스티커 이미지 URL            |
| is_dynamic     | BOOLEAN   | 동적 스티커 여부            |

## DiaryStickers Table (일기에 사용된 스티커 정보)

| Column Name    | Data Type | Description                   |
|----------------|-----------|-------------------------------|
| diary_id (FK)  | INT       | 일기 고유 ID (Diaries 참조)   |
| sticker_id (FK)| INT       | 스티커 고유 ID (Stickers 참조)|