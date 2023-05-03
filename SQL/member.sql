-- ȸ��
ALTER TABLE member
	DROP CONSTRAINT PK_member; -- ȸ�� �⺻Ű

-- ȸ��
DROP TABLE member;

-- ȸ��
CREATE TABLE member (
	idx     number(8)      NOT NULL, -- ȸ����ȣ
	name    varchar2(30)   NOT NULL, -- �̸�
	userid  varchar2(20)   NOT NULL, -- ���̵�
	pwd     varchar2(100)  NOT NULL, -- ��й�ȣ
	hp1     char(3)        NOT NULL, -- ����ó1
	hp2     char(4)        NOT NULL, -- ����ó2
	hp3     char(4)        NOT NULL, -- ����ó3
	post    char(5)        NULL,     -- �����ȣ
	addr1   varchar2(100)  NULL,     -- �ּ�1
	addr2   varchar2(100)  NULL,     -- �ּ�2
	indate  date           NULL,     -- ������
	mileage number(8)      NULL,     -- ���� ������
	mstate  number(2)      NULL,     -- ȸ������
	mreason varchar2(1000) NULL      -- ����,Ż�� ����
);

-- ȸ�� �⺻Ű
CREATE UNIQUE INDEX PK_member
	ON member ( -- ȸ��
		idx ASC -- ȸ����ȣ
	);

-- ȸ��
ALTER TABLE member
	ADD
		CONSTRAINT PK_member -- ȸ�� �⺻Ű
		PRIMARY KEY (
			idx -- ȸ����ȣ
		);
--------------------------------------------------------------------------------