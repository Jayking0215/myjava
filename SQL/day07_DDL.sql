--DDL:CREATE, ALTER, DROP, TRUNCATE, RENAME
#���̺� ���� - ��������
--<1>�÷� ���ؿ��� �����ϴ� ���
--<2>���̺� ���ؿ��� �����ϴ� ���

[1]PRIMARY KEY
--UNIQUE�� �� + NOT NULL
    <1>�÷�����
--    �÷��� CONSTRAINT �������Ǹ� ������������...
    CREATE TABLE TEST_TAB1(
        ID NUMBER(2) CONSTRAINT TEST_TAB1_ID_PK PRIMARY KEY,
        NAME VARCHAR2(20),
        TEL CHAR(15)
    );
    
    DESC TEST_TAB1;
    INSERT INTO TEST_TAB1 VALUES(1,'ȫ�浿', NULL);
    SELECT * FROM TEST_TAB1;
    
    -- ������ ����(DATE DICTIONARY)���� Ȯ��
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='TEST_TAB1';

    <2>���̺� ���ؿ��� ����
--    �÷��� CONSTRAINT �������Ǹ� ������������ (�÷���)...
    CREATE TABLE TEST_TAB2(
        ID NUMBER(2),
        NAME VARCHAR2(20),
        TEL CHAR(15),
        --�÷� ���� �� �������� ���
        CONSTRAINT TEST_TAB2_ID_PK PRIMARY KEY(ID)
    );
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TEST_TAB2';   
    
--�÷� ����
CREATE TABLE TEST_TAB3(--���������� ���൵ ��_�ý����� �˾Ƽ� �̸� ����
    ID NUMBER(2) PRIMARY KEY,
    NAME VARCHAR2(20)
);
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TEST_TAB3';
--���̺� ����
CREATE TABLE TEST_TAB4(
    ID NUMBER(2),
    NAME VARCHAR2(20),
    PRIMARY KEY(ID)
);
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='TEST_TAB4';

[2]FOREIGN KEY - references
--�θ����̺��� ���� ����
--MASTER TABLE(�θ����̺�)
CREATE TABLE DEPT_TAB(
    DEPTNO NUMBER(2),
    DEPT CHAR(20),
    LOC CHAR(15),
    CONSTRAINT DEPT_TAB_DEPTNO_PK PRIMARY KEY(DEPTNO)--���̺� ������ ��������
);
--DETAIL TABLE(�ڽ����̺�)
CREATE TABLE EMP_TAB(
    EMPNO NUMBER(4) CONSTRAINT EMP_TAB_EMPNO_PK PRIMARY KEY,--�÷� ������ ��������
    ENAME VARCHAR2(20),
    JOB VARCHAR2(10),
    MGR NUMBER(4) CONSTRAINT EMP_TAB_MGR_FK REFERENCES EMP_TAB(EMPNO),--�÷������� FOREIGN KEY����
    HIREDATE DATE,
    SAL NUMBER(7,2),--7�ڸ� �� �Ҽ� 2�ڸ�
    COMM NUMBER(7,2),
    DEPTNO NUMBER(2),
    --���̺� ������ ����(FK)
    CONSTRAINT EMP_TAB_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT_TAB(DEPTNO)
);
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='EMP_TAB';



#ON DELETE CASECADE �ɼ�
--�׽�Ʈ�� �Խ��� �θ� ���̺�
CREATE TABLE BOARD(
    NUM NUMBER(4) PRIMARY KEY,
    TITLE VARCHAR2(100) NOT NULL,
    CONTENT VARCHAR2(1000),
    WDATE DATE DEFAULT SYSDATE);
--�ڽ����̺�
CREATE TABLE REPLY(
    RNUM NUMBER(4) PRIMARY KEY,
    RCONTENT VARCHAR2(1000),
    RWDATE DATE DEFAULT SYSDATE,
    NUM_FK NUMBER(4) REFERENCES BOARD(NUM) ON DELETE CASCADE
    --FK���������� �θ����̺��� �����ϱ⶧���� �θ����̺��� �ݵ�� ����Ǿ��־���Ѵ�.
);

--ON DELETE CASCADE�ɼ��� �ָ� �ڽ� ���ڵ尡 �־
--�θ��� ���ڵ带 ������ �� �ִ�. �̶� �ڽ� ���ڵ嵵 ���� �����ȴ�.

INSERT INTO BOARD(NUM, TITLE, CONTENT)
VALUES(1,'ù��','HI');
INSERT INTO BOARD(NUM, TITLE, CONTENT)
VALUES(2,'SECOND','HELLO');

COMMIT;
SELECT * FROM BOARD;

--��1]1�� �ۿ� ���� ��� 2��
INSERT INTO REPLY(RNUM, RCONTENT, NUM_FK)
VALUES(1,'1ST',1);
INSERT INTO REPLY(RNUM, RCONTENT, NUM_FK)
VALUES(2,'1ST2',1);
--��2]2�� �ۿ� ���� ��� 1��
INSERT INTO REPLY(RNUM, RCONTENT, NUM_FK)
VALUES(3,'2ND',2);

SELECT * FROM REPLY;

--��3]BOARD�� REPLY JOIN�ؼ� ����
SELECT B.*, R.*
FROM BOARD B LEFT OUTER JOIN REPLY R
ON B.NUM = R.NUM_FK;

--BOARD ���̺��� 1�� �Խñ��� �����ϼ���
DELETE FROM BOARD WHERE NUM=1;

[3]UNIQUE KEY - PRIMARY KEY�� �ٸ��� NULL�� ��� ����
<1> �÷����� ����

CREATE TABLE UNI_TAB1(
    NO NUMBER(2) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    USERID VARCHAR2(16) CONSTRAINT UNI_TAB1_USERID_UK UNIQUE,
    TEL CHAR(15)
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='UNI_TAB1';

INSERT INTO UNI_TAB1
VALUES(1,'SHU','KILLER',NULL);
INSERT INTO UNI_TAB1
VALUES(2,'SALLA','HEALTHY',NULL);
INSERT INTO UNI_TAB1
VALUES(3,'HOLYC',NULL,NULL);

COMMIT;

<2>���̺� ������ ����
CREATE TABLE UNI_TAB2(
    NO NUMBER(4) PRIMARY KEY,
    NAME VARCHAR2(20) NOT NULL,
    USERID VARCHAR2(16),
    TEL CHAR(15),
    CONSTRAINT UNI_TAB2_USERID_UK UNIQUE(USERID)
);

[4] NOT NULL - ���̺� ������ ���� �Ұ���(�÷����ظ� ����)
create table nn_tab(
    deptno number(2) primary key, --unique + not null
    dname varchar2(20) constraint nn_tab_dname_nn not null,
    loc varchar2(30) not null--�������� �̸� ���̵� ����(system�� �˾Ƽ� ��������)    
);
--�����ͻ������� ��ȸ
select * from user_constraints where table_name='NN_TAB';
--������ ����
INSERT INTO NN_TAB VALUES(10,'ACCOUNTING','NEWYORK');
COMMIT;
SELECT * FROM NN_TAB;

[5] CHECK
<1>�÷� ������ ����
CREATE TABLE CK_TAB1(
    DEPTNO NUMBER(2) CONSTRAINT CK_TAB1_DEPTNO_CK CHECK(DEPTNO>0 AND DEPTNO<21),
    DNAME CHAR(20),
    LOC CHAR(20)
);
--�����ͻ������� ��ȸ
select * from user_constraints where table_name='CK_TAB1';
--������ ����
INSERT INTO CK_TAB1 VALUES(20,'ACCOUNTIN','LA');--DEPTNO 1~20 ���� ���ڴ� ������������
COMMIT;
SELECT * FROM CK_TAB1;

<2>���̺� ������ ����
--DEPTNO���� 10,20,30,40 ���� ������ CHECK���������� ���̺� ���ؿ��� �ּ���
CREATE TABLE CK_TAB2(
    DEPTNO NUMBER(2),
    DNAME CHAR(20),
    LOC CHAR(20),
    CONSTRAINT CK_TAB2_DEPTNO_CK CHECK(DEPTNO IN (10,20,30,40))
);
INSERT INTO CK_TAB2 VALUES(10,'SALES','SEOUL');
SELECT * FROM CK_TAB2;
-----------------------------------------------------------------
ALTER ��-�̹� ������ ���̺� ������ �� ���
[1] �������� �߰�
ALTER TABLE ���̺�� ADD CONSTRAINT �������Ǹ� ������������(�÷���);

CREATE TABLE USER_TAB(
    ID NUMBER(4),
    NAME VARCHAR2(20),
    TEL CHAR(15)
);
DESC USER_TAB;
--�����ͻ������� Ȯ��
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='USER_TAB';
--USER_TAB�� ID�÷��� PRIMARY KEY���������� �߰�
ALTER TABLE USER_TAB ADD CONSTRAINT USER_TAB_ID_PK PRIMARY KEY(ID);

[2]�������� �̸� ����
ALTER TABLE ���̺�� RENAME CONSTRAINT �����������Ǹ� TO ���������Ǹ�;

--USER_TAB_ID_PK�̸��� USER_TAB_PK�� ����
ALTER TABLE USER_TAB RENAME CONSTRAINT USER_TAB_ID_PK TO USER_TAB_PK;
--�����ͻ������� Ȯ��
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='USER_TAB';

[3]�������� ����
ALTER TABLE ���̺�� DROP CONSTRAINT �������Ǹ�;

--USER_TAB�� PRIMARY KEY���������� ����
ALTER TABLE USER_TAB DROP CONSTRAINT USER_TAB_PK;
--�����ͻ������� Ȯ��
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME='USER_TAB';

[3]�÷� �߰�/����/����
-- ALTER TABLE ���̺�� ADD �߰��� �÷� ���� [default expr]
-- ALTER TABLE ���̺�� MODIFY ������ �÷� ���� [default expr]
-- ALTER TABLE ���̺�� DROP column ������ �÷���
-- ALTER TABLE ���̺�� RENAME COLUMN OLD�÷��� TO NEW�÷���

CREATE TABLE BOARD_TAB(
    NO NUMBER
);

DESC BOARD_TAB;

--��1]BOARD_TAB�� TITLE VARCHAR2(100) NOT NULL�÷��� �߰��ϼ���
ALTER TABLE BOARD_TAB ADD TITLE VARCHAR2(100) NOT NULL;
--��2]BOARD_TAB�� NAME VARCHAR2(20)�÷��� �߰��ϼ���
ALTER TABLE BOARD_TAB ADD NAME VARCHAR2(20);
--��3]BOARD_TAB�� NO�÷Ÿ��� NUM���� ����
ALTER TABLE BOARD_TAB RENAME COLUMN NO TO NUM;
--��4]NUM�� �÷� �ڷ����� CHAR(10)���� ����
ALTER TABLE BOARD_TAB MODIFY NUM CHAR(10);
--��5]NAME�÷��� �����ϼ���
ALTER TABLE BOARD_TAB DROP COLUMN NAME;
DESC BOARD_TAB;

