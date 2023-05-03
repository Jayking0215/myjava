SELECT * FROM tab;
--�ܹ��ּ�
/*
�����ּ�
c:/myjava/SQL/day01.sql
F5=��ũ��Ʈ ��ü ���
select * from dept; + (ctrl+enter)/���� ��ũ��Ʈ ���
*/
--�λ� ���� �ý���
SELECT * FROM emp;--�θ����̺�: deptno: PK(unique + not null)
SELECT * FROM dept;--�ڽ����̺�: deptno : FK
--emp�� dept�� �ҼӵǾ� �ִ�

SELECT ename,job,sal FROM emp;
SELECT empno, ename, sal, sal+300 AS sal_up FROM emp;--����ĵ� ���� ����(AS�� ��Ī �ο�)_alias

--emp���� ���, �����, �޿�, ���ʽ�(comm),����(�޿�*12)+���ʽ� AS YEAR_SAL
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+COMM AS YEAR_SAL FROM EMP;
--null: �����ϸ� ��� ���� null�� ����
--NVL(�÷���, ��)�Լ�...�÷��� NULL�ϰ�� ������ ��ü
SELECT EMPNO, ENAME, SAL, COMM, SAL*12+NVL(COMM,0) AS YEAR_SAL FROM EMP;
--NVL2(EXPR, EXPR1, EXPR2) ...EXPR���� NULL�� �ƴҰ�� EXPR1���� ��ȯ�ϰ� NULL�̸� EXPR2�� ��ȯ
SELECT EMPNO, ENAME, MGR, NVL2(MGR, 1, 0) "������ ���� ����" FROM EMP;


--���θ� �ý���
select * from member;
select * from category;
select * from products;
select * from supply_comp;


--�л� ���̺� ����
create table student(
    num number(4) Primary key, --primary: unique�� ��+not null
    --number�� ����
    name varchar2(30) not null, 
    --varchar2�� ����, �ܾ�
    --not null�� �ʼ��Է�    
    addr varchar2(100) not null,
    tel varchar2(15) not null,
    indate date default sysdate, --�ý����� ���� ��¥�� default�� ����
    cname varchar2(50),
    croom number(3)
);

select * from student;
-- �л����� ���
/*
inser into ���̺��(�÷���1, �÷���2,...)
values(��1, ��2...);
*/

insert into student(num, name, addr, tel, cname, croom)
values(1, 'ȫ�浿', '����Ư����', '010-1234-5678', '��ص� �����ڹ�', 201);
commit;--db�� ��������
select * from student;

insert into student(num, addr, name, tel, cname, croom)
values(2, '��õ������', 'ȫ�漭', '010-4321-9876', '��ص� �����ڹ�', 201);
--���� DB�� ���� �� �޸𸮿� �ö��ִ� ����
rollback; --���...�޸𸮿��� ����
commit;

insert into student(num, name, addr, tel)
values(3, 'ȫ�泲', '��⵵', '010-1234-1234');

select * from student;
commit;

insert into student--�÷��� �����ϸ� ��� �÷� �ҷ��°����� ����
values(4, 'ȫ���', '����������', '010-5432-2345', '2023/03/21', '�����͹�', 202);
select * from student;
commit;--transaction control language = TCL

--�����͹� 2�� �߰�//AI�����ڹ� 1�� 203ȣ ���
insert into student
values(5,'��1','��걤����','010-5432-3574','2023/01/14','�����͹�',202);
insert into student
values(6,'��2','�λ걤����','010-5232-3644','2023/01/16','�����͹�',202);
commit;
select * from student;
insert into student
values(7, '����1', '�����', '010-1234-1423', '2022/12/14', 'AI�����ڹ�', 203);
commit;
--������ ����
/*
update ���̺�� set �÷���1=������1, �÷���2=������2,.....
where ������
*/
select * from student;
update student set cname='��ص� �����ڹ�', croom=201 where num=3;

--�̸��� ȫ�浿�� �л��� ����ó�� 011-1234-5678�� ����
update student set tel='011-1234-5678'
where num=1;--where 'ȫ�浿' and croom=201�� ����
select * from student;
rollback;--Ŀ���ϸ� �ǹ̾���....
commit;

--������ ����
--delete from ���̺�� where ������;
select * from student;
delete from student where num=5;
select * from student;
--rollback;
--select * from student;
commit;
--commit�� Ȯ���Ҷ��� �Ұ�!!!
insert into student
values(8,'���缮','����Ư����','010-2929-3939',sysdate,'��ص�','301');
commit;

