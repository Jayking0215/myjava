# ����Ŭ ��ü
[1] ������(sequence)

--CREATE SEQUENCE �������� 
[INCREMENT BY n] --N��ŭ ����
[START WITH n] --N���� ����
[{MAXVALUE n | NOMAXVALE}] --�ִ밪|�ִ밪 ����X
[{MINVALUE n | NOMINVALUE}] --�ּҰ�|�ּҰ� ����X
[{CYCLE | NOCYCLE}] --��ȯ(�ݺ�)
[{CACHE | NOCACHE}] --�޸𸮿� �ִٰ� SEQ�ߵ� �� �ҷ�����

-----------------------------------------------------------
--DEPT�� �μ���ȣ(2BYTE) ����� ������ ����
--���۰�:50
--����ġ:10
--�ִ밪:90
--�ּҰ�:50
--NOCYCLE...PRIMARY KEY�� CYCLE�ָ� �ȵ�
DESC DEPT;
CREATE SEQUENCE DEPT_SEQ
START WITH 50
INCREMENT BY 10
MAXVALUE 90
MINVALUE 50
NOCYCLE
NOCACHE;

-- �����ͻ������� ��ȸ
--USER_OBJECTS �Ǵ� USER_SEQUENCES���� ��ȸ����
SELECT * FROM USER_OBJECTS WHERE OBJECT_TYPE='SEQUENCE';
SELECT * FROM USER_SEQUENCES;

--������ ���簪 ��ȸ: ��������.CURRVAL
--������ ������ ��ȸ: ��������.NEXTVAL
--:[����] NEXTVAL�� ���� ����ä CURRVAL�� �θ� �� ����.=>����
SELECT DEPT_SEQ.NEXTVAL FROM DUAL;
SELECT DEPT_SEQ.CURRVAL FROM DUAL;

INSERT INTO DEPT(DEPTNO, DNAME, LOC)
VALUES(DEPT_SEQ.NEXTVAL, 'EDUCATION'||DEPT_SEQ.CURRVAL,'SEOUL');

SELECT * FROM DEPT;

ROLLBACK;
--------------------------------------------------------------------------
[1]# ������ ����/����
--[����] START WITH�� ���� �Ұ�
--ALTER SEQUENCE ��������
--INCREMENT BY N
--MAXVALUE N|NOMAXVALUE
--MINVALUE N|NOMINVALUE
--CYCLE|NOCYCLE
--CACHE N|NOCACHE

--����
--DROP SEQUENCE ��������

--��1]DEPT_SEQ�� �Ʒ��� ���� �����ϼ���
--MAXVALUE 99
--MINVALUE 50
--����ġ 5
--CYCLE����
--CACHE 10
ALTER SEQUENCE DEPT_SEQ
MAXVALUE 99
MINVALUE 50
INCREMENT BY 5
CYCLE
CACHE 10;--(CACHE�� �����Ѹ� ���ư�,,50~95���� 10�� CACHE�����؊x�ٰ� �ҷ���)
--��ȸ
SELECT * FROM DEPT_SEQ;
--������ġ Ȯ��(95���� �ٽ� 50���� ���ƿ�)
SELECT DEPT_SEQ.NEXTVAL FROM DUAL;
--���� �� ��ȸ
DROP SEQUENCE DEPT_SEQ;
SELECT * FROM USER_SEQUENCES;

[2]#VIEW: �������� ���⼺�� ������ ���Ǹ� ���ҽ�Ŵ
--���̺��� �Ϻθ� ������ �����͸� ������ �� ���(Ż��/�޸�ȸ���� �̿��� ���ϰ� �����Ҷ� ��)
--CREATE VIEW ���̸�
--	AS
--	SELECT �÷���1, �÷���2...
--	FROM �信 ����� ���̺��
--	WHERE ���Ǻ��̸�;

--��1]EMP���̺��� 20�� �μ��� ��� �÷��� �����ϴ� EMP20_VIEW�� �����϶�.
CREATE VIEW EMP20_VIEW
    AS
    SELECT *
    FROM EMP
    WHERE DEPTNO=20;
/*
=>ERROR�߻� INSUFFICIENT PRIVILEGES:�� ���� ������ �ο��ؾ� ���� �����ϴ�.(SCOTT�� ������ ����)
SYSTEM, SYS�������� �����ؼ� SCOTT���� ���� �ο�
SHOW USER--USER�� SYSTEM���� Ȯ��
CONN SYSTEM/Abcd1234--system�������� ����
GRANT CREATE VIEW TO SCOTT;
*/

--������ �������� ��ȸ
--USER_VIEWS
SELECT * FROM USER_VIEWS;
--������ ��ȸ
SELECT * FROM EMP20_VIEW;

--[��1] EMP���̺��� 30�� �μ��� EMPNO�� EMP_NO�� ENAME�� NAME����
--	SAL�� SALARY�� �ٲپ� EMP30_VIEW�� �����Ͽ���.
CREATE VIEW EMP30_VIEW
AS
SELECT EMPNO EMP_NO, ENAME NAME, SAL SALARY FROM EMP
WHERE DEPTNO=30;
--Ȯ��
SELECT * FROM EMP30_VIEW;
--[��2] �����̺��� �� ���� �� ���̰� 19�� �̻��� ���� ������ Ȯ���ϴ� �並 ��������.
--	�� ���� �̸��� MEMBER_19�� �ϼ���.
CREATE VIEW MEMBER_19
AS
SELECT * FROM MEMBER
WHERE AGE>=19;
--Ȯ��
SELECT * FROM MEMBER_19;

#VIEW ����
--OR RAPLACE�ɼ��� �־� ����
CREATE OR REPLACE VIEW MEMBER_19
AS
SELECT * FROM MEMBER
WHERE AGE <19;
--Ȯ��
SELECT * FROM MEMBER_19;

##JOIN�� �Բ� ���� VIEW �ǽ�
--[��1] �μ��� �޿��Ѿ�, �����, ��ձ޿�(�Ҽ���2�ڸ�����), �ּұ޿�,�ִ�޿��� ����ϴ� view�� ���弼��
--���̸�: emp_statistic
CREATE OR REPLACE VIEW EMP_STATISTIC
AS
SELECT DEPTNO, SUM(SAL) SUM_SAL, COUNT(EMPNO) CNT, 
ROUND(AVG(SAL),2) AVG_SAL, MIN(SAL) MIN_SAL, MAX(SAL) MAX_SAL
FROM EMP
GROUP BY DEPTNO;

SELECT * FROM EMP_STATISTIC ORDER BY DEPTNO;
--[2] ī�װ�, ��ǰ�� join�Ͽ� �����ִ� view�� �����ϼ���
--���̸�: products_view
CREATE OR REPLACE VIEW PRODUCTS_VIEW
AS
SELECT CATEGORY_NAME, PRODUCTS_NAME, OUTPUT_PRICE, COMPANY
FROM CATEGORY C JOIN PRODUCTS P
ON C.CATEGORY_CODE = P.CATEGORY_FK;

SELECT * FROM PRODUCTS_VIEW
WHERE CATEGORY_NAME LIKE '%����%';--������ǰ�� �˻�

-------------------------------------
# VIEW ����
SELECT * FROM EMP20_VIEW;
UPDATE EMP20_VIEW SET SAL=SAL*1.1 WHERE ENAME='SCOTT';

SELECT * FROM EMP;--VIEW�� ���� ���̺��� �������̺������� �����ϸ� �� �� �ٲ�
--��, GROUP BY ���� �̿��ؼ� ������ VIEW�� DML������ �Ұ����ϴ�.
ROLLBACK;--VIEW�� �ᵵ ROLLBACK/COMMIT�ؾ���

# VIEW�� �ɼ�
--<1> WITH READ ONLY: �б��������θ� VIEW����� ��
--<2> WITH CHECK OPTION: VIEW�� �����Ҷ� �־��� ���ǿ� �����ʴ� �����Ͱ� INSERT/UPDATE�Ǵ°��� ������� �ʴ´�.
--<1>
CREATE OR REPLACE VIEW EMP10_VIEW
AS
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP 
WHERE DEPTNO=10 WITH READ ONLY;

SELECT * FROM EMP10_VIEW;
--���� TABLE����_����
UPDATE EMP SET JOB='ANALYST' WHERE EMPNO=7782;
--VIEW TABLE(R) ����_�Ұ���
UPDATE EMP10_VIEW SET JOB='ANALYST' WHERE EMPNO=7782;

