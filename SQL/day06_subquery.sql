# SUBQUERY
--��1]������̺��� SCOTT�� �޿����� ���� ����� �����ȣ, �̸�, ����, �޿��� ���
SELECT SAL FROM EMP WHERE ENAME='SCOTT ';
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP WHERE SAL>3000;
--SUBQUERY���
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='SCOTT');--�������� ����� �ϳ��� �����°��� ������ ��������

--����1] ������̺��� �����ȣ�� 7521�� ����� ������ ���� �޿���
--7934�� ������� ���� ����� ���,�̸�,����,�Ի�����,�޿��� ����ϼ���.
SELECT EMPNO, ENAME,JOB, HIREDATE, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO=7521) 
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7934);

# ������ ��������: �񱳿����� ���(��ձ޿�)
--����2]������̺��� �޿��� ��պ��� ���� ����� ���,�̸�,����,�޿�,�μ���ȣ�� ����ϼ���.
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP);

# ������ ��������: �������� ����� ������
--������ �������� ������
--IN
--ANY
--ALL
--EXIST

[1]IN ������
--��1]�������� �ִ� �޿��� �޴� ����� �����ȣ�� �̸��� ����ϼ���.
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE (JOB,SAL) IN
(SELECT JOB, MAX(SAL)
FROM EMP
GROUP BY JOB);

--��2]�μ����� �ּұ޿��� �޴� ����� ���,�̸�,�μ���ȣ,�޿�,������ ����ϼ���
SELECT EMPNO, ENAME, DEPTNO, SAL, JOB
FROM EMP
WHERE (DEPTNO, SAL) 
IN
(SELECT DEPTNO, MIN(SAL) FROM EMP GROUP BY DEPTNO);

[2]ANY ������:�������� ����� �� ��� �ϳ��� �����ϸ� ��� ��ȯ
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN');--SALESMAN�� ������ �ϳ��� ���⸸�ϸ� �ȴ�(=MIN(SAL))
--������ ����
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');

[3]ALL ������: �������� ����� �� ��� ������� �����ϸ� ��� ��ȯ
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');--SALESMAN�� ������ ���� ���ƾ��Ѵ�(=MAX(SAL))
--������ ����
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');

[4]EXISTS ������:���������� �����Ͱ� �����ϴ��� ���θ� ������ �����ϴ� ���� ��ȯ
--��1]������� �����ϴ� �������� ������ �����ּ���.
SELECT EMPNO, ENAME, JOB FROM EMP E
WHERE EXISTS(SELECT EMPNO FROM EMP WHERE E.EMPNO = MGR);

--1]�� ���̺� �ִ� �� ���� �� ���ϸ����� ���� ���� �ݾ��� �� ������ �����ּ���.
SELECT *
FROM MEMBER
WHERE MILEAGE =
(SELECT MAX(MILEAGE) FROM MEMBER);
--2]��ǰ ���̺� �ִ� ��ü ��ǰ ���� �� ��ǰ�� �ǸŰ����� 
--�ǸŰ����� ��պ��� ū  ��ǰ�� ����� �����ּ���. 
--��, ����� ���� ���� ����� ������ ���� �Ǹ� ������ 50������ �Ѿ�� ��ǰ�� ���ܽ�Ű����.
SELECT * FROM PRODUCTS
WHERE OUTPUT_PRICE >
(SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS WHERE OUTPUT_PRICE <= 500000)
AND OUTPUT_PRICE <= 500000;
--3]��ǰ ���̺� �ִ� �ǸŰ��ݿ��� ��հ��� �̻��� ��ǰ ����� ���ϵ� �����
--���� �� �ǸŰ����� �ִ��� ��ǰ�� �����ϰ� ����� ���ϼ���
SELECT * FROM PRODUCTS
WHERE OUTPUT_PRICE >=(
SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS 
WHERE OUTPUT_PRICE <> (SELECT MAX(OUTPUT_PRICE) FROM PRODUCTS));
--4]��ǰ ī�װ� ���̺��� ī�װ� �̸��� ��ǻ�Ͷ�� �ܾ ���Ե� ī�װ���
--���ϴ� ��ǰ ����� �����ּ���.
SELECT * FROM PRODUCTS
WHERE CATEGORY_FK IN
(SELECT CATEGORY_CODE FROM CATEGORY WHERE CATEGORY_NAME LIKE '%��ǻ��%');
--5]�� ���̺� �ִ� ������ �� ������ �������� ���� ���̰� ���� ����� ������ ȭ�鿡 �����ּ���.
--������ ���߿� ��������(=GROUP BY)
SELECT * FROM MEMBER
WHERE (JOB, AGE)
IN
(SELECT JOB, MAX(AGE) FROM MEMBER GROUP BY JOB);
--6]�� ���̺� �ִ� �� ���� �� ���ϸ����� ���� ���� �ݾ���
--	     ������ ������ ���ʽ� ���ϸ��� 5000���� �� �ִ� SQL�� �ۼ��ϼ���.
UPDATE MEMBER SET MILEAGE=MILEAGE+5000
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER);

