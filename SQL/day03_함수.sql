--����Ŭ�� �Լ�
--# ������ �Լ�
--[1] ������ �Լ�
--[2] ������ �Լ�
--[3] ��¥�� �Լ�
--[4] ��ȯ�� �Լ�
--[5] ��Ÿ �Լ�
-----------------------------
--[1]������ �Լ�
--LOWER()/UPPER(): �ҹ���/�빮�ڷ� �ٲ� ����ϴ� �Լ�
SELECT LOWER('Happy Birthday to You'), UPPER('Happy Birthday to You')
FROM DUAL;--����Ŭ�� from�ڿ� �ݵ�� ���� �;��Ѵ�

--DUAL : �������̺�, 1���� �ุ ���´�.
select * from dual;

--INITCAP(��) : ù ���ڸ� �빮�ڷ� �������� �ҹ��ڷ� ��ȯ
select initcap(ename) from emp;

--CONCAT(�÷�1, �÷�2): �÷�1�� �÷�2�� ������ ���� ��ȯ
SELECT concat('abcd', '1234') from dual;
select empno, ename, job, concat(ename, empno), concat(ename, job) from emp;

--SUBSTR(�÷�, N, LEN):�÷��� N���� LEN���̸�ŭ ��ȯ
select substr('091224-1012456',1,6) from dual;--������� ���
select substr('091224-1012456',8) from dual;--���ڸ��� ���
select substr('091224-1012456',-7) from dual;--�ڿ������� index���
--*SQL�� index 1���� �����Ѵ�.
select substr('ABCDEFG',-4,3) from dual;

--LENGTH(�÷�): ���ڿ��� ���� ��ȯ
select ename, length(ename) from emp;

--[����]
--��� ���̺��� ù���ڰ� 'K'���� ũ�� 'Y'���� ���� ����� ���,�̸�,����,�޿��� ����ϼ���. �� �̸������� �����ϼ���.
select empno, ename, job, sal
from emp
where substr(ename, 1, 1)>'K' and substr(ename,1,1)<'Y';

--������̺��� �μ��� 20���� ����� ���,�̸�,�̸��ڸ���,�޿�,�޿��� �ڸ����� ����ϼ���.	
select empno, ename,deptno, length(ename), sal, length(sal)
from emp
where deptno=20;
--������̺��� ����̸� �� 6�ڸ� �̻��� �����ϴ� ������̸��� �̸��ڸ����� �����ּ���.
select ename, length(ename)
from emp
where length(ename)>=6;

--LPAD()/ RPAD():������ ������ �ΰ� data�� ����ϰ��� �Ҷ� ���
--LPAD(�÷�,n,c):�÷����� n�ڸ���ŭ ����ϵ�, ���ʿ� ���� ������ ������ c������ ä���.
--RPAD(�÷�,n,c):�÷����� n�ڸ���ŭ ����ϵ�, �����ʿ� ���� ������ ������ c������ ä���.
select ename, lpad(ename,15,'*') from emp;--����������
select ename, lpad(ename,15,'*'), sal, lpad(sal,10,'#') from emp;
select dname, rpad(dname,15,'@') from dept;

--LTRIM()/RTRIM(): ����/������ ������ �����Ѵ�.
--LTRIM(����1, ����2): ����1���� ����2 ����(ù��° ���ں��� �������� ����2�� ����)
select ltrim('TTTHello TEST', 'T') from dual;
select rtrim('TTTHello TEST', 'T') from dual;

--REPLACE(�÷�, ��1,��2):�÷��� �� ��1�� �ش��ϴ� ���� ��2�� ����
select replace('ORACLE TEST','TEST','HI')from DUAL;

--UPDATE ���̺�� SET �÷���1=��1, �÷���2=��2,... WHERE ������

--[����]
--������̺��� 10�� �μ��� ����� ���� ������ �� ������'T'�� �����ϰ� �޿��� ������ 0�� �����Ͽ� ����ϼ���.      
select ENAME, JOB, RTRIM(JOB,'T'), SAL, RTRIM(SAL,0) 
from emp;
--������̺� JOB���� 'A'�� '$'�� �ٲپ� ����ϼ���.
select ENAME, JOB, replace(JOB,'A','$')
from emp;
--�� ���̺��� ������ �ش��ϴ� �÷����� ���� ������ �л��� ������ ��� ���л����� ������ ��µǰ� �ϼ���.
SELECT NAME,JOB, REPLACE(JOB,'�л�','���л�') FROM MEMBER;
--�� ���̺� �ּҿ��� ����ø� ����Ư���÷� �����ϼ���
UPDATE MEMBER SET ADDR='����Ư���� ����' WHERE NAME='ȫ�浿' AND JOB='�ֺ�';--��� �����
SELECT * FROM MEMBER;
ROLLBACK;
--UPDATE MEMBER SET ADDR=REPLACE(ADDR,'�����','����Ư����');--��� �����Ͱ� ����Ǿ� ���輺�� �ִ�.
----------------------------------------------------------------------------------------------
[2] ������ �Լ�
--ROUND():�ݿø��Լ�
--ROUND(��), ROUND(��,�ڸ���):�ڸ����� ����� �Ҽ��ڸ��� �ݿø�, ������ �����ڸ��� �ݿø��Ѵ�.
SELECT ROUND(4567.678), ROUND(4567.678,0), ROUND(4567.678,2), ROUND(4567.678,-2) FROM DUAL;

