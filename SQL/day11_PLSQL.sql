변수유형
<1>scalar유형:number, char, varchar2, boolean, date, long, binary_integer
<2>reference유형:
    -%type:테이블명.컬럼명%type
<3>composite유형
    -복합자료형
<4>lob유형
--------------------------------------------------------------------------------
--사번을 인 파라미터로 넘기면 해당 사원이 정보를 가져와 출력하는 프로시저
create or replace procedure emp_info
(pno in emp.empno%type)--..emp에empno와 같은 타입으로 주겠다.(자료유형 모를때)
is
--    vename varchar2(30); := 'nobody';--scalar형식
    vename emp.ename%type;
    vjob emp.job%type;
    vsal emp.sal%type;
begin
--select 컬럼1, 컬럼2...
--into 변수1, 변수2...
--from 테이블명;
    select ename, job, sal
    into vename, vjob, vsal
    from emp
    where empno = pno;
    dbms_output.put_line('사  번: '||pno); --프로시저 명령어=syso
    dbms_output.put_line('사원명: '||vename);
    dbms_output.put_line('업  무: '||vjob);
    dbms_output.put_line('급  여: '||vsal);
end;
/
set serveroutput on--최초1회실행
execute emp_info(7369);
exec emp_info(7788);
--------------------------------------------------------------------------------
--사번을 in parameter로 넘기면 사원의 이름과 입사일, 부서번호,부서명을 가져오는 프로시저
create or replace procedure emp_rowtype
(pno in emp.empno%type)
is
    vemp emp%rowtype;--%rowtype
    vdname dept.dname%type;
begin
    select ename,hiredate, deptno
    into vemp.ename,vemp.hiredate,vemp.deptno
    from emp
    where empno=pno;
    
    select dname
    into vdname
    from dept
    where deptno=vemp.deptno;
    
    dbms_output.put_line('------------------------------');
    dbms_output.put_line('부서번호  부서명  사원명  입사일');
    dbms_output.put_line('------------------------------');
    dbms_output.put_line(vemp.deptno||' '||vdname||' '||vemp.ename||' '||vemp.hiredate);
    dbms_output.put_line('------------------------------');
    --예외 처리부
    exception 
        when no_data_found then 
            dbms_output.put_line(pno||'번 사원은 존재하지 않아요');
        when others then
            dbms_output.put)line('기타 애러 발생');
end;
/
select empno from emp;
exec emp_rowtype(7521);
exec emp_rowtype(7499);
exec emp_rowtype(8499);
--------------------------------------------------------------------------------
--프로시저 소스 확인
select * from user_source;
select text from user_source
where name='EMP_ROWTYPE';
--------------------------------------------------------------------------------
# composite type(복합 데이터 타입)
-table타입 ==> 자바의 배열과 유사
-record타입 ==> 자바의 class와 유사
--------------------------------------------------------------------------------
#table타입
--부서번호를 in parameter로 넘기면 해당 부서에 소속된 사원의 이름과 업무를 가져오는 프로시저
CREATE OR REPLACE PROCEDURE TABLE_TYPE
(PDNO IN DEPT.DEPTNO%TYPE)
IS
-- 테이블 선언
-- ENAME들을 저장할 TABLE 유형 선언
TYPE ENAME_TABLE IS TABLE OF EMP.ENAME%TYPE
INDEX BY BINARY_INTEGER;
-- JOB들을  저장할 TABLE 유형 선언
type job_table is table of emp.job%type
index by binary_integer;
-- 테이블 타입의 변수 선언
ENAME_ARR ENAME_TABLE;--변수명 타입
job_arr job_table;
-- 인덱스로 사용할 변수 선언
I BINARY_INTEGER :=0;
BEGIN
   -- 반복문 돌면서 EMP에서 데이터를 가져와서 ENAME_ARR에 저장한다
   FOR K IN (SELECT ENAME,JOB FROM EMP WHERE DEPTNO=PDNO) LOOP
       I := I+1;
       ENAME_ARR(I) := K.ENAME;
       -- JOB도 저장      
       job_arr(i) := k.job;
   END LOOP;
   
   -- 테이블 타입 변수에 저장된 값 출력하기
   DBMS_OUTPUT.PUT_LINE('------'||PDNO||'번 부서--------');
   FOR J IN 1 .. I LOOP -- 1부터 I값까지 1씩증가하면서 반복문을 실행한다
       DBMS_OUTPUT.PUT_LINE(rpad(ENAME_ARR(J), 16,' ')||job_arr(j));
   END LOOP;
END;
/
set serveroutput on
exec table_type(10);
exec table_type(20);
exec table_type(30);
--------------------------------------------------------------------------------
#record type
--사원명을 in parameter로 전달하면 해당 사원 정보를 출력하는 프로시저
-- 사번,업무,급여
create or replace procedure record_type
(pname in emp.ename%type)
is
--record타입 선언
type emp_record is record(
    vno emp.empno%type,
    vname emp.ename%type,
    vjob emp.job%type,
    vmgr emp.mgr%type,
    vdate emp.hiredate%type,
    vsal emp.sal%type,
    vcomm emp.comm%type,
    vdno emp.deptno%type
);
--record 타입의 변수 선언
emp_rec emp_record;
begin
select * into emp_rec from emp
where ename=upper(pname);
--출력하기
 dbms_output.put_line('---'||pname||'님 정보---');
 dbms_output.put_line('사번 : '||emp_rec.vno);
 dbms_output.put_line('이름 : '||emp_rec.vname);
 dbms_output.put_line('업무 : '||emp_rec.vjob);
 dbms_output.put_line('급여 : '||emp_rec.vsal);
--예외처리
exception 
when no_data_found then
    dbms_output.put_line(pname||'사원은 없어요');
end;
/
exec record_type('king');
exec record_type('queen');
--------------------------------------------------------------------------------
#bind 변수 --전역변수 같은 느낌
--variable 변수명 자료형

variable myvar number
declare
begin
    --bind변수를 참조할 때는 앞에 콜론(:)을 접두어로 붙인다
    :myvar := 500;
end;
/
print myvar
--------------------------------------------------------------------------------
# procedure 파라미터 종류
[1] in parameter : default
[2] out parameter
[3] on out parameter
--------------------------------------------------------------------------------
--in parameter 예제
create or replace procedure dept_add
(vno in number default 99,
vname in dept.dname%type,
vloc in dept.loc%type)
is
begin
    insert into dept(deptno,dname,loc)
    values(vno,vname,vloc);
end;
/
exec dept_add(51,'education','seoul');
exec dept_add(vname=>'planning',vloc=>'suwon');
select * from dept;
rollback;
--------------------------------------------------------------------------------
--out parameter 예제
--프로시져가 호출자에게 넘겨주는 값
--default값 지정 불가

--사번을 인 파라미터로 넘기면 해당 사원의 이름을 아웃 파라미터로 내보내는 프로시저
create or replace procedure ename_find
(
pno in emp.empno%type,
oname out emp.ename%type
)
is
begin
    select ename into oname
    from emp
    where empno=pno;
end;
/
--out parameter를 받아줄 bind변수 선언
var fname varchar2(30);
execute ename_find(7499,:fname);
print fname;
--------------------------------------------------------------------------------
--in out parameter : in도 하고 out도 하는 파라미터
create or replace procedure inout_test
(
a1 in number,
a2 in varchar2,
a3 in out varchar2,
a4 out varchar2
)
is
    msg varchar2(30) := '';
begin
    dbms_output.put_line('----------------');
    dbms_output.put_line('프로시저 시작 전');
    dbms_output.put_line('-----------------');
    dbms_output.put_line('a1: '||to_char(a1,'999,999'));--in
    dbms_output.put_line('a2: '||a2);--in
    dbms_output.put_line('a3: '||a3);--in out
    dbms_output.put_line('a4: '||a4);--out
    
    a3 := '프로시저 밖에서 이값을 받을 수 있을까?';
    msg:= '당연하지!!';
    a4 := msg;--out파라미터 a4에 msg넣기
    
    dbms_output.put_line('----------------');
    dbms_output.put_line('프로시저 시작 후');
    dbms_output.put_line('-----------------');
    dbms_output.put_line('a1: '||to_char(a1,'999,999'));--in
    dbms_output.put_line('a2: '||a2);--in
    dbms_output.put_line('a3: '||a3);--in out
    dbms_output.put_line('a4: '||a4);--out
end;
/
var c varchar2(100);--전역변수(bind) 설정
var d varchar2(100);
execute inout_test(750000,'Hello',:c,:d);
print c;
print d;
--------------------------------------------------------------------------------
# select문을 수행하는 프로시저...(select문이 다중행이면 런타임error발생)
--인 파라미터로 job을 넘기면
--해당 업무를 수행하는 사원정보를 가져오는 프로시저
-- 프로시저명: emp_job_info
-- 사원정보를 받을 변수: %rowtype
create or replace procedure emp_job_info
(
pjob in emp.job%type
)
is
vemp emp%rowtype;
begin
    select * into vemp
    from emp
    where job=upper(pjob);
    dbms_output.put_line('----'||pjob||'----');
    dbms_output.put_line('이름: '||vemp.ename);
end;
/
exec emp_job_info('manager');
--ORA-01422: exact fetch returns more than requested number of rows
--결과값이 다중행을 반환할 때는 커서를 이요해야 한다.
----------------------------error 수정-커서 사용---------------------------------
create or replace procedure emp_job_info
(
pjob in emp.job%type
)
is
vemp emp%rowtype;
--커서 선언
cursor emp_cr is
select * from emp where job=upper(pjob);--커서가 참조하는 문장
begin
    --커서 열기(open)
    open emp_cr;
    --반복문 돌면서 데이터 인출(fetch)
     dbms_output.put_line('----'||upper(pjob)||'----');
    loop
    --데이터 인출
    fetch emp_cr into vemp;
    exit when emp_cr%notfound;--더이상 래코드 발견 안되면 벗어나기
    dbms_output.put_line(rpad(vemp.ename,14,' ')||vemp.sal);
    
    end loop;
    --커서 닫기(close)
    close emp_cr;
    dbms_output.put_line('이름: '||vemp.ename);
end;
/
exec emp_job_info('manager');
exec emp_job_info('salesman');
--------------------------------------------------------------------------------
--부서번호를 in 파라미터로 전달하면
--해당 부서의 사원정보를 out파라미터로 내보내는 프로시저 작성해서
--java와 연동해봅시다
--이름, 업무, 부서명, 근무지, 입사일
create or replace procedure emp_forjava
(
    pdno in emp.deptno%type,
    mycr out sys_refcursor
)
is
begin
    /*
    open mycr for
    select dname,job,dname,loc,hiredate
    from dept d join emp e
   for on d.deptno = e.deptno and e.deptno=pdno;
    */
    --subquery로 진행
    open mycr 
    select ename,job,dname,loc,hiredate from
    (select * from emp where deptno=pdno) a join dept d
    on a.deptno=d.deptno;
end;
/
--------------------------------------------------------------------------------
--//검색어를 입력하면 해당 검색어를 갖는 메모글을 가져오는 프로시저 작성하고
--//자바와 연동시키세요
create or replace procedure memo_find
(
jmsg in MEMO.msg%type,
mycr out sys_refcursor
)
is
begin
    open mycr for
    select no,name,MSG,wdate
    from memo where MSG like '%'||jmsg||'%';
end;
/