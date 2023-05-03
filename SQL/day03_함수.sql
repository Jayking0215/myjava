--오라클의 함수
--# 단일행 함수
--[1] 문자형 함수
--[2] 숫자형 함수
--[3] 날짜형 함수
--[4] 변환형 함수
--[5] 기타 함수
-----------------------------
--[1]문자형 함수
--LOWER()/UPPER(): 소문자/대문자로 바꿔 출력하는 함수
SELECT LOWER('Happy Birthday to You'), UPPER('Happy Birthday to You')
FROM DUAL;--오라클은 from뒤에 반드시 무언가 와야한다

--DUAL : 더미테이블, 1개의 행만 갖는다.
select * from dual;

--INITCAP(값) : 첫 문자를 대문자로 나머지는 소문자로 변환
select initcap(ename) from emp;

--CONCAT(컬럼1, 컬럼2): 컬럼1과 컬럼2를 결합한 값을 반환
SELECT concat('abcd', '1234') from dual;
select empno, ename, job, concat(ename, empno), concat(ename, job) from emp;

--SUBSTR(컬럼, N, LEN):컬럼값 N부터 LEN길이만큼 반환
select substr('091224-1012456',1,6) from dual;--생년월일 출력
select substr('091224-1012456',8) from dual;--뒷자리만 출력
select substr('091224-1012456',-7) from dual;--뒤에서부터 index계산
--*SQL은 index 1부터 시작한다.
select substr('ABCDEFG',-4,3) from dual;

--LENGTH(컬럼): 문자열의 길이 반환
select ename, length(ename) from emp;

--[문제]
--사원 테이블에서 첫글자가 'K'보다 크고 'Y'보다 작은 사원의 사번,이름,업무,급여를 출력하세요. 단 이름순으로 정렬하세요.
select empno, ename, job, sal
from emp
where substr(ename, 1, 1)>'K' and substr(ename,1,1)<'Y';

--사원테이블에서 부서가 20번인 사원의 사번,이름,이름자릿수,급여,급여의 자릿수를 출력하세요.	
select empno, ename,deptno, length(ename), sal, length(sal)
from emp
where deptno=20;
--사원테이블의 사원이름 중 6자리 이상을 차지하는 사원의이름과 이름자릿수를 보여주세요.
select ename, length(ename)
from emp
where length(ename)>=6;

--LPAD()/ RPAD():일정한 간격을 두고 data를 출력하고자 할때 사용
--LPAD(컬럼,n,c):컬럼값을 n자리만큼 출력하되, 왼쪽에 남는 공간이 있으면 c값으로 채운다.
--RPAD(컬럼,n,c):컬럼값을 n자리만큼 출력하되, 오른쪽에 남는 공간이 있으면 c값으로 채운다.
select ename, lpad(ename,15,'*') from emp;--오른쪽정렬
select ename, lpad(ename,15,'*'), sal, lpad(sal,10,'#') from emp;
select dname, rpad(dname,15,'@') from dept;

--LTRIM()/RTRIM(): 왼쪽/오른쪽 공백을 제거한다.
--LTRIM(변수1, 변수2): 변수1에서 변수2 제거(첫번째 문자부터 연속적인 변수2를 제거)
select ltrim('TTTHello TEST', 'T') from dual;
select rtrim('TTTHello TEST', 'T') from dual;

--REPLACE(컬럼, 값1,값2):컬럼값 중 값1에 해당하는 값을 값2로 변경
select replace('ORACLE TEST','TEST','HI')from DUAL;

--UPDATE 테이블명 SET 컬럼명1=값1, 컬럼명2=값2,... WHERE 조건절

--[문제]
--사원테이블에서 10번 부서의 사원에 대해 담당업무 중 우측에'T'를 삭제하고 급여중 우측의 0을 삭제하여 출력하세요.      
select ENAME, JOB, RTRIM(JOB,'T'), SAL, RTRIM(SAL,0) 
from emp;
--사원테이블 JOB에서 'A'를 '$'로 바꾸어 출력하세요.
select ENAME, JOB, replace(JOB,'A','$')
from emp;
--고객 테이블의 직업에 해당하는 컬럼에서 직업 정보가 학생인 정보를 모두 대학생으로 변경해 출력되게 하세요.
SELECT NAME,JOB, REPLACE(JOB,'학생','대학생') FROM MEMBER;
--고객 테이블 주소에서 서울시를 서울특별시로 수정하세요
UPDATE MEMBER SET ADDR='서울특별시 강북' WHERE NAME='홍길동' AND JOB='주부';--대상만 변경됨
SELECT * FROM MEMBER;
ROLLBACK;
--UPDATE MEMBER SET ADDR=REPLACE(ADDR,'서울시','서울특별시');--모든 데이터가 변경되어 위험성이 있다.
----------------------------------------------------------------------------------------------
[2] 숫자형 함수
--ROUND():반올림함수
--ROUND(값), ROUND(값,자리수):자리수가 양수면 소수자리를 반올림, 음수면 정수자리를 반올림한다.
SELECT ROUND(4567.678), ROUND(4567.678,0), ROUND(4567.678,2), ROUND(4567.678,-2) FROM DUAL;