--TRUNC(��), TRUNC(��,�ڸ���):�����Լ�, ����
SELECT TRUNC(4567.678), TRUNC(4567.678,0), TRUNC(4567.678,2),TRUNC(4567.678,-2) FROM DUAL;

--MOD(��1, ��2):��1�� ��2�� ���� ���������� ��ȯ�ϴ� �Լ�
SELECT MOD(100,3) FROM DUAL;

--[��1] MEMBER���̺��� �� �̸���,���ϸ���,���̸� ����ϰ�, ���ϸ����� ���̷� ���� ���� �ݿø��Ͽ� ����ϼ���
SELECT NAME,MILEAGE,AGE, ROUND(MILEAGE/AGE FROM MEMBER;
--[��2] ��ǰ ���̺��� ��ǰ ������� ����������� ���� ��ۺ� ���Ͽ� ����ϼ���.
SELECT TRANS_COST, TRUNC(TRANS_COST, -3)FROM PRODUCTS;
--[��3] ������̺��� �μ���ȣ�� 10�� ����� �޿��� 30���� ���� �������� ����ϼ���.
SELECT ENAME, SAL, DEPTNO, ROUND(SAL/30),MOD(SAL,30)
FROM EMP
WHERE DEPTNO=10;

--�ø��Լ�/�����Լ�
--CEIL()/FLOOR()
SELECT CEIL(12.0001) FROM DUAL;--13
SELECT FLOOR(12.001) FROM DUAL;--12
--���밪 ABS()
SELECT NAME, AGE, 40-AGE FROM MEMBER;
SELECT NAME, AGE, ABS(40-AGE) "40������ ��������" FROM MEMBER;

[3] ��¥�� �Լ�
--��¥ ����
SELECT SYSDATE, SYSDATE+3, SYSDATE-3 FROM DUAL;
--�ϼ� ����:TO_DATE=CHARŸ���� DATEŸ������ ����,���˹��ڿ��� ��������
SELECT TRUNC(TO_DATE('23/05/05','YY/MM/DD')-SYSDATE) FROM DUAL;

[��1]
--���� �ð����� 2�ð� ���� 2�ð� �� �ð��� ����ϼ���.
--TO_CHAR: ��YY,��MM,��DD,��HH,��MI,��SS
SELECT TO_CHAR(SYSDATE-2/24, 'YY/MM/DD HH:MI:SS'), TO_CHAR(SYSDATE+2/24,'YY/MM/DD HH24:MI:SS') FROM DUAL;
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'CC YEAR MONTH DDD DD D DAY DY') FROM DUAL;--DDD:1�� ���� ���� ��/DD:1��/D:1��
--MONTHS_BETWEEN(D1,D2): �� ��¥ ������ ���� �� ���
SELECT ABS(MONTHS_BETWEEN(SYSDATE, TO_DATE('23/12/24','YY/MM/DD'))) FROM DUAL;
--ADD_MONTHS(DATE,NUMBER):��¥�� NUMBER����ŭ ���� ��¥�� ��ȯ
[��2]
--���÷κ��� 5�� ���� ��¥�� ���
SELECT SYSDATE, ADD_MONTHS(SYSDATE,5) AS "5�� ��" FROM DUAL;
--LAST_DAY(DATE):DATE���� ������ ���� ��ȯ
[��3]
--������̺��� ��������� �ٹ� �ϼ��� �� �� �����ΰ��� ����ϼ���. �� �ٹ��ϼ��� ���� ��������� ����ϼ���.
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) "�ٹ��ϼ�", 
TRUNC((SYSDATE-HIREDATE)/365) "�ټӳ��", 
TRUNC((SYSDATE-HIREDATE)/7) "WEEKS",
TRUNC(MOD(SYSDATE-HIREDATE,7)) "DAYS"
FROM EMP ORDER BY 3;

