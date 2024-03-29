[문제]
	
--1] 사원테이블에서 급여가 3000이상인 사원의 정보를 모두 출력하세요.
select * 
from emp 
where sal>=3000;

--2] 사원테이블에서 사번이 7788인 사원의 이름과 부서번호를 출력하세요
select ename,deptno
from emp
where empno = 7788;

--3] 사원테이블이서 입사일이 1981 2월20일 ~ 1981 5월1일 사이에
-- 입사한 사원의 이름,업무 입사일을 출력하되, 입사일 순으로 출력하세요.
select ename,job,hiredate
from emp
where hiredate between '1981-02-20' and '1981-05-01'
order by hiredate asc;--order by 3;

--4] 사원테이블에서 부서번호가 10,20인 사원의 이름,부서번호,업무를 출력하되
--이름 순으로 정렬하시오.
select ename,deptno,job
from emp where deptno in (10,20)
order by ename asc;

--5] 사원테이블에서 1982년에 입사한 사원의 모든 정보를 출력하세요.
select *
from emp
where hiredate like '1982%';

--6] 사원테이블에서 보너스가 급여보다 10%가 많은 사원의 이름,급여,보너스를 출력하세요.
select ename,sal,comm
from emp
where (sal*1.1<=comm);

--7] 사원테이블에서 업무가 CLERK이거나 ANALYST이고
--급여가 1000,3000,5000이 아닌 모든 사원의 정보를 출력하세요.
select *
from emp
where job in ('CLERK','ANALYST') and sal not in (1000,3000,5000);

--8] 사원테이블에서 이름에 L이 두자가 있고 부서가 30이거나
--또는 관리자가 7782번인 사원의 정보를 출력하세요.
select *
from emp
where ename like '%LL%' and deptno=30 or mgr=7782;
--연산자 우선순위 AND>OR

--9] EMP테이블에서 급여가 1000이상 1500이하가 아닌 사원의 정보를 보여주세요
select *
from emp
where sal not between 1000 and 1500;

--10] EMP테이블에서 이름에 'S'자가 들어가지 않은 사람의 이름을 모두 출력하세요.
select ename
from emp  
where ename not like '%S%';

--11] 사원테이블에서 업무가 PRESIDENT이고 급여가 1500이상이거나
--업무가 SALESMAN인 사원의 사번,이름,업무,급여를 출력하세요.
select empno,ename,job,sal
from emp
where job='PRESIDENT' and (sal>=1500 or job='SALESMAN');

--12] 고객 테이블에서 이름이 홍길동이면서 직업이 학생이 정보를 모두 보여주세요.
select *
from member
where name='홍길동' and job='학생';

--13] 고객 테이블에서 이름이 홍길동이거나 직업이 학생이 정보를 모두 보여주세요.
select *
from member
where name='홍길동' or job='학생';

--14] 상품 테이블에서 제조사가 S사 또는 D사이면서 
--판매가가 100만원 미만의 상품 목록을 보여주세요.
select *
from products
where (company='삼성' or company='대우') and output_price<1000000;

--15] 상품 테이블에서 배송비의 내림차순으로 정렬하되, 
--같은 배송비가 있는 경우에는 마일리지의 내림차순으로 정렬하여 보여주세요.
select *
from products
order by trans_cost DESC, mileage DESC;

--16] DEPT테이블에서 컬럼의 첫 글자들만 대문자로 변환하여 모든 부서정보를 출력하라.
select deptno, initcap(DNAME),initcap(LOC)
from dept;

--17] 상품 테이블에서 판매가를 화면에 보여줄 때 금액의 단위를 함께 붙여서 출력하세요.
select products_name, concat(output_price,'원')price
from products;

--18] 고객테이블에서 고객 이름과 나이를 하나의 컬럼으로 만들어 결과값을 화면에 보여주세요.
select concat(name,age)
from member;