--TRUNC(값), TRUNC(값,자리수):버림함수, 절삭
SELECT TRUNC(4567.678), TRUNC(4567.678,0), TRUNC(4567.678,2),TRUNC(4567.678,-2) FROM DUAL;

--MOD(값1, 값2):값1을 값2로 나눈 나머지값을 반환하는 함수
SELECT MOD(100,3) FROM DUAL;

--[문1] MEMBER테이블에서 고객 이름과,마일리지,나이를 출력하고, 마일리지를 나이로 나눈 값을 반올림하여 출력하세요
SELECT NAME,MILEAGE,AGE, ROUND(MILEAGE/AGE FROM MEMBER;
--[문2] 상품 테이블의 상품 정보가운데 백원단위까지 버린 배송비를 비교하여 출력하세요.
SELECT TRANS_COST, TRUNC(TRANS_COST, -3)FROM PRODUCTS;
--[문3] 사원테이블에서 부서번호가 10인 사원의 급여를 30으로 나눈 나머지를 출력하세요.
SELECT ENAME, SAL, DEPTNO, ROUND(SAL/30),MOD(SAL,30)
FROM EMP
WHERE DEPTNO=10;

--올림함수/내림함수
--CEIL()/FLOOR()
SELECT CEIL(12.0001) FROM DUAL;--13
SELECT FLOOR(12.001) FROM DUAL;--12
--절대값 ABS()
SELECT NAME, AGE, 40-AGE FROM MEMBER;
SELECT NAME, AGE, ABS(40-AGE) "40세와의 나이차이" FROM MEMBER;

[3] 날짜형 함수
--날짜 연산
SELECT SYSDATE, SYSDATE+3, SYSDATE-3 FROM DUAL;
--일수 연산:TO_DATE=CHAR타입을 DATE타입으로 변경,포맷문자열로 구성설명
SELECT TRUNC(TO_DATE('23/05/05','YY/MM/DD')-SYSDATE) FROM DUAL;

[문1]
--지금 시각에서 2시간 전과 2시간 후 시각을 출력하세요.
--TO_CHAR: 년YY,월MM,일DD,시HH,분MI,초SS
SELECT TO_CHAR(SYSDATE-2/24, 'YY/MM/DD HH:MI:SS'), TO_CHAR(SYSDATE+2/24,'YY/MM/DD HH24:MI:SS') FROM DUAL;
SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'CC YEAR MONTH DDD DD D DAY DY') FROM DUAL;--DDD:1년 기준 지난 날/DD:1달/D:1주
--MONTHS_BETWEEN(D1,D2): 두 날짜 사이의 개월 수 계산
SELECT ABS(MONTHS_BETWEEN(SYSDATE, TO_DATE('23/12/24','YY/MM/DD'))) FROM DUAL;
--ADD_MONTHS(DATE,NUMBER):날짜에 NUMBER월만큼 더한 날짜를 반환
[문2]
--오늘로부터 5달 뒤의 날짜를 출력
SELECT SYSDATE, ADD_MONTHS(SYSDATE,5) AS "5달 뒤" FROM DUAL;
--LAST_DAY(DATE):DATE월의 마지막 일을 반환
[문3]
--사원테이블에서 현재까지의 근무 일수가 몇 주 몇일인가를 출력하세요. 단 근무일수가 많은 사람순으로 출려하세요.
SELECT ENAME, HIREDATE, TRUNC(SYSDATE-HIREDATE) "근무일수", 
TRUNC((SYSDATE-HIREDATE)/365) "근속년수", 
TRUNC((SYSDATE-HIREDATE)/7) "WEEKS",
TRUNC(MOD(SYSDATE-HIREDATE,7)) "DAYS"
FROM EMP ORDER BY 3;

