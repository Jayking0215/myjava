#�ý��� ���� �ο�
--WITH ADMIN OPTION�� �־� �ο��ϱ�
--system���� �����ؼ� �Ʒ� ���� ����
GRANT CREATE USER, ALTER USER, DROP USER TO MYSTAR
WITH ADMIN OPTION;

--mystar�� �����ؼ� �ٸ� user�� �����ϱ�_mystar�� �����ϱ�
conn mystar/mystar
show user

create user storm
identified by storm;
--strom�� �ٸ� user�� ������ ������ ���´�;with admin option����

--mystar�� storm user�� ��й�ȣ �����ϱ�
alter user storm
identified by tigher;

drop user storm;

--system���� �����ؼ� mystar�� ���� �� alter user, drop user���� ȸ���ϱ�
conn system/Abcd1234
show user

���� ȸ��
--REVOKE ����|�� FROM USER|��
revoke alter user, drop user from mystar;

--mystar�� �����ؼ� strom �ٽ� �����ϱ�
conn mystar/mystar
show user
create user storm
identified by storm;
--storm�� ����� tiger�� �����غ���
alter user storm
identified by tiger;--���� ���ܼ� �ȵ�
-->01031. 00000 -  "insufficient privileges" �����߻�
------------------------------------SQL�ǽ�05_���� �ó�����-------------------------
--=>dos�� ����
--1.
grant create table, create session to storm
with admin option;
--2.
conn storm/storm

create table note(
no number,
msg varchar2(30)
);
=> no privileges on tablespace 'SYSTEM' �����߻�(�Ҵ� �޸𸮸� �������� �ʾұ⶧��)
conn system/Abcd1234
alter user storm quota 2M on system;--�������� 2MB������ �޸𸮸� �Ҵ����ְڵ�
conn storm/storm--������ �� table����
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
conn storm/storm--storm�� admin�����̶� ���Ѻο� ����
grant create table to miller;--table space�� ���� ���� ��� �Ÿ� �Ҵ��ؾ���

conn system/Abd1234
alter user miller quota unlimited on system;--������ �Ҵ�
--4.
conn miller/miller
create table note(
no number);
--5.
conn system/Abcd1234
revoke create table from storm;

conn storm/storm
create table test(no number);
---=>insufficient privileges���� �߻�

--6.miller�� create table ������ ��� �Ǿ�����?
conn miller/miller
create table test(no number);--���� ����
select * from tab;--note, testȮ�� ����

--���:with admin option���� �־��� ������ storm���� ��Ҹ� �ص�
--miller�� create table������ ��ҵ��� �ʴ´�.
--------------------------------------------------------------------------------

#��ü�����̶�??
--d-sql��������-png�̹��� ����

--scott�� storm���� select, insert���� �ο�(�ɼǱ��Ѱ� �Բ�)
conn scott/tiger
grant select, insert on emp
to storm
with grant option;
--storm���� Ȯ��
conn storm/storm
select ename,job from scott.emp;
insert into scott.emp(empno,ename,job)
values(8100,'JAMES','MANAGER');
commit;

--storm�� scott.emp���̺��� select�ϴ� ������ miller���� �ο�
grant select on scott.emp to miller;
--miller�� Ȯ��
conn miller/miller
select ename,job from scott.emp;
--scott�� storm���� �ο��ߴ� select,insert on emp�� ���� ������ ȸ��
conn scott/tiger
revoke select, insert on emp from storm;
--Ȯ��
conn storm/storm
select ename from scott.emp;--=>error�߻�(table or view does not exist)
--miller�� ��� �Ǿ�����?
conn miller/miller
select ename from scott.emp;--=>error�߻�(table or view does not exist)

-->���: WITH GRANT OPTION�� ����Ͽ� ��ü ���� ���
--  WITH GRANT OPTION�� ����Ͽ� �ο��� ��ü ������ ����ϸ� ��� �۾��� ���������� ���� �˴ϴ�.
--------------------------------------------------------------------------------

# role���� �� �ο�:conn system/Abcd1234�� ����
[1] �� ����
--create role ���̸�;
[2] �� ���Ѻο�
--grant ����1,����2,,to ���̸�;
[3] ���� ����ڿ��� �ο�
--grant ���̸� to �����;

create role manager;
--manager�ѿ� create session, create table,create view, create synonym 
--������ �ο��ϼ���
grant create session, create table, create view, create synonym to manager;
--�����ͻ������� ��ȸ
--DBA_ROLES,DBA_SYS_PRIVS
select * from DBA_ROLES;
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='MANAGER';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='CONNECT';
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='RESOURCE';

--MANAGER���� MILLER���� �ο��ϱ�
conn system/Abcd1234
grant manager to miller;
create view miller_view
as
select * from note;
--=> ���� �ߵ�
select * from dba_sys_privs
where grantee=upper('dba');
