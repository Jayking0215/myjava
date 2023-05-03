-- 상위 카테고리
ALTER TABLE upCategory
	DROP CONSTRAINT PK_upCategory; -- 상위 카테고리 기본키

-- 상위 카테고리
DROP TABLE upCategory;

-- 상위 카테고리
CREATE TABLE upCategory (
	upcg_code number(8)    NOT NULL, -- 상위 카테고리 코드
	upcg_name varchar2(30) NOT NULL  -- 상위 카테고리명
);

-- 상위 카테고리 기본키
CREATE UNIQUE INDEX PK_upCategory
	ON upCategory ( -- 상위 카테고리
		upcg_code ASC -- 상위 카테고리 코드
	);

-- 상위 카테고리
ALTER TABLE upCategory
	ADD
		CONSTRAINT PK_upCategory -- 상위 카테고리 기본키
		PRIMARY KEY (
			upcg_code -- 상위 카테고리 코드
		);
--------------------------------------------------------------------------------
-- 하위 카테고리
ALTER TABLE downCategory
	DROP CONSTRAINT FK_upCategory_TO_downCategory; -- 상위 카테고리 -> 하위 카테고리

-- 하위 카테고리
ALTER TABLE downCategory
	DROP CONSTRAINT PK_downCategory; -- 하위 카테고리 기본키

-- 하위 카테고리
DROP TABLE downCategory;

-- 하위 카테고리
CREATE TABLE downCategory (
	upcg_code   number(8)    NOT NULL, -- 상위 카테고리 코드
	downcg_code number(8)    NOT NULL, -- 하위 카테고리 코드
	downcg_name varchar2(30) NOT NULL  -- 하위 카테고리명
);

-- 하위 카테고리 기본키
CREATE UNIQUE INDEX PK_downCategory
	ON downCategory ( -- 하위 카테고리
		upcg_code   ASC, -- 상위 카테고리 코드
		downcg_code ASC  -- 하위 카테고리 코드
	);

-- 하위 카테고리
ALTER TABLE downCategory
	ADD
		CONSTRAINT PK_downCategory -- 하위 카테고리 기본키
		PRIMARY KEY (
			upcg_code,   -- 상위 카테고리 코드
			downcg_code  -- 하위 카테고리 코드
		);

-- 하위 카테고리
ALTER TABLE downCategory
	ADD
		CONSTRAINT FK_upCategory_TO_downCategory -- 상위 카테고리 -> 하위 카테고리
		FOREIGN KEY (
			upcg_code -- 상위 카테고리 코드
		)
		REFERENCES upCategory ( -- 상위 카테고리
			upcg_code -- 상위 카테고리 코드
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
--------------------------------------------------------------------------------
-- 상품
ALTER TABLE product
	DROP CONSTRAINT FK_downCategory_TO_product; -- 하위 카테고리 -> 상품

-- 상품
ALTER TABLE product
	DROP CONSTRAINT FK_upCategory_TO_product; -- 상위 카테고리 -> 상품

-- 상품
ALTER TABLE product
	DROP CONSTRAINT PK_product; -- 상품 기본키

-- 상품
DROP TABLE product;

-- 상품
CREATE TABLE product (
	pnum        number(8)      NOT NULL, -- 상품번호
	pname       varchar2(100)  NOT NULL, -- 상품명
	price       number(8)      NOT NULL, -- 상품 정가
	saleprice   number(8)      NULL,     -- 상품 판매가
	pcompany    varchar2(50)   NULL,     -- 제조사
	pcontents   varchar2(1000) NULL,     -- 상품 설명
	pspec       varchar2(20)   NULL,     -- 상품 스펙
	point       number(8)      NULL,     -- 포인트
	pindate     date           NULL,     -- 상품 입고일
	pimage1     varchar2(100)  NULL,     -- 이미지1
	pimage2     varchar2(100)  NULL,     -- 이미지2
	pimage3     varchar2(100)  NULL,     -- 이미지3
	upcg_code   number(8)      NULL,     -- 상위 카테고리 코드
	downcg_code number(8)      NULL      -- 하위 카테고리 코드
);

-- 상품 기본키
CREATE UNIQUE INDEX PK_product
	ON product ( -- 상품
		pnum ASC -- 상품번호
	);

-- 상품
ALTER TABLE product
	ADD
		CONSTRAINT PK_product -- 상품 기본키
		PRIMARY KEY (
			pnum -- 상품번호
		);

-- 상품
ALTER TABLE product
	ADD
		CONSTRAINT FK_downCategory_TO_product -- 하위 카테고리 -> 상품
		FOREIGN KEY (
			upcg_code,   -- 상위 카테고리 코드
			downcg_code  -- 하위 카테고리 코드
		)
		REFERENCES downCategory ( -- 하위 카테고리
			upcg_code,   -- 상위 카테고리 코드
			downcg_code  -- 하위 카테고리 코드
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- 상품
ALTER TABLE product
	ADD
		CONSTRAINT FK_upCategory_TO_product -- 상위 카테고리 -> 상품
		FOREIGN KEY (
			upcg_code -- 상위 카테고리 코드
		)
		REFERENCES upCategory ( -- 상위 카테고리
			upcg_code -- 상위 카테고리 코드
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
        