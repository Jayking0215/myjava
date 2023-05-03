#제어문
if문
if 조건식 then 실행문
elsif 조건식 then 실행문
else
    실행문
end if;--자바의 중괄호 같은 역할
--------------------------------------------------------------------------------
--사번을 in 파라미터로 넘기면 해당 사원의 부서번호,사원명,부서명을 출력하는 프로시저(단 부서명은 한글로)
--10번부서'회계부서', 20'연구부서', 30'영업부서' 40'운영부서'
create or replace procedure dept_search
(pno in number)
is
vdno emp.deptno%type;
vname emp.ename%type;
vdname varchar2(20);
begin
    select deptno, ename
    into vdno, vname
    from emp where empno=pno;
    if vdno=10 then vdname :='회계부서';
    elsif vdno=20 then vdname :='연구부서';
    elsif vdno=30 then vdname :='영업부서';
    else
        vdname:='운영부서';
    end if;
    dbms_output.put_line(pno||'번 '||vname||'님은 '||vdno||'번 부서 ['||vdname||']에 있어요');    
end;
/
set serveroutput on
select empno from emp
exec dept_search(7369);
exec dept_search(7521);


[실습]
--IF~END IF 문으로 SCOTT의 연봉을 계산하세요.
--COMM이 널일 경우와 널이 아닐 경우를 나눠서 계산하여 출력하세요
--IF~END IF 문으로 인파라미터로 사원명을 받아 해당 사원의 연봉을 계산하세요.
--COMM이 널일 경우와 널이 아닐 경우를 나눠서 계산하여 출력하세요
create or replace procedure emp_sal
(pname in varchar2)
is
vsal emp.sal%type;
vcomm emp.comm%type;
vtotal number;
begin
    select sal,comm--을
    into vsal,vcomm--에 넣는다
    from emp where ename=upper(pname);
    if vcomm is null then vtotal:=vsal*12; --null값 비교는 is사용
    else vtotal:=vsal*12+vcomm;
    end if;
    dbms_output.put_line(pname||'님의 연봉은 '||to_char(vtotal,'$999,999')||'입니다');
    dbms_output.put_line('월 급여: '||vsal||', 보너스: '||vcomm);  
    exception
    when no_data_found then 
        dbms_output.put_line(pname||'님은 없습니다');
    when too_many_rows then
        dbms_output.put_line(pname||'님의 데이터가 2건 이상입니다.');
end;
/
exec emp_sal('smith');
exec emp_sal('smooth');
exec emp_sal('james');
--------------------------------------------------------------------------------
#반복문
--- for loop
--- loop
--- while loop

--[1]for loop문
--for 변수 in 시작값 .. 끝값 loop --역순행하고 싶은경우 시작값 앞에 [reverse]넣는다(=감소식)
--    실행문
--end loop;

--for loop문 이용하면 cursor를 open, fetch, close하는 절차가 필요없다.(자동으로 됨)
declare --익명 프로시저
begin
    for i in reverse 10 .. 20 loop
        dbms_output.put_line('Hello '||i);
    end loop;
end;
/

declare
begin
    for k in (select * from member where job='학생') loop
    --k는 record type의 변수
        dbms_output.put_line(k.name||': '||k.job||' '||k.userid);
    end loop;
end;
/
--------------------------------------------------------------------------------
--[2]loop문
--loop
--    exit when 조건문;
--    실행문;
--end loop;

--emp테이블에 사원정보를 등록하되 반복문 이용해서 사번9000번에서 10씩 증가시켜서 넣기
--사원명 'JAMES'
--입사일 sysdate
-- 9090번이 되면 반복문 이탈
declare
vno number(4):= 9000;
begin
    loop
        insert into emp(empno,ename,hiredate)
        values(vno,upper('james'),sysdate);
        vno := vno+10;
        exit when vno>=9090; --없으면 무한loop 돈다.
    end loop;
    dbms_output.put_line('데이터 삽입 성공'||(vno-9000)/10||'건의 데이터 입력');
end;
/

select * from emp order by 1 desc;
rollback;
--------------------------------------------------------------------------------
--[3]while loop문
--while 조건문 loop
--    실행뭉
--    변수 증감식;
--end loop;

declare
    cnt number(4):=1000;
begin
    while cnt<1005 loop
        insert into emp(empno,ename,hiredate)
        values(cnt,'james'||cnt,sysdate);
        cnt:=cnt+1;
    end loop;
    dbms_output.put_line(cnt-1000||'건의 데이터 입력 완료');
end;
/

select * from emp order by 1 asc;
rollback;
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
#암시적 커서
--모든 dml문장과 select문에는 암시적 cursor가 존재한다.
--개발자가 직접 open,fetch,close할 수 없지만 속성을 이용해서 정보 활용 가능

사번을 in 파라미터로 넘기면 해당 사원의 급여를 10% 인상시키는 프로시저
create or replace procedure IMPLICIT_CURSOR
(pno in emp.empno%type)
is
    vsal emp.sal%type;
    vrow number;
begin
    select sal
    into vsal
    from emp where empno=pno;
    --데이터가 발견된 경우라면 급여를 10%인상
    if sql%found then
        dbms_output.put_line('검색한 데이터가 있어요: 급여=>'||vsal);
    end if;
    
    update emp set sal=sal*1.1 where empno=pno;
    --수정한 데이터 수를 vrow에 저장
    vrow := sql%rowcount;
    dbms_output.put_line('급여가 인상된 사원 수: '||vrow);
    
    select sal
    into vsal
    from emp where empno=pno;
    --데이터가 발견된 경우라면 급여를 10%인상
    if sql%found then
        dbms_output.put_line('10% 급여 인상 후: 급여=>'||vsal);
    end if;