select * from student
where croom=201;--...�������� ���� �߻�(8�� �л� ��Ÿ)=DB���� ����
-->�ߺ��Ǵ� �����Ͱ� �߻��ϴ� table�� ���� ����(primary key��->foreign key��)

--���̺� ����:DDL(Data Delete Language)..Ŀ�� ���ʿ�
--drop table ���̺��;
DROP TABLE STUDENT;

--���̺� ����(�θ����̺�, MASTER TABLE)
CREATE TABLE SCLASS(
    SNUM NUMBER(4) PRIMARY KEY,--�б޹�ȣ-PK
    SNAME VARCHAR2(50) NOT NULL,--�б޸�
    SROOM NUMBER(3)--����-NULL���
);
DESC SCLASS;
CREATE TABLE STUDENT(
    NUM NUMBER(4) PRIMARY KEY,--�й�
    NAME VARCHAR2(30) NOT NULL,
    ADDR VARCHAR2(100) NOT NULL,
    TEL VARCHAR2(15) NOT NULL,
    INDATE DATE DEFAULT SYSDATE,
    SNUM_FK NUMBER(4) REFERENCES SCLASS(SNUM)
);
DESC STUDENT;

--�б� �����͸� ����
--10 ��ص尳���ڹ� 201
--20 �����͹� 202
--30 AI�����ڹ� 203

INSERT INTO SCLASS
VALUES(10, '��ص尳���ڹ�', 201);
SELECT * FROM SCLASS;

INSERT INTO SCLASS
VALUES(20, '�����͹�', 202);

INSERT INTO SCLASS
VALUES(30, 'AI�����ڹ�', 203);
SELECT * FROM SCLASS;
COMMIT;

--�л� ������ ����
--10�� �б޿� 3�� ���
--20�� �б޿� 3�� ���
--30�� �б޿� 3�� ���

INSERT INTO STUDENT(NUM, NAME, ADDR, TEL, SNUM_FK)
VALUES(1, 'KHAL','SEOUL','010-1111-1111',SYSDATE, 10);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(2, 'SHANE','TOKYO','010-2222-2222',SYSDATE, 10);

INSERT INTO STUDENT
VALUES(3, 'MULE','SANHAI','010-3333-3333',SYSDATE, 10);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(4, 'LUAS','NEWYORK','010-4444-4444',SYSDATE, 20);

INSERT INTO STUDENT
VALUES(5, 'HANLY','SIDNEY','010-5555-5555',SYSDATE, 20);

INSERT INTO STUDENT
VALUES(6, 'HAUL','MANILA','010-6666-6666',SYSDATE, 20);
SELECT * FROM STUDENT;

INSERT INTO STUDENT
VALUES(7, 'THALA','MARS','010-7777-7777',SYSDATE, 30);

INSERT INTO STUDENT
VALUES(8, 'MARRY','JUPITER','010-8888-8888',SYSDATE, 30);

INSERT INTO STUDENT
VALUES(9, 'MONGO','BATICAN','010-9999-9999',SYSDATE, 30);
SELECT * FROM STUDENT;
COMMIT;

--���� �̻� ����
INSERT INTO STUDENT
VALUES(10, 'MILLA','ISTANBUL','010-1222-2111','23-03-21',40);--����

--���� �̻� ����
--1�� �л��� �б� �����ϵ� 30���б����� ����
UPDATE STUDENT SET SNUM_FK=30 WHERE NUM=1;
SELECT * FROM STUDENT;
--2�� �л��� �б��� 40�� �б����� ����
UPDATE STUDENT SET SNUM_FK=40 WHERE NUM=2;--����
SELECT * FROM STUDENT;

--���� �̻� ����
SELECT COUNT(*) FROM STUDENT WHERE SNUM_FK=10;
DELETE FROM SCLASS WHERE SNUM=10;--����
--FOREIGN KEY�� �����ϴ� DATA�� �ڽ�TABLE�� �ִٸ� ������ �� ����.

SELECT * FROM STUDENT;--�б޸��� �� �� ����.
--JOIN��-->����ȭ�� ������ ���ϸ� �ذ�
SELECT SNUM, SNAME ,NAME, TEL, INDATE, SNUM_FK
FROM SCLASS JOIN STUDENT--���
ON SCLASS.SNUM = STUDENT.SNUM_FK--����
ORDER BY SNUM ASC;--�������� ����
