--#Function
--사번을 in parameter로 넘기면 해당 사원의 부서명을 반환하는 함수
create or replace function getDname
(pname in emp.ename%type)
return varchar2--반환타입 지정
is
vdno emp.deptno%type;
vdname dept.dname%type;
begin
    select deptno
    into vdno
    from emp where ename=upper(pname);
    
    select dname
    into vdname
    from dept where deptno=vdno;
    
    return vdname;--값을 반환
    
    exception
    when no_data_found then
        dbms_output.put_line(pname||'사원은 없습니다.');
        return SQLERRM;
    when to_many_rows then
        dbms_output.put_line(pname||'사원 데이터가 2건 이상입니다');
        return SQLERRM;
    when others then
        return SQLERRM;
end;
/
var gname varchar2;
exec :gname := getDname('james');
print gname

--함수의 반환값을 받기 위한 바인드 변수 선언
var gname varchar2;
set serverout on
exec :gname := getDname('king');
print gname
--------------------------------------------------------------------------------
#패키지
--여러개의 프로시저, 함수, 커서 등을 하나의 패키지로 묶어 관리할 수 있다.
--[1]패키지 선언부
--[2]패키지 본문(package body)
--------------------------------------------------------------------------------
--[1] 패키지 선언부
create or replace package empInfo as
procedure allEmp;
procedure allSal;
end empInfo;
/
--[2] 패키지 본문 구성
create or replace package body empInfo as
    -- allEmp : 모든 사원의 사번,이름,입사일 가져와 출력하는 프로시저
    procedure allEmp
    is
    cursor empCr is
        select empno,ename,hiredate from emp order by 3;    
    begin
        for k in empCr loop
            dbms_output.put_line(k.empno||lpad(k.ename,16,' ')||lpad(k.hiredate,16,' '));
        end loop;
        exception
            when others then 
                dbms_output.put_line(SQLERRM||'에러 발생');
    end allEmp;
    -- allSal : 전체 사원의 급여합계,사원수,평균급여,최대급여,최소급여
procedure allSal
is
begin
    dbms_output.put_line('급여총합'||lpad('사원수',10,' ')||lpad('평균급여',10,' ')||lpad('최대급여',10,' ')||lpad('최소급여',10,' '));
    dbms_output.put_line('------------------------------------------------------------------');
    for k in (select sum(sal) total, count(empno) cnt, round(avg(sal)) av,max(sal) mx, min(sal) mn from emp) loop
    dbms_output.put_line(k.total||lpad(k.cnt,10,' ')||lpad(k.av,10,' ')||lpad(k.mx,10,' ')||lpad(k.mn,10,' '));
    end loop;
end allSal;    
end empInfo;
/
exec empInfo.allEmp;
exec empInfo.allSal;
--------------------------------------------------------------------------------
#Trigger
--insert,update,delete문이 실행될 때 묵시적으로 수행되는 일종의 프로시저

--부서명이 수정될 때 이전 부서명과 변경된 부서명을 기록으로 남기는 트리거
create or replace trigger trg_dept
before update on dept
for each row
declare
    MSG varchar2(20);
begin
    MSG:='hi trigger';
    dbms_output.put_line(MSG);
    dbms_output.put_line('변경 전 컬럼값: '||:old.dname);
    dbms_output.put_line('변경 후 컬럼값: '||:new.dname);
end;
/
select * from dept;
update dept set dname='운영부서' where deptno=40;--출력문보다 실행부가 먼저 수행된다.
rollback;
--trigger 비활성화
--alter trigger 트리거명 disable;
--trigger 활성화
--alter trigger 트리거명 enable;

--trg_dept를 비활성화하고 update문을 수행
alter trigger trg_dept disable;
update dept set dname='운영부서' where deptno=40;
alter trigger trg_dept enable;
rollback;

--데이터사전에서 조회
--user_triggers
select * from user_triggers where trigger_name='trg_dept';

--trigger 삭제
--drop trigger 트리거명;
drop trigger trg_dept;

--EMP 테이블에 데이터가 INSERT되거나 UPDATE될 경우 (BEFORE)
--전체 사원들의 평균급여를 출력하는 트리거를 작성하세요.
--테스트할때는 전체 사원의 급여를 10% 인상시키세요.
--신입사원정보 등록(사번, 사원명, 부서번호, 급여)
create or replace trigger trg_emp_avg
before insert or update on emp
--for each row--생략하면 문장트리거
declare
    avg_sal number(10);
begin
    select avg(sal) into avg_sal from emp;
    dbms_output.put_line('평균 급여: '||avg_sal);
