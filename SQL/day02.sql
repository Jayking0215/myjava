--day02.sql
--SELECT�� �ǽ�
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT DEPTNO, DNAME, LOC FROM DEPT;

SELECT ENAME, JOB, SAL, COMM, SAL*12+NVL(COMM,0) AS "��  ��" FROM EMP;

SELECT ENAME, MGR, NVL2(MGR, '������ ����','������ ����') "������ ���翩��" FROM EMP;

--DAY01 ���� ��

--'||' : ���ڿ� ���� ������
SELECT ENAME ||' IS A '|| JOB FROM EMP;
--����] EMP���̺��� �̸��� ������ "KING: 1 YEAR SALARY = 60000" �������� ����϶�.
SELECT ENAME||' : 1 YEAR SALLAY ='|| (SAL*12+NVL(COMM,0)) AS "����� ����" 
FROM EMP ORDER BY SAL DESC;--��������,, �������� ASC

--# DISTINCT: �ߺ��� �����ϰ� 1���� ������
SELECT JOB FROM EMP;
--EMP���� ������� ����ϰ� �ִ� ������ ������ �����ּ���(�ߺ� JOB����)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO ASC;
SELECT DISTINCT NAME, JOB FROM MEMBER;
SELECT UNIQUE NAME, JOB FROM MEMBER;--DISTINCT�� ����
--2] MEMBER���̺��� ȸ���� �̸��� ���� ������ �����ּ���.
--3] CATEGORY ���̺� ����� ��� ������ �����ּ���.
--4] MEMBER���̺��� ȸ���� �̸��� ������ ���ϸ����� �����ֵ�, 
--���ϸ����� 13�� ���� ����� "MILE_UP"�̶�� ��Ī���� �Բ� �����ּ���.
SELECT NAME, AGE FROM MEMBER;
SELECT * FROM CATEGORY;
SELECT NAME, AGE, MILEAGE, MILEAGE*13 AS "MILE_UP" FROM MEMBER;

--WHERE�� : ������
SELECT *FROM EMP WHERE SAL>=3000;
--EMP���̺��� �������� MANAGER�� �����
--������ �����ȣ,�̸�,����,�޿�,�μ���ȣ�� ����ϼ���.
SELECT empno,ename,JOB,sal,deptno FROM EMP WHERE JOB='MANAGER';
--EMP���̺��� 1982�� 1��1�� ���Ŀ� �Ի��� ����� 
--�����ȣ,����,����,�޿�,�Ի����ڸ� ����ϼ���.
SELECT EMPNO,ENAME,JOB,SAL,hiredate FROM EMP WHERE HIREDATE>'82/01/01';
--emp���̺��� �޿��� 1300���� 1500������ ����� �̸�,����,�޿�,
--�μ���ȣ�� ����ϼ���.
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL>=1300 AND SAL<=1500;
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL BETWEEN 1300 AND 1500;
--emp���̺��� �����ȣ�� 7902,7788,7566�� ����� �����ȣ,
--�̸�,����,�޿�,�Ի����ڸ� ����ϼ���.
SELECT EMPNO,ENAME,JOB,SAL,HIREDATE FROM EMP WHERE EMPNO=7902 OR EMPNO=7788 OR EMPNO=7566;
SELECT EMPNO,ENAME,JOB,SAL,HIREDATE FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
--10�� �μ��� �ƴ� ����� �̸�,����,�μ���ȣ�� ����ϼ���
SELECT ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO <> 10;
SELECT ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO != 10;

