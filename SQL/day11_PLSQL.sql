��������
<1>scalar����:number, char, varchar2, boolean, date, long, binary_integer
<2>reference����:
    -%type:���̺��.�÷���%type
<3>composite����
    -�����ڷ���
<4>lob����
--------------------------------------------------------------------------------
--����� �� �Ķ���ͷ� �ѱ�� �ش� ����� ������ ������ ����ϴ� ���ν���
create or replace procedure emp_info
(pno in emp.empno%type)--..emp��empno�� ���� Ÿ������ �ְڴ�.(�ڷ����� �𸦶�)
is
--    vename varchar2(30); := 'nobody';--scalar����
    vename emp.ename%type;
    vjob emp.job%type;
    vsal emp.sal%type;
begin
--select �÷�1, �÷�2...
--into ����1, ����2...
--from ���̺��;
    select ename, job, sal
    into vename, vjob, vsal
    from emp
    where empno = pno;
    dbms_output.put_line('��  ��: '||pno); --���ν��� ��ɾ�=syso
    dbms_output.put_line('�����: '||vename);
    dbms_output.put_line('��  ��: '||vjob);
    dbms_output.put_line('��  ��: '||vsal);
end;
/
set serveroutput on--����1ȸ����
execute emp_info(7369);
exec emp_info(7788);
--------------------------------------------------------------------------------
--����� in parameter�� �ѱ�� ����� �̸��� �Ի���, �μ���ȣ,�μ����� �������� ���ν���
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
    dbms_output.put_line('�μ���ȣ  �μ���  �����  �Ի���');
    dbms_output.put_line('------------------------------');
    dbms_output.put_line(vemp.deptno||' '||vdname||' '||vemp.ename||' '||vemp.hiredate);
    dbms_output.put_line('------------------------------');
    --���� ó����
    exception 
        when no_data_found then 
            dbms_output.put_line(pno||'�� ����� �������� �ʾƿ�');
        when others then
            dbms_output.put)line('��Ÿ �ַ� �߻�');
end;
/
select empno from emp;
exec emp_rowtype(7521);
exec emp_rowtype(7499);
exec emp_rowtype(8499);
--------------------------------------------------------------------------------
--���ν��� �ҽ� Ȯ��
select * from user_source;
select text from user_source
where name='EMP_ROWTYPE';
--------------------------------------------------------------------------------
# composite type(���� ������ Ÿ��)
-tableŸ�� ==> �ڹ��� �迭�� ����
-recordŸ�� ==> �ڹ��� class�� ����
--------------------------------------------------------------------------------
#tableŸ��
--�μ���ȣ�� in parameter�� �ѱ�� �ش� �μ��� �Ҽӵ� ����� �̸��� ������ �������� ���ν���
CREATE OR REPLACE PROCEDURE TABLE_TYPE
(PDNO IN DEPT.DEPTNO%TYPE)
IS
-- ���̺� ����
-- ENAME���� ������ TABLE ���� ����
TYPE ENAME_TABLE IS TABLE OF EMP.ENAME%TYPE
INDEX BY BINARY_INTEGER;
-- JOB����  ������ TABLE ���� ����
type job_table is table of emp.job%type
index by binary_integer;
-- ���̺� Ÿ���� ���� ����
ENAME_ARR ENAME_TABLE;--������ Ÿ��
job_arr job_table;
-- �ε����� ����� ���� ����
I BINARY_INTEGER :=0;
BEGIN
   -- �ݺ��� ���鼭 EMP���� �����͸� �����ͼ� ENAME_ARR�� �����Ѵ�
   FOR K IN (SELECT ENAME,JOB FROM EMP WHERE DEPTNO=PDNO) LOOP
       I := I+1;
       ENAME_ARR(I) := K.ENAME;
       -- JOB�� ����      
       job_arr(i) := k.job;
   END LOOP;
   
   -- ���̺� Ÿ�� ������ ����� �� ����ϱ�
   DBMS_OUTPUT.PUT_LINE('------'||PDNO||'�� �μ�--------');
   FOR J IN 1 .. I LOOP -- 1���� I������ 1�������ϸ鼭 �ݺ����� �����Ѵ�
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
--������� in parameter�� �����ϸ� �ش� ��� ������ ����ϴ� ���ν���
-- ���,����,�޿�
create or replace procedure record_type
(pname in emp.ename%type)
is
--recordŸ�� ����
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
--record Ÿ���� ���� ����
emp_rec emp_record;
begin
select * into emp_rec from emp
where ename=upper(pname);
--����ϱ�
 dbms_output.put_line('---'||pname||'�� ����---');
 dbms_output.put_line('��� : '||emp_rec.vno);
 dbms_output.put_line('�̸� : '||emp_rec.vname);
 dbms_output.put_line('���� : '||emp_rec.vjob);
 dbms_output.put_line('�޿� : '||emp_rec.vsal);