end;
/
exec implicit_cursor(7788);
select * from emp;
rollback;
--------------------------------------------------------------------------------
여러 건의 데이터를 select하는 문장에서 묵시적 cursor를 사용하면 too_many_rows에러 발생
==>명시적 cursor 사용 권장

create or replace procedure dept_all
is--변수선언부
vno number;
vname varchar2(30);
vloc varchar2(30);
begin--실행부
    select deptno,dname,loc
    into vno,vname,vloc
    from dept;
end;
/
exec dept_all;--에러발생
----->명시적 cursor로 문제 해결
--선언문에서
--cursor 커서명 is select문;
--open 커서명
--반복문 이용해서 fetch해야함
--close 커서명;
create or replace procedure dept_all
is
vno number;
vname varchar2(30);
vloc varchar2(30);
--cursor 선언
cursor dcr is select deptno,dname,loc from dept;
begin
--cursor  open
open dcr;
    loop
        fetch dcr into vno,vname,vloc;
        exit when dcr%notfound;
        dbms_output.put_line(vno||'  '||rpad(vname,12,' ')||vloc);
    end loop;
--cursor close
close dcr;
end;
/
exec dept_all;

--[실습]
--부서별 해당 부서의 부서번호, 부서명과 사원수, 평균급여를 가져와 출력하는
--프로시저를 작성하세요
create or replace procedure dept_avg_sal
is
vdno dept.deptno%type;
vname dept.dname%type;
vcnt number;
vavg_sal number;
cursor dcr is 
    select dname, count(*), round(avg(sal),2)
    from emp e join dept d
    on e.deptno=d.deptno
    group by dname;
begin
    open dcr;
        dbms_output.put_line('---------------------------------------------');
        dbms_output.put_line('부서번호      부서명        사원수      평균급여');
        dbms_output.put_line('---------------------------------------------');
    loop
        fetch dcr into vname, vcnt, vavg_sal;
        exit when dcr%notfound;
        select deptno into vdno
        from dept where dname=vname;
        dbms_output.put_line(vdno||'    '||vname||'    '||vcnt||'   '||vavg_sal);
        dbms_output.put_line('---------------------------------------------');
        
    end loop;
    close dcr;
end;
/
exec dept_avg_sal;
select dname, count(*),round(avg(sal),2)
from emp e join dept d
on e.deptno = d.deptno
group by dnamel
--------------------------------------------------------------------------------
#for 루프에서 커서 사용
create or replace procedure forcur
is--커서 선언
cursor pcr is
select products_name, output_price
from products order by 1;
begin
--for루프에서 커서사용(open,fetch,close를 알아서 함)
    for p in pcr loop--p변수가 record 타입
        dbms_output.put_line(rpad(p.products_name,14,' ')||to_char(p.output_price,'L999,999,999'));
    end loop;
end;
/
exec forcur;

#for 루프에서 서브쿼리 사용
--커서를 선언할 필요가 없다
--for 변수 in (subquery) loop
--  실행문
--end loop;
declare
begin
    for k in (select * from category order by 3 asc) loop
        dbms_output.put_line(k.category_code||lpad(k.category_name,16,' '));
    end loop;
end;
/
--------------------------------------------------------------------------------
#예외처리
--미리 정의된 예외처리
CREATE OR REPLACE PROCEDURE EXCEPT_TEST
(VDNO IN NUMBER, VENO IN NUMBER, VNAME IN VARCHAR2)
IS
    VEMP EMP%ROWTYPE;
BEGIN
    INSERT INTO EMP(EMPNO,ENAME,DEPTNO)
    VALUES(VENO, VNAME, VDNO);
--    select empno, ename, deptno
--    ino vemp.empno,vemp.ename, vemp.deptno
--    from emp
--    where deptno = vdno;
    FOR K IN (SELECT EMPNO,ENAME,DEPTNO FROM EMP WHERE DEPTNO=VDNO) LOOP    
        DBMS_OUTPUT.PUT_LINE('--------------------------');
        DBMS_OUTPUT.PUT_LINE('사번: '||K.EMPNO);
        DBMS_OUTPUT.PUT_LINE('이름: '||K.ENAME);
        DBMS_OUTPUT.PUT_LINE('부서번호: '||K.DEPTNO);    
    END LOOP;
    
    EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('데이터가 2건 이상이에요. 커서를 이용하세요');
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE(VENO||'번 사원은 이미 있습니다');
    when others then
        dbms_output.put_line('기타 에러 발생: '||SQLERRM||' '||SQLCODE);
END;
/
exec except_test(10,1000,'peter');--에러발생
exec except_test(10,1001,'susan');
rollback;
alter table emp add constraint emp_empno_uk unique(empno);--uk없어서 추가지정
--------------------------------------------------------------------------------
#사용자 정의 예외처리
--job별로 사원수가 4명보다 적으면 사용자 정의 예외를 발생시킨다
--in파라미터로 job을 받아서 인원이 4명 미만이면 에러 발생
create or replace procedure user_except 
(pjob in emp.job%type)
is
--사용자 정의 예외 선언[1]
--예외이름 exception
    user_define_error exception;
    vcnt number;
begin
--raise문을 이용해 예외를 발생[2]
    select count(empno) 
    into vcnt
    from emp
    where job=upper(pjob);
    if vcnt<4 then 
        raise user_define_error;
    end if;
    dbms_output.put_line(pjob||'사원 수는 '||vcnt||'명입니다');
exception
    --예외처리 단계 raise_application_error()함수 활용[3]
    when user_define_error then
        raise_application_error(-20001,pjob||'업무에 사원이 너무 적어요. 인원을 늘려주세요');
end;
/
exec user_except('analist');
exec user_except('clerk');