--# LIKE������
--EMP���̺��� �̸��� S�� ���۵Ǵ� ����� ������ �����ּ���.
select ename from emp where ename like 'S%';
--�̸� �� S�ڰ� ���� ����� ������ �����ּ���.
select ename from emp where ename like '%S%';
-- �̸��� �ι� °�� O�ڰ� ���� ����� ������ �����ּ���.
select ename from emp where ename like '_O%';
--�� ���̺� ��� ���� �达�� ����� ������ �����ּ���.
select * from member where name like '��%';
--�� ���̺� ��� '����'�� ���Ե� ������ �����ּ���.
select * from member where addr like '%����%';
--ī�װ� ���̺� ��� category_code�� 0000�� ���� ��ǰ������ �����ּ���.
select * from category where category_code like '%0000';
--emp���� 82�⵵�� �Ի��� ��������� �����ּ���.
select * from emp where hiredate like '82%';
--��¥������ �ٲٱ�
alter session set nls_date_format='yyyy-mm-dd';--�����Ѹ� ���� �ȴ�
select * from emp where hiredate like '1982%';

--# ��������(and, or, not)
--comm�� null�� ����� �̸�,����,�޿�,���ʽ��� ���
select ename,job,sal,comm from emp where comm is null;--null�� (=)�� �ȴ�..is null/is not null
--EMP���̺��� �޿��� 1100�̻��̰� JOB�� MANAGER�� �����
--���,�̸�,����,�޿��� ����ϼ���.
select empno,ename,job,sal from emp where sal>=1100 and job='MANAGER';
--EMP���̺��� �޿��� 1100�̻��̰ų� JOB�� MANAGER�� �����
--���,�̸�,����,�޿��� ����ϼ���.
select empno,ename,job,sal from emp where sal>=1100 or job='MANAGER';
--EMP���̺��� JOB�� MANAGER,CLERK,ANALYST�� �ƴ�
--����� ���,�̸�,����,�޿��� ����ϼ���.
select empno,ename,job,sal from emp where job!='MANAGER' and job<>'CLERK' and job!='ANALYST';
select empno,ename,job,sal from emp where JOB NOT IN ('MANAGER', 'CLERK', 'ANALYST');

--# oerder by��
--�������� ����: ASC(default)
--�������� ����: DESC
--WGHO����(WHERE GROUPBY Having? ORDERBY
--������̺��� �Ի����� ������ �����Ͽ� ���,�̸�,����,�޿�,
--�Ի����ڸ� ����ϼ���.
select empno,ename,job,sal,hiredate from emp order by HIREDATE;
select empno,ename,job,sal,hiredate from emp order by HIREDATE DESC;--��������
select empno,ename,job,sal,sal*12 ANNSAL from emp order by ANNSAL ASC;--��Ī Ȱ��
select empno,ename,job,sal,sal*12 ANNSAL from emp order by 5 ASC;--index��ȣ Ȱ��
--��� ���̺��� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ���
--�޿��� ���� ������ �����Ͽ� ���,�̸�,����,�μ���ȣ,�޿���
--����ϼ���.
select empno,ename,job,deptno,sal from emp order by deptno ASC, sal DESC;
--��� ���̺��� ù��° ������ �μ���ȣ��, �ι�° ������
--������, ����° ������ �޿��� ���� ������ �����Ͽ�
--���,�̸�,�Ի�����,�μ���ȣ,����,�޿��� ����ϼ���
select empno,ename,job,deptno,sal from emp order by deptno, job, sal DESC;
--1]��ǰ ���̺��� �Ǹ� ������ ������ ������� ��ǰ�� �����ؼ� �����ּ���.
select * from PRODUCTS order by output_price ASC;
--2]�� ���̺��� ������ �̸��� ������ ������ �����ؼ� �����ּ���.
--��, �̸��� ���� ��쿡�� ���̰� ���� ������� �����ּ���.
select * from member order by name ASC, age DESC;
----------�ȹ������ try-----------------------
--3]�� ���̺��� ������ ������ �� ������ ���� ����� ���� 
--���� ������� �����ּ���.
select job,count(*) from member group by job order by count(*) desc;
-- 4]��ǰ���̺��� ���޾�ü���� ����ǸŰ��� ���ϵ� 
--����ǸŰ� ������������ �����ּ���
select EP_CODE_FK, ROUND(AVG(output_price)) from products group by EP_CODE_FK order by 2 ASC;