end;
/
select * from user_triggers;
insert into emp(empno,ename,deptno,sal)
values(9003,'TOM',20,4000);
select avg(sal) from emp;
update emp set sal=sal*1.1;
rollback;
--------------------------------------------------------------------------------
--[트리거 실습 1] 행 트리거
--입고 테이블에 상품이 입고될 경우
--상품 테이블에 상품 보유수량이 자동으로 변경되는 
--트리거를 작성해봅시다.
상품테이블 : MYPRODUCT
입고테이블 : MYINPUT
--테이블 생성
create table myproduct(
    pcode char(6) primary key,
    pname varchar2(20) not null,
    pcompany varchar2(20),
    price number(8),
    pqty number(8) default 0
);
--확인
desc myproduct;
--시퀀스 생성(1씩 증가하는)
create sequence myproduct_seq
start with 1
increment by 1
nocache;

insert into myproduct
values('A00'||myproduct_seq.nextval,'노트북','A사',800000,10);

insert into myproduct
values('A00'||myproduct_seq.nextval,'TV','B사',1000000,20);

insert into myproduct
values('A00'||myproduct_seq.nextval,'킥보드','C사',70000,30);

select * from myproduct;
commit;

--입고 테이블
create table myinput(
    incode number primary key,--입고번호
    pcode_fk char(6) references myproduct(pcode),--입고 상품코드
    indate date default sysdate,
    inqty number(6),--입고 수량
    inprice number(8)--입고 가격
);
desc myinput;

create sequence myinput_seq nocache;

--입고 테이블에 상품이 입고되면 상품 테이블의 보유수량(pqty)을 변경하는 트리거 작성
create or replace trigger trg_input_product
after insert on myinput
for each row
declare
begin
    update myproduct set pqty=pqty+:new.inqty
    where pcode=:new.pcode_fk;
    dbms_output.put_line(:new.pcode_fk||'번 상품이 추가로 '||:new.inqty||'개 들어옴');
end;
/

select * from myproduct;
--A001상품이 추가로 15개 들어옴
insert into myinput(incode,pcode_fk,inqty,inprice)
values(myinput_seq.nextval,'A001',15,500000);

--A002 추가로 8개 들어옴
insert into myinput
values(myinput_seq.nextval,'A002',sysdate,8,700000);
--------------------------------------------------------------------------------
--[실습1] 입고테이블의 수량이 변경될 경우 (update문이 실행될때)
--상품 테이블의 수량을 수정하는 트리거 작성
--:old.inqty차감하고 :new.inqty더하는
create or replace trigger trg_input_product2
after update on myinput
for each row
declare
    gap number;
begin
    gap:= :new.inqty - :old.inqty;
    update myproduct set pqty=pqty+gap
    where pcode=:new.pcode_fk;
    dbms_output.put_line('new: '||:new.inqty||', old: '||:old.inqty||', gap: '||gap);
end;
/
select * from myinput;
update myinput set inqty=7 where incode=4;
select * from myproduct;

--[실습2] 입고 테이블에 데이터가 삭제될 경우(DELETE문이 실행될 때)
--상품 테이블의 수량을 수정하는 트리거를 작성하세요
-- :OLD.INQTY를 차감함
create or replace trigger trg_input_product3
after delete on myinput
for each row
declare
begin
    update myproduct set pqty=pqty-:old.inqty
    where pcode=:old.pcode_fk;
    dbms_output.put_line('old: '||:old.inqty||'수량이 차감되었음');
end;
/
select * from myproduct;
select * from myinput;
delete from myinput where incode=3;
commit;
--------------------------------------------------------------------------------
--[트리거 실습2] - 문장 트리거 : 트리거 이벤트에 대해 딱 한번만 실행함.
--EMP 테이블에 신입사원이 들어오면(INSERT) 로그 기록을 남기자
--어떤 DML문장을 실행했는지, DML이 수행된 시점의 시간, USER 데이터를
--EMP_LOG테이블에 기록하자.
create table emp_log(
    log_code number primary key,
    user_id varchar2(30),
    log_date date default sysdate,
    behavior varchar2(20)
);
--seq생성(번호 증가시켜주는 역할)
create sequence emp_log_seq nocache;
--select to_char(sysdate,'day') from dual;--시스템의 요일정보
create or replace trigger trg_emp_log
before insert on emp
declare
begin
    if to_char(sysdate,'dy') in ('금','토','일') then
        raise_application_error(-20001,'금,토,일요일에는 입력잡업 불가');--사용자 정의 에러 20001~20999(?)
    else
        insert into emp_log(log_code,user_id,log_date,behavior)
        values(emp_log_seq.nextval,user,sysdate,'insert');
    end if;
end;
/
--emp에 사번,사원명,부서번호,입사일을 새로 insert하기
insert into emp(empno,ename,deptno,hiredate)
values(9032,'TOMAS',30,sysdate);

select * from emp_log;
