--day02.sql
--SELECT문 실습
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT DEPTNO, DNAME, LOC FROM DEPT;

SELECT ENAME, JOB, SAL, COMM, SAL*12+NVL(COMM,0) AS "연  봉" FROM EMP;

SELECT ENAME, MGR, NVL2(MGR, '관리자 있음','관리자 없음') "관리자 존재여부" FROM EMP;

--DAY01 복습 끝

--'||' : 문자열 결합 연산자
SELECT ENAME ||' IS A '|| JOB FROM EMP;
--문제] EMP테이블에서 이름과 연봉을 "KING: 1 YEAR SALARY = 60000" 형식으로 출력하라.
SELECT ENAME||' : 1 YEAR SALLAY ='|| (SAL*12+NVL(COMM,0)) AS "사원의 연봉" 
FROM EMP ORDER BY SAL DESC;--내림차순,, 오름차순 ASC

--# DISTINCT: 중복행 제거하고 1번만 보여줌
SELECT JOB FROM EMP;
--EMP에서 사원들이 담당하고 있는 업무의 종류를 보여주세요(중복 JOB제거)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO, JOB FROM EMP ORDER BY DEPTNO ASC;
SELECT DISTINCT NAME, JOB FROM MEMBER;
SELECT UNIQUE NAME, JOB FROM MEMBER;--DISTINCT와 같다
--2] MEMBER테이블에서 회원의 이름과 나이 직업을 보여주세요.
--3] CATEGORY 테이블에 저장된 모든 내용을 보여주세요.
--4] MEMBER테이블에서 회원의 이름과 적립된 마일리지를 보여주되, 
--마일리지에 13을 곱한 결과를 "MILE_UP"이라는 별칭으로 함께 보여주세요.
SELECT NAME, AGE FROM MEMBER;
SELECT * FROM CATEGORY;
SELECT NAME, AGE, MILEAGE, MILEAGE*13 AS "MILE_UP" FROM MEMBER;

--WHERE절 : 조건절
SELECT *FROM EMP WHERE SAL>=3000;
--EMP테이블에서 담당업무가 MANAGER인 사원의
--정보를 사원번호,이름,업무,급여,부서번호로 출력하세요.
SELECT empno,ename,JOB,sal,deptno FROM EMP WHERE JOB='MANAGER';
--EMP테이블에서 1982년 1월1일 이후에 입사한 사원의 
--사원번호,성명,업무,급여,입사일자를 출력하세요.
SELECT EMPNO,ENAME,JOB,SAL,hiredate FROM EMP WHERE HIREDATE>'82/01/01';
--emp테이블에서 급여가 1300에서 1500사이의 사원의 이름,업무,급여,
--부서번호를 출력하세요.
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL>=1300 AND SAL<=1500;
SELECT ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL BETWEEN 1300 AND 1500;
--emp테이블에서 사원번호가 7902,7788,7566인 사원의 사원번호,
--이름,업무,급여,입사일자를 출력하세요.
SELECT EMPNO,ENAME,JOB,SAL,HIREDATE FROM EMP WHERE EMPNO=7902 OR EMPNO=7788 OR EMPNO=7566;
SELECT EMPNO,ENAME,JOB,SAL,HIREDATE FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
--10번 부서가 아닌 사원의 이름,업무,부서번호를 출력하세요
SELECT ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO <> 10;
SELECT ENAME,JOB,DEPTNO FROM EMP WHERE DEPTNO != 10;

--# LIKE연산자
--EMP테이블에서 이름이 S로 시작되는 사람의 정보를 보여주세요.
select ename from emp where ename like 'S%';
--이름 중 S자가 들어가는 사람의 정보를 보여주세요.
select ename from emp where ename like '%S%';
-- 이름의 두번 째에 O자가 들어가는 사람의 정보를 보여주세요.
select ename from emp where ename like '_O%';
--고객 테이블 가운데 성이 김씨인 사람의 정보를 보여주세요.
select * from member where name like '김%';
--고객 테이블 가운데 '강북'가 포함된 정보를 보여주세요.
select * from member where addr like '%강북%';
--카테고리 테이블 가운데 category_code가 0000로 끝는 상품정보를 보여주세요.
select * from category where category_code like '%0000';
--emp에서 82년도에 입사한 사원정보를 보여주세요.
select * from emp where hiredate like '82%';
--날짜형식을 바꾸기
alter session set nls_date_format='yyyy-mm-dd';--껏다켜면 적용 안댐
select * from emp where hiredate like '1982%';

--# 논리연산자(and, or, not)
--comm이 null인 사원의 이름,업무,급여,보너스를 출력
select ename,job,sal,comm from emp where comm is null;--null은 (=)비교 안댐..is null/is not null
--EMP테이블에서 급여가 1100이상이고 JOB이 MANAGER인 사원의
--사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp where sal>=1100 and job='MANAGER';
--EMP테이블에서 급여가 1100이상이거나 JOB이 MANAGER인 사원의
--사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp where sal>=1100 or job='MANAGER';
--EMP테이블에서 JOB이 MANAGER,CLERK,ANALYST가 아닌
--사원의 사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal from emp where job!='MANAGER' and job<>'CLERK' and job!='ANALYST';
select empno,ename,job,sal from emp where JOB NOT IN ('MANAGER', 'CLERK', 'ANALYST');

--# oerder by절
--오름차순 정렬: ASC(default)
--내림차순 정렬: DESC
--WGHO순서(WHERE GROUPBY Having? ORDERBY
--사원테이블에서 입사일자 순으로 정렬하여 사번,이름,업무,급여,
--입사일자를 출력하세요.
select empno,ename,job,sal,hiredate from emp order by HIREDATE;
select empno,ename,job,sal,hiredate from emp order by HIREDATE DESC;--내림차순
select empno,ename,job,sal,sal*12 ANNSAL from emp order by ANNSAL ASC;--별칭 활용
select empno,ename,job,sal,sal*12 ANNSAL from emp order by 5 ASC;--index번호 활용
--사원 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우
--급여가 많은 순으로 정렬하여 사번,이름,업무,부서번호,급여를
--출력하세요.
select empno,ename,job,deptno,sal from emp order by deptno ASC, sal DESC;
--사원 테이블에서 첫번째 정렬은 부서번호로, 두번째 정렬은
--업무로, 세번째 정렬은 급여가 많은 순으로 정렬하여
--사번,이름,입사일자,부서번호,업무,급여를 출력하세요
select empno,ename,job,deptno,sal from emp order by deptno, job, sal DESC;
--1]상품 테이블에서 판매 가격이 저렴한 순서대로 상품을 정렬해서 보여주세요.
select * from PRODUCTS order by output_price ASC;
--2]고객 테이블의 정보를 이름의 가나다 순으로 정렬해서 보여주세요.
--단, 이름이 같을 경우에는 나이가 많은 순서대로 보여주세요.
select * from member order by name ASC, age DESC;
----------안배웠지만 try-----------------------
--3]고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수가 
--많은 순서대로 보여주세요.
select job,count(*) from member group by job order by count(*) desc;
-- 4]상품테이블에서 공급업체별로 평균판매가를 구하되 
--평균판매가 오름차순으로 보여주세요
select EP_CODE_FK, ROUND(AVG(output_price)) from products group by EP_CODE_FK order by 2 ASC;
