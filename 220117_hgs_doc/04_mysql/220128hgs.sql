-- 회원
CREATE TABLE hgs.members (
	member_idx INT          NOT NULL, -- 멤버키
	email      VARCHAR(100) NOT NULL, -- 이메일
	password   VARCHAR(60)  NOT NULL, -- 비밀번호
	pet_number VARCHAR(15)  NULL,     -- 강아지일련번호
	name       VARCHAR(20)  NOT NULL, -- 이름
	profile    VARCHAR(100) NULL,     -- 프로필사진
	birthday   DATE         NOT NULL, -- 탄생일
	sex        TINYINT      NOT NULL, -- 성별
	address    VARCHAR(255) NOT NULL, -- 주소
	breed_idx  INT          NULL,     -- 품종키
	neutering  TINYINT      NULL,     -- 중성화 여부
	sns_id     VARCHAR(50)  NULL,     -- sns아이디
	sns_type   TINYINT      NULL,     -- sns타입
	reg_date   TIMESTAMP    NULL,     -- 가입일
	out_date   TIMESTAMP    NULL,     -- 탈퇴날자
	exist      TINYINT      NULL      -- 탈퇴여부
);

-- 회원관심사리스트
CREATE TABLE hgs.member_hashtags (
	member_idx  INT NOT NULL, -- 멤버키
	hashtag_idx INT NOT NULL  -- 해쉬태그idx
);

-- 해쉬태그
CREATE TABLE hgs.hashtags (
	hashtag_idx INT         NOT NULL, -- 해쉬태그idx
	tag         VARCHAR(20) NOT NULL  -- 태그이름
);

-- 강아지 종류
CREATE TABLE hgs.breeds (
	breed_idx INT         NOT NULL, -- 품종키
	dog_type  VARCHAR(50) NOT NULL  -- 종류
);

-- 게시판댓글좋아요
CREATE TABLE hgs.board_reply_like (
	board_reply_idx INT NOT NULL, -- 게시판댓글인덱스
	member_idx      INT NOT NULL  -- 멤버키
);

-- 게시판댓글
CREATE TABLE hgs.board_replys (
	board_reply_idx INT       NOT NULL, -- 게시판댓글인덱스
	member_idx      INT       NOT NULL, -- 멤버키
	board_idx       INT       NOT NULL, -- 게시글키
	content         TEXT      NOT NULL, -- 내용
	create_date     TIMESTAMP NULL,     -- 작성날짜
	edit_date       TIMESTAMP NULL      -- 수정날짜
);

-- 게시글
CREATE TABLE hgs.boards (
	board_idx   INT          NOT NULL, -- 게시글키
	member_idx  INT          NOT NULL, -- 멤버키
	title       VARCHAR(100) NOT NULL, -- 제목
	content     TEXT         NOT NULL, -- 내용
	create_date TIMESTAMP    NULL,     -- 작성날짜
	edit_date   TIMESTAMP    NULL,     -- 수정날짜
	delete_date TIMESTAMP    NULL,     -- 삭제날짜
	exist       TINYINT      NULL      -- 게시글삭제여부
);

-- 게시판좋아요
CREATE TABLE hgs.board_likes (
	board_idx  INT NOT NULL, -- 게시글키
	member_idx INT NOT NULL  -- 멤버키
);

-- 게시판파일테이블
CREATE TABLE hgs.board_files (
	board_file_idx INT          NOT NULL, -- 게시판파일키
	board_idx      INT          NOT NULL, -- 게시글키
	file_name      VARCHAR(100) NOT NULL, -- 파일이름
	size           INT          NOT NULL, -- 파일크기
	create_date    TIMESTAMP    NULL,     -- 파일등록일
	delete_date    TIMESTAMP    NULL,     -- 파일삭제일
	exist          TINYINT      NULL      -- 파일삭제여부
);

-- 게시글해쉬태그
CREATE TABLE hgs.board_hashtags (
	board_idx   INT NOT NULL, -- 게시글키
	hashtag_idx INT NOT NULL  -- 해쉬태그idx
);

