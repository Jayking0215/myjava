#시스템 권한 부여
--WITH ADMIN OPTION을 주어 부여하기
--system으로 접속해서 아래 문장 실행
GRANT CREATE USER, ALTER USER, DROP USER TO MYSTAR
WITH ADMIN OPTION;

--mystar로 접속해서 다른 user를 생성하기_mystar로 변경하기
conn mystar/mystar
show user

create user storm
identified by storm;
--strom도 다른 user를 생성할 권한을 갖는다;with admin option때문

--mystar가 storm user의 비밀번호 변경하기
alter user storm
identified by tigher;

drop user storm;

--system으로 접속해서 mystar의 권한 중 alter user, drop user권한 회수하기
conn system/Abcd1234
show user

권한 회수
--REVOKE 권한|롤 FROM USER|롤
revoke alter user, drop user from mystar;

--mystar로 접속해서 strom 다시 생성하기
conn mystar/mystar
show user
create user storm
identified by storm;
--storm의 비번을 tiger로 변경해보자
alter user storm
identified by tiger;--권한 뺏겨서 안됨
-->01031. 00000 -  "insufficient privileges" 에러발생
------------------------------------SQL실습05_문제 시나리오-------------------------
--=>dos로 실행
--1.
grant create table, create session to storm
with admin option;
--2.
conn storm/storm

create table note(
no number,
msg varchar2(30)
);
=> no privileges on tablespace 'SYSTEM' 에러발생(할당 메모리를 설정하지 않았기때문)
conn system/Abcd1234
alter user storm quota 2M on system;--유저에게 2MB정도의 메모리를 할당해주겠따
conn storm/storm--재접속 후 table생성
create table note(
no number,
msg varchar2(30)
);
--2.2
conn system/Abcd1234

create user miller
identified by miller

grant create session to miller;
--3.
conn storm/storm--storm도 admin권한이라 권한부여 가능
grant create table to miller;--table space에 대한 권한 없어서 매모리 할당해야함

conn system/Abd1234
alter user miller quota unlimited on system;--무제한 할당
--4.
conn miller/miller
create table note(
no number);
--5.
conn system/Abcd1234
revoke create table from storm;

conn storm/storm
create table test(no number);
---=>insufficient privileges에러 발생

--6.miller의 create table 권한은 어떻게 되었을까?
conn miller/miller
create table test(no number);--생성 가능
select * from tab;--note, test확인 가능

--결론:with admin option으로 주었던 권한을 storm에게 취소를 해도
--miller이 create table권한은 취소되지 않는다.
--------------------------------------------------------------------------------

#객체권한이란??
--d-sql수업파일-png이미지 참고

--scott이 storm에게 select, insert권한 부여(옵션권한과 함께)
conn scott/tiger
grant select, insert on emp
to storm
with grant option;
--storm으로 확인
conn storm/storm
select ename,job from scott.emp;
insert into scott.emp(empno,ename,job)
values(8100,'JAMES','MANAGER');
commit;

--storm이 scott.emp테이블을 select하는 권한을 miller에게 부여
grant select on scott.emp to miller;
--miller로 확인
conn miller/miller
select ename,job from scott.emp;
--scott이 storm에게 부여했던 select,insert on emp에 대한 권한을 회수
conn scott/tiger
revoke select, insert on emp from storm;
--확인
conn storm/storm
select ename from scott.emp;--=>error발생(table or view does not exist)
--miller는 어떻게 되었을까?
conn miller/miller
select ename from scott.emp;--=>error발생(table or view does not exist)

-->결론: WITH GRANT OPTION을 사용하여 객체 권한 취소
--  WITH GRANT OPTION을 사용하여 부여한 객체 권한을 취소하면 취소 작업이 연쇄적으로 수행 됩니다.
--------------------------------------------------------------------------------

# role생성 및 부여:conn system/Abcd1234만 가능
[1] 롤 생성
--create role 롤이름;
[2] 롤 관한부여
--grant 권한1,권한2,,to 롤이름;
[3] 롤을 사용자에게 부여
--grant 롤이름 to 사용자;

create role manager;
--manager롤에 create session, create table,create view, create synonym 
--권한을 부여하세요
grant create session, create table, create view, create synonym to manager;
--데이터사전에서 조회
--DBA_ROLES,DBA_SYS_PRIVS
select * from DBA_ROLES;
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='MANAGER';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='CONNECT';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='RESOURCE';

--MANAGER롤을 MILLER에게 부여하기
conn system/Abcd1234
grant manager to miller;
create view miller_view
as
select * from note;
--=> 생성 잘됨
select * from dba_sys_privs
where grantee=upper('dba');