SELECT * FROM MEMBER;
--7] �� ���̺��� ���ϸ����� ���� ���� ������ڸ� �� ���̺��� 
--	      ������� �� ���� �ڿ� ����� ��¥�� ���ϴ� ������ �����ϼ���.
UPDATE MEMBER SET REG_DATE
= (SELECT MAX(REG_DATE) FROM MEMBER)
WHERE MILEAGE = 0;
--8] ��ǰ ���̺� �ִ� ��ǰ ���� �� ���ް��� ���� ū ��ǰ�� ���� ��Ű�� 
--	      SQL���� �ۼ��ϼ���.
DELETE FROM PRODUCTS WHERE INPUT_PRICE =
(SELECT MAX(INPUT_PRICE) FROM PRODUCTS);
--9] ��ǰ ���̺��� ��ǰ ����� ���� ��ü���� ������ ��,
--	     �� ���޾�ü���� �ּ� �Ǹ� ������ ���� ��ǰ�� �����ϼ���.
DELETE FROM PRODUCTS 
WHERE (EP_CODE_FK, OUTPUT_PRICE) IN
(SELECT EP_CODE_FK, MIN(OUTPUT_PRICE) FROM PRODUCTS GROUP BY EP_CODE_FK);

# FROM���� ���� SUBQUERY�� INLINE VIEW��� �Ѵ�.
--EMP�� DEPT ���̺��� ������ MANAGER�� ����� �̸�, ����,�μ���,�ٹ����� ����ϼ���.
SELECT ENAME, JOB, DNAME, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO AND JOB='MANAGER';
--=>SUBQUERY�� Ǯ��(������ SUBQUERY�� �� ����ϴ�)
SELECT ENAME, JOB, DNAME, LOC
FROM 
(SELECT * FROM EMP WHERE JOB='MANAGER') A JOIN DEPT D
ON A.DEPTNO = D.DEPTNO;

--------------------------------------------------------------------
����
RANK() OVER()
ROW_NUMBER() OVER()

SELECT *
FROM PRODUCTS
ORDER BY OUTPUT_PRICE DESC;
--���� ��� ��󳻱� ����� RANK()OVER()���
SELECT * FROM(
SELECT RANK()OVER(ORDER BY OUTPUT_PRICE DESC) RNK, PRODUCTS.*
FROM PRODUCTS)
WHERE RNK <= 3;

-----FROM ���� ���� INLINE VIEW
SELECT ROWNUM RN, MEMBER.* FROM MEMBER--ROWNUM=���ȣ �ٿ���(�켱������ ORDER BY���� ����)
ORDER BY REG_DATE DESC;
--ORDER BY ���� �����ϱ�_SUBQUERY���
SELECT * FROM (
SELECT ROWNUM RN, A.* FROM
(SELECT * FROM MEMBER ORDER BY REG_DATE DESC) A)--ORDER BY �켱�������� SUBQUERY���
WHERE RN <= 3;--RN��Ī�� ���� ���� SELECT��RN�� FROM���� ���Ѵ�.

--ROW_NUMBER() OVER()�Լ��� �̿��ϸ� ���������� ���� �� �ִ�.
SELECT * FROM(
SELECT ROW_NUMBER() OVER(ORDER BY REG_DATE DESC) RN, MEMBER.*
FROM MEMBER) WHERE RN<=3;