--<2>__WHERE���� ������ ������.
--JOB�� SALESMAN�� ��� ������ ��� EMP_SALES_VIEW�� �����ϵ� WITH CHECK OPTION�� �༭ ����
CREATE OR REPLACE VIEW EMP_SALES_VIEW
AS
SELECT * FROM EMP
WHERE JOB='SALESMAN' WITH CHECK OPTION;
--WITH CHECK OPTION�� ���� ����
SELECT * FROM EMP_SALES_VIEW;
UPDATE EMP_SALES_VIEW SET COMM=100 WHERE EMPNO=7844;
SELECT * FROM EMP;
--�׷��� CHECK OPTION�� WHERE���� �����Ѱ��� �����Ұ�....(WHERE�� ������ JOB)
UPDATE EMP_SALES_VIEW SET JOB='MANAGER' WHERE EMPNO=7844;
-------------------------------------------------------------
# INLINE VIEW
--FROM���� ����� SUQUERY�� INLINE VIEW��� �Ѵ�._DAY07

------------------------�������----------------------------------
RANK() OVER(�м���) : �м����� �������� ��ŷ�� �ű��
ROW_NUMBER() OVER(�м���): �м����� �������� ���ȣ�� �ű��

�м���
PARTITION BY �÷��� : �÷����� �������� �׷����� �Ѵ�
ORDER BY �÷��� : �÷����� �������� �����Ѵ�


SELECT RANK() OVER(ORDER BY SAL DESC) RNK, EMP.*
FROM EMP;

�������� �޿��� ���̹޴� ����� ������ �ű⼼��

SELECT RANK() OVER(PARTITION BY JOB ORDER BY SAL DESC) RNK, EMP.*
FROM EMP;

SELECT ROW_NUMBER() OVER(PARTITION BY JOB ORDER BY SAL DESC) RN, EMP.*
FROM EMP;

�������� ���� �޿��� ���� ��� 1�� ����ϼ���
SELECT * FROM (
SELECT RANK() OVER(PARTITION BY JOB ORDER BY SAL DESC) RNK, EMP.*
FROM EMP
)
WHERE RNK=1;

--------------------------------------------------------------------------------
[3] INDEX
--CREATE INDEX �ε����� ON ���̺��(�÷���)

--MEMBER���̺��� NAME�÷��� INDEX�� �����غ���
CREATE INDEX MEMEBER_NAME_IDX ON MEMBER(NAME);--��Ÿ�� ���·� �������� ����
--=>NAME�÷����� �� �д´�
--=>NAME�÷����� ���� �������� ������ �Ѵ�.
--=>ROWID�� NAME���� �����ϱ� ���� ��������� �Ҵ��Ѵ�.
--=>�Ҵ�� ������ ���� �����Ѵ�.

�����ͻ������� ��ȸ 3���� ���
-- USER_OBJECTS: ��ü��ȸ
SELECT * FROM USER_OBJECTS WHERE OBJECT_TYPE='INDEX';
-- USER_INDEXES: �ε����� ��ȸ
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='MEMBER';
-- USER_IND_COLUMNS : �ε��� �÷� ����
SELECT * FROM USER_IND_COLUMNS WHERE INDEX_NAME='MEMEBER_NAME_IDX';
--WHERE TABLE_NAME='MAMBER';--�ε����� �𸦶� ���̺������

SELECT * FROM MEMBER WHERE NAME LIKE '%��%';
--��1]��ǰ ���̺��� �ε����� �ɾ�θ� ���� �÷��� ã�� �ε����� ���弼��.
CREATE INDEX PRODUCTS_CATEGORY_FK_IDX ON PRODUCTS (CATEGORY_FK);--JOIN�Ҷ� ���� �ܷ�Ű�� ����
CREATE INDEX PRODUCTS_EP_CODE_FK_IDX ON PRODUCTS (EP_CODE_FK);
--��ȸ
SELECT * FROM USER_INDEXES WHERE TABLE_NAME='PRODUCTS';
SELECT * FROM USER_IND_COLUMNS WHERE TABLE_NAME='PRODUCTS';

#�ε��� ����
--���� �Ұ���...DROP�ϰ� �ٽ� �����ؾ��Ѵ�.
#�ε��� ����--���� �ʿ��� ���
--DROP INDEX �ε�����;
DROP INDEX PRODUCTS_CATEGORY_FK_IDX;

[4] SYNONYM(���Ǿ�)
�ٸ� ������ ��ü�� �����Ҷ� ����Ѵ�.
--CREATE [PUBLIC] SYNONYM �ó�Ը� FOR OBJECT_NAME;