-- 관리자 보드
CREATE TABLE hgs.admin_board_list (
	admin_board_idx INT NOT NULL, -- 리스트키
	board_name      INT NOT NULL  -- 보드이름
);

-- 공지글
CREATE TABLE hgs.admin_boards (
	admin_board_idx  INT          NOT NULL, -- 공지글키
	admin_idx        INT          NOT NULL, -- 관리자키
	admin_board_idx2 INT          NULL,     -- 리스트키
	title            VARCHAR(100) NOT NULL, -- 제목
	content          TEXT         NOT NULL, -- 내용
	file_name        VARCHAR(100) NULL,     -- 파일이름
	create_date      TIMESTAMP    NULL,     -- 작성날짜
	edit_date        TIMESTAMP    NULL,     -- 수정날짜
	delete_date      TIMESTAMP    NULL,     -- 삭제날짜
	exist            TINYINT      NULL      -- 삭제여부
);

-- admins
CREATE TABLE hgs.admins (
	admin_idx INT          NOT NULL, -- 관리자키
	email     VARCHAR(100) NOT NULL, -- 이메일
	password  VARCHAR(60)  NOT NULL  -- 비밀번호
);

-- 장소데이터
CREATE TABLE hgs.places (
	place_idx        INT          NOT NULL, -- 데이터키
	admin_idx        INT          NOT NULL, -- 관리자키
	title            VARCHAR(50)  NOT NULL, -- 상점이름
	subject_category VARCHAR(50)  NOT NULL, -- 분류체계
	affiliation      VARCHAR(50)  NOT NULL, -- 시
	old_address      VARCHAR(100) NULL,     -- 지번주소
	new_address      VARCHAR(100) NULL,     -- 도로명주소
	latitude         VARCHAR(255) NULL,     -- 위도
	longitude        VARCHAR(255) NULL,     -- 경도
	homepage         VARCHAR(100) NULL,     -- 홈페이지
	phone            VARCHAR(50)  NULL,     -- 전화번호
	open_time        VARCHAR(50)  NULL,     -- 영업시간
	holiday          INT          NULL,     -- 주말
	insert_date      TIMESTAMP    NULL,     -- 수집일
	update_date      TIMESTAMP    NULL,     -- 업데이트날짜
	state            INT          NULL      -- 상태
);

-- 추천장소해쉬태그
CREATE TABLE hgs.place_hashtags (
	hashtag_idx INT NOT NULL, -- 해쉬태그idx
	place_idx   INT NOT NULL  -- 데이터키
);

-- 추천장소스크랩
CREATE TABLE hgs.place_scraps (
	place_idx  INT NOT NULL, -- 데이터키
	member_idx INT NOT NULL  -- 멤버키
);

-- 후기
CREATE TABLE hgs.place_replys (
	place_reply_idx INT          NOT NULL, -- 후기키
	place_idx       INT          NOT NULL, -- 데이터키
	member_idx      INT          NOT NULL, -- 멤버키
	star            TINYINT      NOT NULL, -- 별점
	content         TEXT         NOT NULL, -- 내용
	file_name       VARCHAR(100) NULL,     -- 이미지
	create_date     TIMESTAMP    NULL,     -- 작성날짜
	edit_date       TIMESTAMP    NULL      -- 수정날짜
);

-- 추천장소파일경로
CREATE TABLE hgs.place_files (
	place_file_idx INT          NOT NULL, -- 추천장소
	place_idx      INT          NOT NULL, -- 데이터키
	file_name      VARCHAR(100) NOT NULL, -- 파일이름
	size           INT          NOT NULL, -- 파일크기
	create_date    TIMESTAMP    NULL,     -- 파일등록일
	delete_date    TIMESTAMP    NULL,     -- 파일삭제일
	exist          TINYINT      NULL      -- 파일삭제여부
);


/*

-- 회원
ALTER TABLE hgs.members
	DROP FOREIGN KEY FK_breeds_TO_members; -- 새 테이블6 -> 회원
ALTER TABLE hgs.members
	DROP PRIMARY KEY; -- 회원 기본키
ALTER TABLE hgs.member_hashtags
	DROP FOREIGN KEY FK_members_TO_member_hashtags; -- 회원 -> 회원관심사리스트
ALTER TABLE hgs.member_hashtags
	DROP FOREIGN KEY FK_hashtags_TO_member_hashtags; -- 해쉬태그 -> 회원관심사리스트
ALTER TABLE hgs.member_hashtags
	DROP PRIMARY KEY; -- 회원관심사리스트 기본키
-- 해쉬태그
ALTER TABLE hgs.hashtags
	DROP PRIMARY KEY; -- 해쉬태그 기본키
-- 게시판댓글좋아요
ALTER TABLE hgs.board_reply_like
	DROP FOREIGN KEY FK_board_replys_TO_board_reply_like; -- 게시판댓글 -> 게시판댓글좋아요
ALTER TABLE hgs.board_reply_like
	DROP FOREIGN KEY FK_members_TO_board_reply_like; -- 회원 -> 게시판댓글좋아요
ALTER TABLE hgs.board_reply_like
	DROP PRIMARY KEY; -- 게시판댓글좋아요 기본키    
 ALTER TABLE hgs.board_replys
	DROP FOREIGN KEY FK_members_TO_board_replys; -- 회원 -> 게시판댓글
ALTER TABLE hgs.board_replys
	DROP FOREIGN KEY FK_boards_TO_board_replys; -- 게시글 -> 게시판댓글
ALTER TABLE hgs.board_replys
	DROP PRIMARY KEY; -- 게시판댓글 기본키
-- 강아지 종류
ALTER TABLE hgs.breeds
	DROP PRIMARY KEY; -- 새 테이블6 기본키   
ALTER TABLE hgs.boards
	DROP FOREIGN KEY FK_members_TO_boards; -- 회원 -> 게시글
ALTER TABLE hgs.boards
	DROP PRIMARY KEY; -- 게시글 기본키
    -- 게시판좋아요
ALTER TABLE hgs.board_likes
	DROP FOREIGN KEY FK_boards_TO_board_likes; -- 게시글 -> 게시판좋아요
ALTER TABLE hgs.board_likes
	DROP FOREIGN KEY FK_members_TO_board_likes; -- 회원 -> 게시판좋아요
ALTER TABLE hgs.board_likes
	DROP PRIMARY KEY; -- 게시판좋아요 기본키
ALTER TABLE hgs.board_files
	DROP FOREIGN KEY FK_boards_TO_board_files; -- 게시글 -> 게시판파일테이블
ALTER TABLE hgs.board_files
	DROP PRIMARY KEY; -- 게시판파일테이블 기본키
-- 게시글해쉬태그
ALTER TABLE hgs.board_hashtags
	DROP FOREIGN KEY FK_boards_TO_board_hashtags; -- 게시글 -> 게시글해쉬태그
ALTER TABLE hgs.board_hashtags
	DROP FOREIGN KEY FK_hashtags_TO_board_hashtags; -- 해쉬태그 -> 게시글해쉬태그
ALTER TABLE hgs.board_hashtags
	DROP PRIMARY KEY; -- 게시글해쉬태그 기본키
 ALTER TABLE hgs.admin_board_list
	DROP PRIMARY KEY; -- 새 테이블7 기본키
-- 공지글
ALTER TABLE hgs.admin_boards
	DROP FOREIGN KEY FK_admins_TO_admin_boards; -- admins -> 공지글
ALTER TABLE hgs.admin_boards
	DROP FOREIGN KEY FK_admin_board_list_TO_admin_boards; -- 새 테이블7 -> 공지글
ALTER TABLE hgs.admin_boards
	DROP PRIMARY KEY; -- 공지글 기본키
-- admins
ALTER TABLE hgs.admins
	DROP PRIMARY KEY; -- admins 기본키
-- 장소데이터
ALTER TABLE hgs.places
	DROP FOREIGN KEY FK_admins_TO_places; -- admins -> 장소데이터
ALTER TABLE places
	DROP PRIMARY KEY; -- 장소데이터 기본키  
-- 추천장소해쉬태그
ALTER TABLE hgs.place_hashtags
	DROP FOREIGN KEY FK_hashtags_TO_place_hashtags; -- 해쉬태그 -> 추천장소해쉬태그
ALTER TABLE hgs.place_hashtags
	DROP FOREIGN KEY FK_places_TO_place_hashtags; -- 장소데이터 -> 추천장소해쉬태그
ALTER TABLE hgs.place_hashtags
	DROP PRIMARY KEY; -- 추천장소해쉬태그 기본키
-- 추천장소스크랩
ALTER TABLE hgs.place_scraps
	DROP FOREIGN KEY FK_places_TO_place_scraps; -- 장소데이터 -> 추천장소스크랩
ALTER TABLE hgs.place_scraps
	DROP FOREIGN KEY FK_members_TO_place_scraps; -- 회원 -> 추천장소스크랩
ALTER TABLE hgs.place_scraps
	DROP PRIMARY KEY; -- 추천장소스크랩 기본키
ALTER TABLE hgs.place_replys
	DROP FOREIGN KEY FK_members_TO_place_replys; -- 회원 -> 후기
ALTER TABLE hgs.place_replys
	DROP FOREIGN KEY FK_places_TO_place_replys; -- 장소데이터 -> 후기
ALTER TABLE hgs.place_replys
	DROP PRIMARY KEY; -- 후기 기본키
ALTER TABLE hgs.place_files
	DROP FOREIGN KEY FK_places_TO_place_files; -- 장소데이터 -> 추천장소파일경로

ALTER TABLE hgs.place_files
	DROP PRIMARY KEY; -- 추천장소파일경로 기본키
*/