[4] ��ȯ�� �Լ�
--TO_CHAR(��¥,�������),TO_CHAR(����,�������):DATE/���� ������ ���ڿ��� ��ȯ�ϴ� �Լ�
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(25000,'$99,999') FROM DUAL;--�ƶ��Ƽ���=9��ǥ��
--��1] ��ǰ ���̺��� ��ǰ�� ���� �ݾ��� ���� ǥ�� ������� ǥ���ϼ���. õ�ڸ� ���� , �� ǥ���մϴ�.
SELECT PRODUCTS_NAME ,TO_CHAR(INPUT_PRICE,'L999,999,999')"���ް���" FROM PRODUCTS ORDER BY 2;
--��2] ��ǰ ���̺��� ��ǰ�� �ǸŰ��� ����ϵ� ��ȭ�� ǥ���� �� ����ϴ� ����� ����Ͽ� ����ϼ���.[��: \10,000]
SELECT PRODUCTS_NAME, TO_CHAR(OUTPUT_PRICE,'L999G999G999') "�ǸŰ���" FROM PRODUCTS ORDER BY 2;

--TO_DATE(���ڿ�, �������): ���ڿ��� DATE�������� ��ȯ�ϴ� �Լ�
SELECT SYSDATE-TO_DATE('20220531','YYYYMMDD') FROM DUAL;
--��1] �����̺��� �� ���� �� ������ڰ� 2013�� 6��1�� ���� ����� ���� ������ ���� �ּ���
SELECT * FROM MEMBER
WHERE REG_DATE>TO_DATE('20130601','YYYYMMDD');
--��2] �����̺� �ִ� �� ���� �� ��Ͽ����� 2013���� ���� ������ �����ּ���.
SELECT NAME, REG_DATE FROM MEMBER
WHERE TO_CHAR(REG_DATE,'YYYY')='2013';

--TO_NUMBER(CHAR|VARCHAR2):���ڿ��� ���ڷ� ��ȯ�ϴ� �Լ�
--TO_NUMBER(����, �������)
SELECT TO_NUMBER('$25,000','$99,999')*5 FROM DUAL;
    
[5] ��Ÿ�Լ�:NVL,NVL2,DECODE(),RANK()OVER(),ROW_NUMBER()OVER()
--DECODE(����,��1,'��°�'):������ ��1�϶� '��°�' ��ȯ
SELECT * FROM DEPT;
SELECT ENAME, DEPTNO, DECODE(DEPTNO,10,'ȸ��μ�(ACCOUNTING)',20,'��������(RESEARCH)',30,'�����μ�(SALES)','��Ÿ�μ�') FROM EMP ORDER BY DEPTNO;

--RANK() OVER(�м���):�м����� �������� ��ŷ�� �ű�� �Լ�
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;
SELECT RANK()OVER(ORDER BY SAL DESC)"��ŷ",ENAME, SAL FROM EMP;
SELECT RANK()OVER(ORDER BY SAL DESC)"��ŷ", E.* FROM EMP E;
--FROM���� ���� ALIAS�� ��𼭵� ��밡��, BUT SELECT�� ALIAS�� SELECT������ ��밡��
SELECT * 
FROM(SELECT RANK()OVER(ORDER BY SAL DESC)"RNK", E.* FROM EMP E) 
WHERE RNK<=3;
--���� SELECT�� ALIAS�� FROM���� ���μ� ���
SELECT * FROM(
SELECT ROW_NUMBER() OVER(ORDER BY HIREDATE) RNUM, EMP.* 
FROM EMP)
WHERE RNUM BETWEEN 1 AND 10;--�Խ��� 1������ ǥ��

#�׷��Լ�:COUNT(PK��):ī��Ʈ�ϴ� �Լ�, AVG():��հ�, SUM():�հ谪, MAX():�ִ밪, MIN():�ּҰ�, STDDEV():ǥ������, VARIANCE():�л�...
--GROUP BY���� �Բ� ���� ���� ����
--���� �� �Ǵ� ���̺� ��ü�� ���� �Լ��� ����Ǿ� �ϳ��� ����� ��ȯ�ϴ� �Լ�

--COUNT(PK): COUNT�Լ��� PRIMARY KEY�� ���(������)
SELECT COUNT(EMPNO) FROM EMP;--��ü �����...
SELECT COUNT(MGR) FROM EMP;--NULL���� �����ϰ� COUNTING�Ѵ�
SELECT COUNT(DISTINCT MGR) FROM EMP;--�ߺ����� ���� ���� ��ȯ
SELECT COUNT(*) FROM EMP;--*�� NULL���� COUNTING�Ѵ�
--[��1] emp���̺��� ��� SALESMAN�� ���Ͽ� �޿��� ���,�ְ��,������,�հ踦 ���Ͽ� ����ϼ���.
SELECT AVG(SAL)"AVG_SAL",MAX(SAL)"MX_SAL",MIN(SAL)"MN_SAL",SUM(SAL)"SM_SAL"
FROM EMP
WHERE JOB='SALESMAN';
--[��2] EMP���̺� ��ϵǾ� �ִ� �ο���, ���ʽ��� NULL�� �ƴ� �ο���,���ʽ��� ���,��ϵǾ� �ִ� �μ��� ���� ���Ͽ� ����ϼ���.
SELECT COUNT(EMPNO)"POP",COUNT(COMM)"COMM",AVG(COMM)"AVG_COMM", COUNT(DISTINCT DEPTNO)"C_DEPTNO"
FROM EMP;

--GROUP BY: Ư�� �÷��̳� ���� �������� ���ڵ带 ���
--�����͸� �����Ҷ� ����ϴ� ����. �׷��Լ��� �Բ� �����
--SELECT (--GROUP BY�� ���� �÷���, �׷��Լ��� ��밡��)
--FROM ���̺��
--GROUP BY �÷���

--[��1] �� ���̺��� ������ ������ �� ������ ���� ����� ���� �����ֽÿ�.
SELECT JOB,COUNT(*)"��� ��"
FROM MEMBER
GROUP BY JOB
ORDER BY 2 ASC;
--[��2] �� ���̺��� ������ ����, �� ������ ���� �ִ� ���ϸ��� ������ �����ּ���.
SELECT JOB, MAX(MILEAGE)
FROM MEMBER
GROUP BY JOB;
--��3] ��ǰ ���̺��� �� ��ǰī�װ����� �� �� ���� ��ǰ�� �ִ��� �����ּ���.���� �ִ� �ǸŰ��� �ּ� �ǸŰ��� �Բ� �����ּ���.
SELECT CATEGORY_FK, COUNT(*)"��", MAX(OUTPUT_PRICE), MIN(OUTPUT_PRICE)
FROM PRODUCTS
GROUP BY CATEGORY_FK
ORDER BY 1;
--��4] ��ǰ ���̺��� �� ���޾�ü �ڵ庰�� ������ ��ǰ�� ����԰��� �����ּ���	
SELECT EP_CODE_FK, ROUND(AVG(INPUT_PRICE))
FROM PRODUCTS
GROUP BY EP_CODE_FK;
--��5] ��� ���̺��� �Ի��� �⵵���� ��� ���� �����ּ���.
SELECT TO_CHAR(HIREDATE, 'YYYY'), COUNT(EMPNO)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY')
ORDER BY 1;
--��6] ��� ���̺��� �ش�⵵ �� ������ �Ի��� ������� �����ּ���.
SELECT TO_CHAR(HIREDATE, 'YYYY-MM'), COUNT(EMPNO)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
ORDER BY 1;
--��7] ��� ���̺��� ������ �ִ� ����, �ּ� ������ ����ϼ���
SELECT JOB, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY JOB
ORDER BY 1;

--HAVING():GROUP BY���� �Բ� ���.(GROUP BY�� ������)
--GROUP BY�� ������ �ξ� �����͸� ��ȸ�� �� ���
--WGHO������ ���� WHERE�� HAVING���� ���� ��µǱ� ����
SELECT JOB,COUNT(*)
FROM MEMBER
GROUP BY JOB
HAVING COUNT(*)>=2;

--��1] �� ���̺��� ������ ������ �� ������ ���� �ִ� ���ϸ��� ������ �����ּ���.��, �������� �ִ� ���ϸ����� 0�� ���� ���ܽ�ŵ�ô�.
SELECT JOB, MAX(MILEAGE)
FROM MEMBER
GROUP BY JOB
HAVING MAX(MILEAGE)>0; --HAVING MAX(MILEAGE)<>0;==NOT EQUAL
--��2] ��ǰ ���̺��� �� ī�װ����� ��ǰ�� ���� ���, �ش� ī�װ��� ��ǰ�� 2���� ��ǰ���� ������ �����ּ���.
SELECT CATEGORY_FK, COUNT(CATEGORY_FK)
FROM PRODUCTS
GROUP BY CATEGORY_FK
HAVING COUNT(CATEGORY_FK)=2;
--��3] ��ǰ ���̺��� �� ���޾�ü �ڵ庰�� ��ǰ �ǸŰ��� ��հ� �� ������ 100������ �������� �׸��� ������ �����ּ���
SELECT EP_CODE_FK, AVG(OUTPUT_PRICE)
FROM PRODUCTS
GROUP BY EP_CODE_FK
HAVING MOD(AVG(OUTPUT_PRICE),100)=0;