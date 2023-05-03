--DML����
---INSERT
---UPDATE
---DELETE

--[1]INSERT��
--INSERT INTO ���̺��(�÷���1, �÷���2,,,) VALUES(��1, ��2...)
--EMP���̺� COPY(������)
CREATE TABLE EMP2
AS
SELECT * FROM EMP;

INSERT INTO EMP2(EMPNO, ENAME, JOB, HIREDATE, DEPTNO)
VALUES(8001,'TOM','MANAGER',SYSDATE,40);
SELECT * FROM EMP2;
ROLLBACK;--COMMIT ������ ��� ����,,,F12
COMMIT;--F11

INSERT INTO EMP2
VALUES(8002,'SUSAN','SALESMAN',7788,SYSDATE,4000,500,30);
COMMIT;

--��1]DEPT���̺��� COPY�ϵ� ���̺� ������ ī���ϼ���. �׷��� �Ʒ� �����͸� �����غ�����
--10 ȸ��μ� ����
--20 �����μ� �޶�
--30 �����μ� LA
--40 ��μ� ������
CREATE TABLE DEPT2
AS
SELECT * FROM DEPT
WHERE 1=2;--DATA�� �Ȱ������� �÷��� �������� ���

SELECT * FROM DEPT2;--Ȯ��

INSERT INTO DEPT2
VALUES(10,'ȸ��μ�','����');
INSERT INTO DEPT2
VALUES(20,'�����μ�','�޶�');
INSERT INTO DEPT2
VALUES(30,'�����μ�','LA');
INSERT INTO DEPT2
VALUES(40,'��μ�','������');
COMMIT;

--[2]UPDATE��
--UPDATE ���̺�� SET �÷���1=��1,�÷���2=��2....--������ ����
--WERE ������;

--��1]emp2���̺��� ����� 7788�� ����� �μ���ȣ�� 10���� �����ϼ���.
UPDATE EMP2 SET DEPTNO=10 WHERE EMPNO=7788;
SELECT * FROM EMP2;
--��2]emp2 ���̺��� ����� 7788�� ����� �μ��� 20,�޿��� 3500���� �����Ͽ���.
UPDATE EMP2 SET DEPTNO=20, SAL=SAL+500 WHERE EMPNO=7788;
--��3] EMP2���� ��� ����� �޿��� 10%�� �λ��ϼ���
UPDATE EMP2 SET SAL=SAL*1.1;
--��4]EMP2���̺��� SCOTT�� ������ �޿��� ��ġ�ϵ��� JONES�� ������ �޿��� �����Ͽ���.
--SUBQUERY���
UPDATE EMP2 SET JOB=(SELECT JOB FROM EMP WHERE ENAME='SCOTT'),
SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT')
WHERE ENAME='JONES';
SELECT * FROM EMP2;

--[����]
--1] �� ���̺� �� �̸��� 'ȫ�浿'�� ����� �̸��� �ڱ浿���� �����ϼ���.
--...��浿�� 2���� ���...where�������� �� �� ��ü������ �Ͽ� �����Ѵ�.
UPDATE MEMEBER SET ENAME='�ڱ浿' WHERE ENAME='ȫ�浿';

--2] ��ϵ� �� ���� �� ���� ���̸� ���� ���̿��� ��� 5�� ���� ������ �����ϼ���.
UPDATE MEMBER SET AGE=AGE+5;
--2_1] �� �� 13/09/01���� ����� ������ ���ϸ����� 350���� �÷��ּ���.
UPDATE MEMBER SET MILEAGE=MILEAGE+350
WHERE REG_DATE>'13/09/01';
--3] ��ϵǾ� �ִ� �� ���� �� �̸��� '��'�ڰ� ����ִ� ��� �̸��� '��' ��� '��'�� �����ϼ���.
UPDATE MEMBER SET NAME=REPLACE(NAME, '��', '��')
WHERE SUBSTR(NAME,1,1)='��';



-- DEPT2���̺��� DEPTNO �÷��� PRIMARY KEY ���������� �߰��غ���.
--���̺��̳� �Ӽ��� �������� �����Ͱ� ������ ���� ������ �����ϵ��� ���� ���� ��
--ALTER TABLE [���̺��] ADD CONSTRAINT [�������Ǹ�] [��������](�÷���)
CREATE TABLE DEPT2 AS SELECT * FROM DEPT;
CREATE TABLE EMP2 AS SELECT * FROM EMP;

ALTER TABLE DEPT2 ADD CONSTRAINT DEPT2_DEPTNO_PK PRIMARY KEY (DEPTNO);
DESC DEPT2;
INSERT INTO DEPT2 VALUES(30,'������','����');
INSERT INTO DEPT2 VALUES(40,'���','����');
COMMIT;
SELECT * FROM DEPT2;

EMP2���̺��� DEPTNO�÷��� DEPT2�� DEPTNO �÷��� �����ϴ� �ܷ�Ű�� ����������
�߰��غ���

ALTER TABLE EMP2 ADD CONSTRAINT EMP2_DEPTNO_FK FOREIGN KEY (DEPTNO)
REFERENCES DEPT2 (DEPTNO);

SELECT * FROM EMP2;

EMP2 7566�� ����� �μ���ȣ�� 40���μ��� �����ϼ���

UPDATE EMP2 SET DEPTNO=40 
WHERE EMPNO=7566;

7521�� ����� �μ���ȣ�� 90�� �μ��� �����ϼ���
UPDATE EMP2 SET DEPTNO=90
WHERE EMPNO=7521;
--�θ����̺� ���� �����ͷ� �����Ϸ��� �� ��� ���Ἲ �������� ������ �߻��Ѵ�

----------------------------------------------------------
# DELETE �� - ������ ����
DELETE FROM ���̺�� WHERE ������;

-- EMP2���̺��� �����ȣ�� 7499�� ����� ������ �����϶�.
DELETE FROM	EMP2;	
SELECT * FROM EMP2;
ROLLBACK;

DELETE FROM EMP2 WHERE EMPNO=7499;

-- EMP2���̺��� �Ի����ڰ� 83���� ����� ������ �����϶�.

DELETE FROM EMP2 WHERE TO_CHAR(HIREDATE,'YY')='83';

--EMP2���̺��� �μ����� 'SALES'�� ����� ������ �����ϼ���

DELETE FROM EMP2 WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME='SALES');
ROLLBACK;
--
--1] ��ǰ ���̺� �ִ� ��ǰ �� ��ǰ�� �Ǹ� ������ 10000�� ������ ��ǰ�� ��� 
--	      �����ϼ���.
SELECT * FROM PRODUCTS;
DELETE FROM PRODUCTS WHERE OUTPUT_PRICE <=10000;
--
--	2] ��ǰ ���̺� �ִ� ��ǰ �� ��ǰ�� ��з��� ������ ��ǰ�� �����ϼ���.
SELECT * FROM CATEGORY;
DELETE FROM PRODUCTS WHERE CATEGORY_FK 
= ( SELECT CATEGORY_CODE FROM CATEGORY WHERE CATEGORY_NAME='����' );
--
--	3] ��ǰ ���̺� �ִ� ��� ������ �����ϼ���.
DELETE FROM PRODUCTS;
SELECT * FROM PRODUCTS;
ROLLBACK;

-- DEPT2���� 10���μ��� �����ϼ���
DELETE FROM DEPT2 WHERE DEPTNO=10;

SELECT * FROM EMP2 WHERE DEPTNO=10;
10�� �μ� ������� 20�� �μ��� �����ϼ���

UPDATE EMP2 SET DEPTNO=20 WHERE DEPTNO=10;
ROLLBACK;

--# TCL - TRANSACTION CONTROL LANGUAGE
--COMMIT
--ROLLBACK
--SAVEPOINT
--
--SAVEPOINT : �������� �����Ҷ� ����Ѵ�

--7788�� ����� �̸��� CHARSE�� �����ϼ���
UPDATE EMP2 SET ENAME='CHARSE' WHERE EMPNO=7788;
SELECT * FROM EMP2;
--������ ����: SAVEPOINT �������̸�;
SAVEPOINT MYPOINT;
--EMP2���� ��� ����� JOB�� MANAGER�� �����Ѵ�
UPDATE EMP2 SET JOB='MANAGER';
SELECT * FROM EMP2;
--ROLLBACK�Ҷ� ������������ ROLLBACK�� �غ���
ROLLBACK TO MYPOINT;

COMMIT;





------------------------------------------------
--���������� �Ѳ����� INSERT�ϱ�
INSERT ALL INTO DEPT2
VALUES(50,'������','����')
INTO DEPT2
VALUES(60,'�빫��','��õ')
INTO DEPT2
VALUES(70,'��ȹ��','����')
SELECT * FROM DUAL;
SELECT * FROM DEPT2;