ALTER TABLE hgs.members
	ADD CONSTRAINT PK_members -- 회원 기본키
		PRIMARY KEY (
			member_idx -- 멤버키
		);

ALTER TABLE hgs.breeds
	ADD CONSTRAINT PK_breeds -- 새 테이블6 기본키
		PRIMARY KEY (
			breed_idx -- 품종키
		);
        
ALTER TABLE hgs.members
	ADD CONSTRAINT FK_breeds_TO_members -- 새 테이블6 -> 회원
		FOREIGN KEY (
			breed_idx -- 품종키
		)
		REFERENCES breeds ( -- 새 테이블6
			breed_idx -- 품종키
		); 
        
-- 회원관심사리스트
ALTER TABLE hgs.member_hashtags
	ADD CONSTRAINT PK_member_hashtags -- 회원관심사리스트 기본키
		PRIMARY KEY (
			member_idx,  -- 멤버키
			hashtag_idx  -- 해쉬태그idx
		);        
  

 ALTER TABLE hgs.hashtags
	ADD CONSTRAINT PK_hashtags -- 해쉬태그 기본키
		PRIMARY KEY (
			hashtag_idx -- 해쉬태그idx
		);
	
-- 게시글
ALTER TABLE hgs.boards
	ADD CONSTRAINT PK_boards -- 게시글 기본키
		PRIMARY KEY (
			board_idx -- 게시글키
		);   
-- 게시판댓글
ALTER TABLE hgs.board_replys
	ADD CONSTRAINT PK_board_replys -- 게시판댓글 기본키
		PRIMARY KEY (
			board_reply_idx -- 게시판댓글인덱스
		);

ALTER TABLE hgs.board_likes
	ADD CONSTRAINT PK_board_likes -- 게시판좋아요 기본키
		PRIMARY KEY (
			board_idx,  -- 게시글키
			member_idx  -- 멤버키
		);

ALTER TABLE hgs.board_likes
	ADD CONSTRAINT FK_boards_TO_board_likes -- 게시글 -> 게시판좋아요
		FOREIGN KEY (
			board_idx -- 게시글키
		)
		REFERENCES boards ( -- 게시글
			board_idx -- 게시글키
		);

ALTER TABLE hgs.board_likes
	ADD CONSTRAINT FK_members_TO_board_likes -- 회원 -> 게시판좋아요
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);
        
        -- 게시판파일테이블
ALTER TABLE hgs.board_files
	ADD CONSTRAINT PK_board_files -- 게시판파일테이블 기본키
		PRIMARY KEY (
			board_file_idx -- 게시판파일키
		);

