-- 회원
ALTER TABLE member
	DROP CONSTRAINT PK_member; -- 회원 기본키

-- 회원
DROP TABLE member;

-- 회원
CREATE TABLE member (
	idx     number(8)      NOT NULL, -- 회원번호
	name    varchar2(30)   NOT NULL, -- 이름
	userid  varchar2(20)   NOT NULL, -- 아이디
	pwd     varchar2(100)  NOT NULL, -- 비밀번호
	hp1     char(3)        NOT NULL, -- 연락처1
	hp2     char(4)        NOT NULL, -- 연락처2
	hp3     char(4)        NOT NULL, -- 연락처3
	post    char(5)        NULL,     -- 우편번호
	addr1   varchar2(100)  NULL,     -- 주소1
	addr2   varchar2(100)  NULL,     -- 주소2
	indate  date           NULL,     -- 가입일
	mileage number(8)      NULL,     -- 보유 적립금
	mstate  number(2)      NULL,     -- 회원상태
	mreason varchar2(1000) NULL      -- 정지,탈퇴 사유
);

-- 회원 기본키
CREATE UNIQUE INDEX PK_member
	ON member ( -- 회원
		idx ASC -- 회원번호
	);

-- 회원
ALTER TABLE member
	ADD
		CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			idx -- 회원번호
		);
--------------------------------------------------------------------------------