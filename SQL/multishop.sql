-- ���� ī�װ�
ALTER TABLE upCategory
	DROP CONSTRAINT PK_upCategory; -- ���� ī�װ� �⺻Ű

-- ���� ī�װ�
DROP TABLE upCategory;

-- ���� ī�װ�
CREATE TABLE upCategory (
	upcg_code number(8)    NOT NULL, -- ���� ī�װ� �ڵ�
	upcg_name varchar2(30) NOT NULL  -- ���� ī�װ���
);

-- ���� ī�װ� �⺻Ű
CREATE UNIQUE INDEX PK_upCategory
	ON upCategory ( -- ���� ī�װ�
		upcg_code ASC -- ���� ī�װ� �ڵ�
	);

-- ���� ī�װ�
ALTER TABLE upCategory
	ADD
		CONSTRAINT PK_upCategory -- ���� ī�װ� �⺻Ű
		PRIMARY KEY (
			upcg_code -- ���� ī�װ� �ڵ�
		);
--------------------------------------------------------------------------------
-- ���� ī�װ�
ALTER TABLE downCategory
	DROP CONSTRAINT FK_upCategory_TO_downCategory; -- ���� ī�װ� -> ���� ī�װ�

-- ���� ī�װ�
ALTER TABLE downCategory
	DROP CONSTRAINT PK_downCategory; -- ���� ī�װ� �⺻Ű

-- ���� ī�װ�
DROP TABLE downCategory;

-- ���� ī�װ�
CREATE TABLE downCategory (
	upcg_code   number(8)    NOT NULL, -- ���� ī�װ� �ڵ�
	downcg_code number(8)    NOT NULL, -- ���� ī�װ� �ڵ�
	downcg_name varchar2(30) NOT NULL  -- ���� ī�װ���
);

-- ���� ī�װ� �⺻Ű
CREATE UNIQUE INDEX PK_downCategory
	ON downCategory ( -- ���� ī�װ�
		upcg_code   ASC, -- ���� ī�װ� �ڵ�
		downcg_code ASC  -- ���� ī�װ� �ڵ�
	);

-- ���� ī�װ�
ALTER TABLE downCategory
	ADD
		CONSTRAINT PK_downCategory -- ���� ī�װ� �⺻Ű
		PRIMARY KEY (
			upcg_code,   -- ���� ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		);

-- ���� ī�װ�
ALTER TABLE downCategory
	ADD
		CONSTRAINT FK_upCategory_TO_downCategory -- ���� ī�װ� -> ���� ī�װ�
		FOREIGN KEY (
			upcg_code -- ���� ī�װ� �ڵ�
		)
		REFERENCES upCategory ( -- ���� ī�װ�
			upcg_code -- ���� ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
--------------------------------------------------------------------------------
-- ��ǰ
ALTER TABLE product
	DROP CONSTRAINT FK_downCategory_TO_product; -- ���� ī�װ� -> ��ǰ

-- ��ǰ
ALTER TABLE product
	DROP CONSTRAINT FK_upCategory_TO_product; -- ���� ī�װ� -> ��ǰ

-- ��ǰ
ALTER TABLE product
	DROP CONSTRAINT PK_product; -- ��ǰ �⺻Ű

-- ��ǰ
DROP TABLE product;

-- ��ǰ
CREATE TABLE product (
	pnum        number(8)      NOT NULL, -- ��ǰ��ȣ
	pname       varchar2(100)  NOT NULL, -- ��ǰ��
	price       number(8)      NOT NULL, -- ��ǰ ����
	saleprice   number(8)      NULL,     -- ��ǰ �ǸŰ�
	pcompany    varchar2(50)   NULL,     -- ������
	pcontents   varchar2(1000) NULL,     -- ��ǰ ����
	pspec       varchar2(20)   NULL,     -- ��ǰ ����
	point       number(8)      NULL,     -- ����Ʈ
	pindate     date           NULL,     -- ��ǰ �԰���
	pimage1     varchar2(100)  NULL,     -- �̹���1
	pimage2     varchar2(100)  NULL,     -- �̹���2
	pimage3     varchar2(100)  NULL,     -- �̹���3
	upcg_code   number(8)      NULL,     -- ���� ī�װ� �ڵ�
	downcg_code number(8)      NULL      -- ���� ī�װ� �ڵ�
);

-- ��ǰ �⺻Ű
CREATE UNIQUE INDEX PK_product
	ON product ( -- ��ǰ
		pnum ASC -- ��ǰ��ȣ
	);

-- ��ǰ
ALTER TABLE product
	ADD
		CONSTRAINT PK_product -- ��ǰ �⺻Ű
		PRIMARY KEY (
			pnum -- ��ǰ��ȣ
		);

-- ��ǰ
ALTER TABLE product
	ADD
		CONSTRAINT FK_downCategory_TO_product -- ���� ī�װ� -> ��ǰ
		FOREIGN KEY (
			upcg_code,   -- ���� ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		)
		REFERENCES downCategory ( -- ���� ī�װ�
			upcg_code,   -- ���� ī�װ� �ڵ�
			downcg_code  -- ���� ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

-- ��ǰ
ALTER TABLE product
	ADD
		CONSTRAINT FK_upCategory_TO_product -- ���� ī�װ� -> ��ǰ
		FOREIGN KEY (
			upcg_code -- ���� ī�װ� �ڵ�
		)
		REFERENCES upCategory ( -- ���� ī�װ�
			upcg_code -- ���� ī�װ� �ڵ�
		)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;
        