ALTER TABLE hgs.board_files
	ADD CONSTRAINT FK_boards_TO_board_files -- 게시글 -> 게시판파일테이블
		FOREIGN KEY (
			board_idx -- 게시글키
		)
		REFERENCES boards ( -- 게시글
			board_idx -- 게시글키
		);

ALTER TABLE hgs.board_hashtags
	ADD CONSTRAINT PK_board_hashtags -- 게시글해쉬태그 기본키
		PRIMARY KEY (
			board_idx,   -- 게시글키
			hashtag_idx  -- 해쉬태그idx
		);
--  관리자 보드
ALTER TABLE hgs.admin_board_list
	ADD CONSTRAINT PK_admin_board_list -- 새 테이블7 기본키
		PRIMARY KEY (
			admin_board_idx -- 리스트키
		);
        

ALTER TABLE hgs.admin_boards
	ADD CONSTRAINT PK_admin_boards -- 공지글 기본키
		PRIMARY KEY (
			admin_board_idx -- 공지글키
		);

-- 추천장소파일경로
ALTER TABLE hgs.place_files
	ADD CONSTRAINT PK_place_files -- 추천장소파일경로 기본키
		PRIMARY KEY (
			place_file_idx -- 추천장소
		);

-- 후기
ALTER TABLE hgs.place_replys
	ADD CONSTRAINT PK_place_replys -- 후기 기본키
		PRIMARY KEY (
			place_reply_idx -- 후기키
		);



ALTER TABLE hgs.place_scraps
	ADD CONSTRAINT PK_place_scraps -- 추천장소스크랩 기본키
		PRIMARY KEY (
			place_idx,  -- 데이터키
			member_idx  -- 멤버키
		);



ALTER TABLE hgs.place_hashtags
	ADD CONSTRAINT PK_place_hashtags -- 추천장소해쉬태그 기본키
		PRIMARY KEY (
			hashtag_idx, -- 해쉬태그idx
			place_idx    -- 데이터키
		);


ALTER TABLE hgs.admins
	ADD CONSTRAINT PK_admins -- admins 기본키
		PRIMARY KEY (
			admin_idx -- 관리자키
		);
        
 -- 장소데이터
ALTER TABLE hgs.places
	ADD CONSTRAINT PK_places -- 장소데이터 기본키
		PRIMARY KEY (
			place_idx -- 데이터키
		);
-- 게시판댓글좋아요
ALTER TABLE hgs.board_reply_like
	ADD CONSTRAINT PK_board_reply_like -- 게시판댓글좋아요 기본키
		PRIMARY KEY (
			board_reply_idx, -- 게시판댓글인덱스
			member_idx       -- 멤버키
		);
--

       
ALTER TABLE hgs.board_reply_like
	ADD CONSTRAINT FK_board_replys_TO_board_reply_like -- 게시판댓글 -> 게시판댓글좋아요
		FOREIGN KEY (
			board_reply_idx -- 게시판댓글인덱스
		)
		REFERENCES board_replys ( -- 게시판댓글
			board_reply_idx -- 게시판댓글인덱스
		);
ALTER TABLE hgs.place_hashtags
	ADD CONSTRAINT FK_hashtags_TO_place_hashtags -- 해쉬태그 -> 추천장소해쉬태그
		FOREIGN KEY (
			hashtag_idx -- 해쉬태그idx
		)
		REFERENCES hashtags ( -- 해쉬태그
			hashtag_idx -- 해쉬태그idx
		);
ALTER TABLE hgs.place_scraps
	ADD CONSTRAINT FK_members_TO_place_scraps -- 회원 -> 추천장소스크랩
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);
ALTER TABLE hgs.place_replys
	ADD CONSTRAINT FK_members_TO_place_replys -- 회원 -> 후기
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);
        
ALTER TABLE hgs.member_hashtags
	ADD CONSTRAINT FK_members_TO_member_hashtags -- 회원 -> 회원관심사리스트
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);
ALTER TABLE hgs.member_hashtags
	ADD CONSTRAINT FK_hashtags_TO_member_hashtags -- 해쉬태그 -> 회원관심사리스트
		FOREIGN KEY (
			hashtag_idx -- 해쉬태그idx
		)
		REFERENCES hashtags ( -- 해쉬태그
			hashtag_idx -- 해쉬태그idx
		);
        