[4]��ü�̸� ����=>(���̺� ��ü��)
--RENAME OLD_NAME TO NEW_NAME

--��1]BOARD_TAB ���̺� �̸��� BBS_TAB���� ����
RENAME BOARD_TAB TO BBS_TAB;
DESC BBS_TAB;
SELECT * FROM TAB;--SCOTT�� ���� ��� ���̺� ��ȸ
SELECT * FROM USER_OBJECTS;--������ ���� ��� ��ü ��ȸ

#���̺� ���� - ROLLBACK �ȵ�
--DROP TABLE ���̺�� CASCADE CONSTRAINT--�������ǵ� ���� ����
--��1]BBS_TAB�� ����
DROP TABLE BBS_TAB CASCADE CONSTRAINT;
--DROP TABLE ���̺�� PURGE;--������ ������ ����(=������ ����)

# ���̺� ������ ���⵵ �����͸� ���� - DELETE�� ���������� DELETE���� ȿ�� ����
--TRUNCATE TABLE ���̺��;
SELECT * FROM EMP2;
TRUNCATE TABLE EMP2;--ROLLBACK�� �ȵ�(DDL�� ��ü ����)

---------------------------------PDF�ǽ�----------------------------------
--MASTER TABLE-�θ�
CREATE TABLE ZIPCODE(
    post1 CHAR(3),
    post2 CHAR(3), 
    ADDR VARCHAR2(60) CONSTRAINT ZIPCODE_ADDR_NN NOT NULL,
    CONSTRAINT ZIPCODE_POST_PK PRIMARY KEY (POST1, POST2)
);
--DETAIL TABLE-�ڽ�
CREATE TABLE MEMBER_TAB(
    ID NUMBER(4,0) CONSTRAINT MEMBER_TAB_ID_PK PRIMARY KEY,
    NAME VARCHAR2(10), 
    GENDER CHAR(1) 
    CONSTRAINT MEMBER_TAB_GENDER_CK CHECK(GENDER IN ('F', 'M')),
    JUMIN1 CHAR(6),
    JUMIN2 CHAR(7),
    TEL VARCHAR2(15),
    POST1 CHAR(3),
    POST2 CHAR(3),
    ADDR VARCHAR2(60),
    CONSTRAINT MEMBER_TAB_JUMIN_UK UNIQUE(JUMIN1, JUMIN2),
    CONSTRAINT MEMBER_TAB_POST_FK FOREIGN KEY (POST1, POST2) REFERENCES ZIPCODE (POST1, POST2)
);