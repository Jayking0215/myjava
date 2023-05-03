# SUBQUERY
--문1]사원테이블에서 SCOTT의 급여보다 많은 사원의 사원번호, 이름, 업무, 급여를 출력
SELECT SAL FROM EMP WHERE ENAME='SCOTT ';
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP WHERE SAL>3000;
--SUBQUERY사용
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME='SCOTT');--서브쿼리 결과가 하나만 나오는것을 단일행 서브쿼리

--문제1] 사원테이블에서 사원번호가 7521인 사원과 업무가 같고 급여가
--7934인 사원보다 많은 사원의 사번,이름,업무,입사일자,급여를 출력하세요.
SELECT EMPNO, ENAME,JOB, HIREDATE, SAL
FROM EMP
WHERE JOB = (SELECT JOB FROM EMP WHERE EMPNO=7521) 
AND SAL > (SELECT SAL FROM EMP WHERE EMPNO=7934);

# 단일행 서브쿼리: 비교연산자 사용(평균급여)
--문제2]사원테이블에서 급여의 평균보다 적은 사원의 사번,이름,업무,급여,부서번호를 출력하세요.
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO
FROM EMP
WHERE SAL < (SELECT AVG(SAL) FROM EMP);

# 다중행 서브쿼리: 서브쿼리 결과가 다중행
--다중행 서브쿼리 연산자
--IN
--ANY
--ALL
--EXIST

[1]IN 연산자
--문1]업무별로 최대 급여를 받는 사원의 사원번호와 이름을 출력하세요.
SELECT EMPNO, ENAME, JOB, SAL
FROM EMP
WHERE (JOB,SAL) IN
(SELECT JOB, MAX(SAL)
FROM EMP
GROUP BY JOB);

--문2]부서별로 최소급여를 받는 사원의 사번,이름,부서번호,급여,업무를 출력하세요
SELECT EMPNO, ENAME, DEPTNO, SAL, JOB
FROM EMP
WHERE (DEPTNO, SAL) 
IN
(SELECT DEPTNO, MIN(SAL) FROM EMP GROUP BY DEPTNO);

[2]ANY 연산자:서브쿼리 결과값 중 어느 하나라도 만족하면 결과 반환
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > ANY(SELECT SAL FROM EMP WHERE JOB='SALESMAN');--SALESMAN의 연봉중 하나라도 높기만하면 된다(=MIN(SAL))
--동일한 내용
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > (SELECT MIN(SAL) FROM EMP WHERE JOB='SALESMAN');

[3]ALL 연산자: 서브쿼리 결과값 중 모든 결과값이 만족하면 결과 반환
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
SAL > ALL(SELECT SAL FROM EMP WHERE JOB='SALESMAN');--SALESMAN의 연봉들 보다 높아야한다(=MAX(SAL))
--동일한 내용
SELECT ENAME, SAL FROM EMP
WHERE DEPTNO<>20 AND
WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE JOB='SALESMAN');

[4]EXISTS 연산자:서브쿼리의 데이터가 존재하는지 여부를 따져서 존재하는 값만 반환
--문1]사원들을 관리하는 관리자의 정보를 보여주세요.
SELECT EMPNO, ENAME, JOB FROM EMP E
WHERE EXISTS(SELECT EMPNO FROM EMP WHERE E.EMPNO = MGR);