[4] 변환형 함수
--TO_CHAR(날짜,출력포멧),TO_CHAR(숫자,출력포멧):DATE/숫자 유형을 문자열로 변환하는 함수
SELECT TO_CHAR(SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(25000,'$99,999') FROM DUAL;--아라비아숫자=9로표현
--문1] 상품 테이블에서 상품의 공급 금액을 가격 표시 방법으로 표시하세요. 천자리 마다 , 를 표시합니다.
SELECT PRODUCTS_NAME ,TO_CHAR(INPUT_PRICE,'L999,999,999')"공급가격" FROM PRODUCTS ORDER BY 2;
--문2] 상품 테이블에서 상품의 판매가를 출력하되 주화를 표시할 때 사용하는 방법을 사용하여 출력하세요.[예: \10,000]
SELECT PRODUCTS_NAME, TO_CHAR(OUTPUT_PRICE,'L999G999G999') "판매가격" FROM PRODUCTS ORDER BY 2;

--TO_DATE(문자열, 출력포멧): 문자열을 DATE유형으로 변환하는 함수
SELECT SYSDATE-TO_DATE('20220531','YYYYMMDD') FROM DUAL;
--문1] 고객테이블의 고객 정보 중 등록일자가 2013년 6월1일 이후 등록한 고객의 정보를 보여 주세요
SELECT * FROM MEMBER
WHERE REG_DATE>TO_DATE('20130601','YYYYMMDD');
--문2] 고객테이블에 있는 고객 정보 중 등록연도가 2013년인 고객의 정보를 보여주세요.
SELECT NAME, REG_DATE FROM MEMBER
WHERE TO_CHAR(REG_DATE,'YYYY')='2013';

--TO_NUMBER(CHAR|VARCHAR2):문자열을 숫자로 변환하는 함수
--TO_NUMBER(변수, 출력형식)
SELECT TO_NUMBER('$25,000','$99,999')*5 FROM DUAL;
    
[5] 기타함수:NVL,NVL2,DECODE(),RANK()OVER(),ROW_NUMBER()OVER()
--DECODE(변수,값1,'출력값'):변수가 값1일때 '출력값' 반환
SELECT * FROM DEPT;
SELECT ENAME, DEPTNO, DECODE(DEPTNO,10,'회계부서(ACCOUNTING)',20,'연구부터(RESEARCH)',30,'영업부서(SALES)','기타부서') FROM EMP ORDER BY DEPTNO;

--RANK() OVER(분석절):분석절을 기준으로 랭킹을 매기는 함수
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;
SELECT RANK()OVER(ORDER BY SAL DESC)"랭킹",ENAME, SAL FROM EMP;
SELECT RANK()OVER(ORDER BY SAL DESC)"랭킹", E.* FROM EMP E;
--FROM절에 사용된 ALIAS는 어디서든 사용가능, BUT SELECT절 ALIAS는 SELECT에서만 사용가능
SELECT * 
FROM(SELECT RANK()OVER(ORDER BY SAL DESC)"RNK", E.* FROM EMP E) 
WHERE RNK<=3;
--따라서 SELECT의 ALIAS를 FROM절로 감싸서 사용
SELECT * FROM(
SELECT ROW_NUMBER() OVER(ORDER BY HIREDATE) RNUM, EMP.* 
FROM EMP)
WHERE RNUM BETWEEN 1 AND 10;--게시판 1페이지 표현

#그룹함수:COUNT(PK값):카운트하는 함수, AVG():평균값, SUM():합계값, MAX():최대값, MIN():최소값, STDDEV():표준편차, VARIANCE():분산...
--GROUP BY절과 함께 사용될 때가 많다
--여러 행 또는 테이블 전체에 대해 함수가 적용되어 하나의 결과를 반환하는 함수

--COUNT(PK): COUNT함수는 PRIMARY KEY를 사용(고유값)
SELECT COUNT(EMPNO) FROM EMP;--전체 사원수...
SELECT COUNT(MGR) FROM EMP;--NULL값을 제외하고 COUNTING한다
SELECT COUNT(DISTINCT MGR) FROM EMP;--중복되지 않은 값만 반환
SELECT COUNT(*) FROM EMP;--*은 NULL값도 COUNTING한다
--[문1] emp테이블에서 모든 SALESMAN에 대하여 급여의 평균,최고액,최저액,합계를 구하여 출력하세요.
SELECT AVG(SAL)"AVG_SAL",MAX(SAL)"MX_SAL",MIN(SAL)"MN_SAL",SUM(SAL)"SM_SAL"
FROM EMP
WHERE JOB='SALESMAN';
--[문2] EMP테이블에 등록되어 있는 인원수, 보너스에 NULL이 아닌 인원수,보너스의 평균,등록되어 있는 부서의 수를 구하여 출력하세요.
SELECT COUNT(EMPNO)"POP",COUNT(COMM)"COMM",AVG(COMM)"AVG_COMM", COUNT(DISTINCT DEPTNO)"C_DEPTNO"
FROM EMP;