ALTER TABLE hgs.board_replys
	ADD CONSTRAINT FK_boards_TO_board_replys -- 게시글 -> 게시판댓글
		FOREIGN KEY (
			board_idx -- 게시글키
		)
		REFERENCES boards ( -- 게시글
			board_idx -- 게시글키
		);
ALTER TABLE hgs.board_reply_like
	ADD CONSTRAINT FK_members_TO_board_reply_like -- 회원 -> 게시판댓글좋아요
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);

ALTER TABLE hgs.board_replys
	ADD CONSTRAINT FK_members_TO_board_replys -- 회원 -> 게시판댓글
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);

ALTER TABLE hgs.boards
	ADD CONSTRAINT FK_members_TO_boards -- 회원 -> 게시글
		FOREIGN KEY (
			member_idx -- 멤버키
		)
		REFERENCES members ( -- 회원
			member_idx -- 멤버키
		);

ALTER TABLE hgs.place_files
	ADD CONSTRAINT FK_places_TO_place_files -- 장소데이터 -> 추천장소파일경로
		FOREIGN KEY (
			place_idx -- 데이터키
		)
		REFERENCES places ( -- 장소데이터
			place_idx -- 데이터키
		);


ALTER TABLE hgs.place_replys
	ADD CONSTRAINT FK_places_TO_place_replys -- 장소데이터 -> 후기
		FOREIGN KEY (
			place_idx -- 데이터키
		)
		REFERENCES places ( -- 장소데이터
			place_idx -- 데이터키
		);

        
--



ALTER TABLE hgs.board_hashtags
	ADD CONSTRAINT FK_boards_TO_board_hashtags -- 게시글 -> 게시글해쉬태그
		FOREIGN KEY (
			board_idx -- 게시글키
		)
		REFERENCES boards ( -- 게시글
			board_idx -- 게시글키
		);

ALTER TABLE hgs.board_hashtags
	ADD CONSTRAINT FK_hashtags_TO_board_hashtags -- 해쉬태그 -> 게시글해쉬태그
		FOREIGN KEY (
			hashtag_idx -- 해쉬태그idx
		)
		REFERENCES hashtags ( -- 해쉬태그
			hashtag_idx -- 해쉬태그idx
		);        


ALTER TABLE hgs.admin_boards
	ADD CONSTRAINT FK_admin_board_list_TO_admin_boards -- 새 테이블7 -> 공지글
		FOREIGN KEY (
			admin_board_idx2 -- 리스트키
		)
		REFERENCES admin_board_list ( -- 새 테이블7
			admin_board_idx -- 리스트키
		);
        

 ALTER TABLE hgs.admin_boards
	ADD CONSTRAINT FK_admins_TO_admin_boards -- admins -> 공지글
		FOREIGN KEY (
			admin_idx -- 관리자키
		)
		REFERENCES admins ( -- admins
			admin_idx -- 관리자키
		);       
        
ALTER TABLE hgs.places
	ADD CONSTRAINT FK_admins_TO_places -- admins -> 장소데이터
		FOREIGN KEY (
			admin_idx -- 관리자키
		)
		REFERENCES admins ( -- admins
			admin_idx -- 관리자키
		);
        
ALTER TABLE hgs.place_hashtags
	ADD CONSTRAINT FK_places_TO_place_hashtags -- 장소데이터 -> 추천장소해쉬태그
		FOREIGN KEY (
			place_idx -- 데이터키
		)
		REFERENCES places ( -- 장소데이터
			place_idx -- 데이터키
		);

ALTER TABLE hgs.place_scraps
	ADD CONSTRAINT FK_places_TO_place_scraps -- 장소데이터 -> 추천장소스크랩
		FOREIGN KEY (
			place_idx -- 데이터키
		)
		REFERENCES places ( -- 장소데이터
			place_idx -- 데이터키
		);






        

 