--1]고객 테이블에 있는 고객 정보 중 마일리지가 가장 높은 금액의 고객 정보를 보여주세요.
SELECT *
FROM MEMBER
WHERE MILEAGE =
(SELECT MAX(MILEAGE) FROM MEMBER);
--2]상품 테이블에 있는 전체 상품 정보 중 상품의 판매가격이 
--판매가격의 평균보다 큰  상품의 목록을 보여주세요. 
--단, 평균을 구할 때와 결과를 보여줄 때의 판매 가격이 50만원을 넘어가는 상품은 제외시키세요.
SELECT * FROM PRODUCTS
WHERE OUTPUT_PRICE >
(SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS WHERE OUTPUT_PRICE <= 500000)
AND OUTPUT_PRICE <= 500000;
--3]상품 테이블에 있는 판매가격에서 평균가격 이상의 상품 목록을 구하되 평균을
--구할 때 판매가격이 최대인 상품을 제외하고 평균을 구하세요
SELECT * FROM PRODUCTS
WHERE OUTPUT_PRICE >=(
SELECT AVG(OUTPUT_PRICE) FROM PRODUCTS 
WHERE OUTPUT_PRICE <> (SELECT MAX(OUTPUT_PRICE) FROM PRODUCTS));
--4]상품 카테고리 테이블에서 카테고리 이름에 컴퓨터라는 단어가 포함된 카테고리에
--속하는 상품 목록을 보여주세요.
SELECT * FROM PRODUCTS
WHERE CATEGORY_FK IN
(SELECT CATEGORY_CODE FROM CATEGORY WHERE CATEGORY_NAME LIKE '%컴퓨터%');
--5]고객 테이블에 있는 고객정보 중 직업의 종류별로 가장 나이가 많은 사람의 정보를 화면에 보여주세요.
--다중행 다중열 서브쿼리(=GROUP BY)
SELECT * FROM MEMBER
WHERE (JOB, AGE)
IN
(SELECT JOB, MAX(AGE) FROM MEMBER GROUP BY JOB);
--6]고객 테이블에 있는 고객 정보 중 마일리지가 가장 높은 금액을
--	     가지는 고객에게 보너스 마일리지 5000점을 더 주는 SQL을 작성하세요.
UPDATE MEMBER SET MILEAGE=MILEAGE+5000
WHERE MILEAGE = (SELECT MAX(MILEAGE) FROM MEMBER);

SELECT * FROM MEMBER;
--7] 고객 테이블에서 마일리지가 없는 고객의 등록일자를 고객 테이블의 
--	      등록일자 중 가장 뒤에 등록한 날짜에 속하는 값으로 수정하세요.
UPDATE MEMBER SET REG_DATE
= (SELECT MAX(REG_DATE) FROM MEMBER)
WHERE MILEAGE = 0;
--8] 상품 테이블에 있는 상품 정보 중 공급가가 가장 큰 상품은 삭제 시키는 
--	      SQL문을 작성하세요.
DELETE FROM PRODUCTS WHERE INPUT_PRICE =
(SELECT MAX(INPUT_PRICE) FROM PRODUCTS);
--9] 상품 테이블에서 상품 목록을 공급 업체별로 정리한 뒤,
--	     각 공급업체별로 최소 판매 가격을 가진 상품을 삭제하세요.
DELETE FROM PRODUCTS 
WHERE (EP_CODE_FK, OUTPUT_PRICE) IN
(SELECT EP_CODE_FK, MIN(OUTPUT_PRICE) FROM PRODUCTS GROUP BY EP_CODE_FK);

# FROM절에 들어가는 SUBQUERY를 INLINE VIEW라고 한다.
--EMP와 DEPT 테이블에서 업무가 MANAGER인 사원의 이름, 업무,부서명,근무지를 출력하세요.
SELECT ENAME, JOB, DNAME, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO AND JOB='MANAGER';
--=>SUBQUERY로 풀기(성능은 SUBQUERY가 더 우수하다)
SELECT ENAME, JOB, DNAME, LOC
FROM 
(SELECT * FROM EMP WHERE JOB='MANAGER') A JOIN DEPT D
ON A.DEPTNO = D.DEPTNO;

--------------------------------------------------------------------
복습
RANK() OVER()
ROW_NUMBER() OVER()

SELECT *
FROM PRODUCTS
ORDER BY OUTPUT_PRICE DESC;
--상위 몇개를 골라내기 어려워 RANK()OVER()사용
SELECT * FROM(
SELECT RANK()OVER(ORDER BY OUTPUT_PRICE DESC) RNK, PRODUCTS.*
FROM PRODUCTS)
WHERE RNK <= 3;

-----FROM 절에 들어가는 INLINE VIEW
SELECT ROWNUM RN, MEMBER.* FROM MEMBER--ROWNUM=행번호 붙여줌(우선순위가 ORDER BY보다 높음)
ORDER BY REG_DATE DESC;
--ORDER BY 먼저 수행하기_SUBQUERY사용
SELECT * FROM (
SELECT ROWNUM RN, A.* FROM
(SELECT * FROM MEMBER ORDER BY REG_DATE DESC) A)--ORDER BY 우선적용위해 SUBQUERY사용
WHERE RN <= 3;--RN별칭을 쓰기 위해 SELECT의RN을 FROM으로 감싼다.

--ROW_NUMBER() OVER()함수를 이요하면 서브쿼리를 줄일 수 있다.
SELECT * FROM(
SELECT ROW_NUMBER() OVER(ORDER BY REG_DATE DESC) RN, MEMBER.*
FROM MEMBER) WHERE RN<=3;