--GROUP BY: 특정 컬럼이나 값을 기준으로 레코드를 묶어서
--데이터를 관리할때 사용하는 문장. 그룹함수와 함께 사용함
--SELECT (--GROUP BY에 사용된 컬럼명, 그룹함수만 사용가능)
--FROM 테이블명
--GROUP BY 컬럼명

--[문1] 고객 테이블에서 직업의 종류와 각 직업에 속한 사람의 수를 보여주시오.
SELECT JOB,COUNT(*)"사람 수"
FROM MEMBER
GROUP BY JOB
ORDER BY 2 ASC;
--[문2] 고객 테이블에서 직업의 종류, 각 직업에 속한 최대 마일리지 정보를 보여주세요.
SELECT JOB, MAX(MILEAGE)
FROM MEMBER
GROUP BY JOB;
--문3] 상품 테이블에서 각 상품카테고리별로 총 몇 개의 상품이 있는지 보여주세요.또한 최대 판매가와 최소 판매가를 함께 보여주세요.
SELECT CATEGORY_FK, COUNT(*)"종", MAX(OUTPUT_PRICE), MIN(OUTPUT_PRICE)
FROM PRODUCTS
GROUP BY CATEGORY_FK
ORDER BY 1;
--문4] 상품 테이블에서 각 공급업체 코드별로 공급한 상품의 평균입고가를 보여주세요	
SELECT EP_CODE_FK, ROUND(AVG(INPUT_PRICE))
FROM PRODUCTS
GROUP BY EP_CODE_FK;
--문5] 사원 테이블에서 입사한 년도별로 사원 수를 보여주세요.
SELECT TO_CHAR(HIREDATE, 'YYYY'), COUNT(EMPNO)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY')
ORDER BY 1;
--문6] 사원 테이블에서 해당년도 각 월별로 입사한 사원수를 보여주세요.
SELECT TO_CHAR(HIREDATE, 'YYYY-MM'), COUNT(EMPNO)
FROM EMP
GROUP BY TO_CHAR(HIREDATE, 'YYYY-MM')
ORDER BY 1;
--문7] 사원 테이블에서 업무별 최대 연봉, 최소 연봉을 출력하세요
SELECT JOB, MAX(SAL), MIN(SAL)
FROM EMP
GROUP BY JOB
ORDER BY 1;

--HAVING():GROUP BY절과 함께 사용.(GROUP BY의 조건절)
--GROUP BY에 제한을 두어 데이터를 조회할 때 사용
--WGHO순서에 의해 WHERE가 HAVING보다 먼저 출력되기 때문
SELECT JOB,COUNT(*)
FROM MEMBER
GROUP BY JOB
HAVING COUNT(*)>=2;

--문1] 고객 테이블에서 직업의 종류와 각 직업에 속한 최대 마일리지 정보를 보여주세요.단, 직업군의 최대 마일리지가 0인 경우는 제외시킵시다.
SELECT JOB, MAX(MILEAGE)
FROM MEMBER
GROUP BY JOB
HAVING MAX(MILEAGE)>0; --HAVING MAX(MILEAGE)<>0;==NOT EQUAL
--문2] 상품 테이블에서 각 카테고리별로 상품을 묶은 경우, 해당 카테고리의 상품이 2개인 상품군의 정보를 보여주세요.
SELECT CATEGORY_FK, COUNT(CATEGORY_FK)
FROM PRODUCTS
GROUP BY CATEGORY_FK
HAVING COUNT(CATEGORY_FK)=2;
--문3] 상품 테이블에서 각 공급업체 코드별로 상품 판매가의 평균값 중 단위가 100단위로 떨어지는 항목의 정보를 보여주세요
SELECT EP_CODE_FK, AVG(OUTPUT_PRICE)
FROM PRODUCTS
GROUP BY EP_CODE_FK
HAVING MOD(AVG(OUTPUT_PRICE),100)=0;