--����ó��
exception 
when no_data_found then
    dbms_output.put_line(pname||'����� �����');
end;
/
exec record_type('king');
exec record_type('queen');
--------------------------------------------------------------------------------
#bind ���� --�������� ���� ����
--variable ������ �ڷ���

variable myvar number
declare
begin
    --bind������ ������ ���� �տ� �ݷ�(:)�� ���ξ�� ���δ�
    :myvar := 500;
end;
/
print myvar
--------------------------------------------------------------------------------
# procedure �Ķ���� ����
[1] in parameter : default
[2] out parameter
[3] on out parameter
--------------------------------------------------------------------------------
--in parameter ����
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
--out parameter ����
--���ν����� ȣ���ڿ��� �Ѱ��ִ� ��
--default�� ���� �Ұ�

--����� �� �Ķ���ͷ� �ѱ�� �ش� ����� �̸��� �ƿ� �Ķ���ͷ� �������� ���ν���
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
--out parameter�� �޾��� bind���� ����
var fname varchar2(30);
execute ename_find(7499,:fname);
print fname;
--------------------------------------------------------------------------------
--in out parameter : in�� �ϰ� out�� �ϴ� �Ķ����
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
    dbms_output.put_line('���ν��� ���� ��');
    dbms_output.put_line('-----------------');
    dbms_output.put_line('a1: '||to_char(a1,'999,999'));--in
    dbms_output.put_line('a2: '||a2);--in
    dbms_output.put_line('a3: '||a3);--in out
    dbms_output.put_line('a4: '||a4);--out
    
    a3 := '���ν��� �ۿ��� �̰��� ���� �� ������?';
    msg:= '�翬����!!';
    a4 := msg;--out�Ķ���� a4�� msg�ֱ�
    
    dbms_output.put_line('----------------');
    dbms_output.put_line('���ν��� ���� ��');
    dbms_output.put_line('-----------------');
    dbms_output.put_line('a1: '||to_char(a1,'999,999'));--in
    dbms_output.put_line('a2: '||a2);--in
    dbms_output.put_line('a3: '||a3);--in out
    dbms_output.put_line('a4: '||a4);--out
end;
/
var c varchar2(100);--��������(bind) ����
var d varchar2(100);
execute inout_test(750000,'Hello',:c,:d);
print c;
print d;
--------------------------------------------------------------------------------
# select���� �����ϴ� ���ν���...(select���� �������̸� ��Ÿ��error�߻�)
--�� �Ķ���ͷ� job�� �ѱ��
--�ش� ������ �����ϴ� ��������� �������� ���ν���
-- ���ν�����: emp_job_info
-- ��������� ���� ����: %rowtype
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
    dbms_output.put_line('�̸�: '||vemp.ename);
end;
/
exec emp_job_info('manager');
--ORA-01422: exact fetch returns more than requested number of rows
--������� �������� ��ȯ�� ���� Ŀ���� �̿��ؾ� �Ѵ�.
----------------------------error ����-Ŀ�� ���---------------------------------
create or replace procedure emp_job_info
(
pjob in emp.job%type
)
is
vemp emp%rowtype;
--Ŀ�� ����
cursor emp_cr is
select * from emp where job=upper(pjob);--Ŀ���� �����ϴ� ����
begin
    --Ŀ�� ����(open)
    open emp_cr;
    --�ݺ��� ���鼭 ������ ����(fetch)
     dbms_output.put_line('----'||upper(pjob)||'----');
    loop
    --������ ����
    fetch emp_cr into vemp;
    exit when emp_cr%notfound;--���̻� ���ڵ� �߰� �ȵǸ� �����
    dbms_output.put_line(rpad(vemp.ename,14,' ')||vemp.sal);
    
    end loop;
    --Ŀ�� �ݱ�(close)
    close emp_cr;
    dbms_output.put_line('�̸�: '||vemp.ename);
end;
/
exec emp_job_info('manager');
exec emp_job_info('salesman');
--------------------------------------------------------------------------------
--�μ���ȣ�� in �Ķ���ͷ� �����ϸ�
--�ش� �μ��� ��������� out�Ķ���ͷ� �������� ���ν��� �ۼ��ؼ�
--java�� �����غ��ô�
--�̸�, ����, �μ���, �ٹ���, �Ի���
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
    --subquery�� ����
    open mycr 
    select ename,job,dname,loc,hiredate from
    (select * from emp where deptno=pdno) a join dept d
    on a.deptno=d.deptno;
end;
/
--------------------------------------------------------------------------------
--//�˻�� �Է��ϸ� �ش� �˻�� ���� �޸���� �������� ���ν��� �ۼ��ϰ�
--//�ڹٿ� ������Ű����
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