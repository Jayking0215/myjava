--#Function
--����� in parameter�� �ѱ�� �ش� ����� �μ����� ��ȯ�ϴ� �Լ�
create or replace function getDname
(pname in emp.ename%type)
return varchar2--��ȯŸ�� ����
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
    
    return vdname;--���� ��ȯ
    
    exception
    when no_data_found then
        dbms_output.put_line(pname||'����� �����ϴ�.');
        return SQLERRM;
    when to_many_rows then
        dbms_output.put_line(pname||'��� �����Ͱ� 2�� �̻��Դϴ�');
        return SQLERRM;
    when others then
        return SQLERRM;
end;
/
var gname varchar2;
exec :gname := getDname('james');
print gname

--�Լ��� ��ȯ���� �ޱ� ���� ���ε� ���� ����
var gname varchar2;
set serverout on
exec :gname := getDname('king');
print gname
--------------------------------------------------------------------------------
#��Ű��
--�������� ���ν���, �Լ�, Ŀ�� ���� �ϳ��� ��Ű���� ���� ������ �� �ִ�.
--[1]��Ű�� �����
--[2]��Ű�� ����(package body)
--------------------------------------------------------------------------------
--[1] ��Ű�� �����
create or replace package empInfo as
procedure allEmp;
procedure allSal;
end empInfo;
/
--[2] ��Ű�� ���� ����
create or replace package body empInfo as
    -- allEmp : ��� ����� ���,�̸�,�Ի��� ������ ����ϴ� ���ν���
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
                dbms_output.put_line(SQLERRM||'���� �߻�');
    end allEmp;
    -- allSal : ��ü ����� �޿��հ�,�����,��ձ޿�,�ִ�޿�,�ּұ޿�
procedure allSal
is
begin
    dbms_output.put_line('�޿�����'||lpad('�����',10,' ')||lpad('��ձ޿�',10,' ')||lpad('�ִ�޿�',10,' ')||lpad('�ּұ޿�',10,' '));
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
--insert,update,delete���� ����� �� ���������� ����Ǵ� ������ ���ν���

--�μ����� ������ �� ���� �μ���� ����� �μ����� ������� ����� Ʈ����
create or replace trigger trg_dept
before update on dept
for each row
declare
    MSG varchar2(20);
begin
    MSG:='hi trigger';
    dbms_output.put_line(MSG);
    dbms_output.put_line('���� �� �÷���: '||:old.dname);
    dbms_output.put_line('���� �� �÷���: '||:new.dname);
end;
/
select * from dept;
update dept set dname='��μ�' where deptno=40;--��¹����� ����ΰ� ���� ����ȴ�.
rollback;
--trigger ��Ȱ��ȭ
--alter trigger Ʈ���Ÿ� disable;
--trigger Ȱ��ȭ
--alter trigger Ʈ���Ÿ� enable;

--trg_dept�� ��Ȱ��ȭ�ϰ� update���� ����
alter trigger trg_dept disable;
update dept set dname='��μ�' where deptno=40;
alter trigger trg_dept enable;
rollback;

--�����ͻ������� ��ȸ
--user_triggers
select * from user_triggers where trigger_name='trg_dept';

--trigger ����
--drop trigger Ʈ���Ÿ�;
drop trigger trg_dept;

--EMP ���̺� �����Ͱ� INSERT�ǰų� UPDATE�� ��� (BEFORE)
--��ü ������� ��ձ޿��� ����ϴ� Ʈ���Ÿ� �ۼ��ϼ���.
--�׽�Ʈ�Ҷ��� ��ü ����� �޿��� 10% �λ��Ű����.
--���Ի������ ���(���, �����, �μ���ȣ, �޿�)
create or replace trigger trg_emp_avg
before insert or update on emp
--for each row--�����ϸ� ����Ʈ����
declare
    avg_sal number(10);
begin
    select avg(sal) into avg_sal from emp;
    dbms_output.put_line('��� �޿�: '||avg_sal);
end;
/
select * from user_triggers;
insert into emp(empno,ename,deptno,sal)
values(9003,'TOM',20,4000);
select avg(sal) from emp;
update emp set sal=sal*1.1;
rollback;
--------------------------------------------------------------------------------
--[Ʈ���� �ǽ� 1] �� Ʈ����
--�԰� ���̺� ��ǰ�� �԰�� ���
--��ǰ ���̺� ��ǰ ���������� �ڵ����� ����Ǵ� 
--Ʈ���Ÿ� �ۼ��غ��ô�.
��ǰ���̺� : MYPRODUCT
�԰����̺� : MYINPUT
--���̺� ����
create table myproduct(
    pcode char(6) primary key,
    pname varchar2(20) not null,
    pcompany varchar2(20),
    price number(8),
    pqty number(8) default 0
);
--Ȯ��
desc myproduct;
--������ ����(1�� �����ϴ�)
create sequence myproduct_seq
start with 1
increment by 1
nocache;

insert into myproduct
values('A00'||myproduct_seq.nextval,'��Ʈ��','A��',800000,10);

insert into myproduct
values('A00'||myproduct_seq.nextval,'TV','B��',1000000,20);

insert into myproduct
values('A00'||myproduct_seq.nextval,'ű����','C��',70000,30);

select * from myproduct;
commit;

--�԰� ���̺�
create table myinput(
    incode number primary key,--�԰��ȣ
    pcode_fk char(6) references myproduct(pcode),--�԰� ��ǰ�ڵ�
    indate date default sysdate,
    inqty number(6),--�԰� ����
    inprice number(8)--�԰� ����
);
desc myinput;

create sequence myinput_seq nocache;

--�԰� ���̺� ��ǰ�� �԰�Ǹ� ��ǰ ���̺��� ��������(pqty)�� �����ϴ� Ʈ���� �ۼ�
create or replace trigger trg_input_product
after insert on myinput
for each row
declare
begin
    update myproduct set pqty=pqty+:new.inqty
    where pcode=:new.pcode_fk;
    dbms_output.put_line(:new.pcode_fk||'�� ��ǰ�� �߰��� '||:new.inqty||'�� ����');
end;
/

select * from myproduct;
--A001��ǰ�� �߰��� 15�� ����
insert into myinput(incode,pcode_fk,inqty,inprice)
values(myinput_seq.nextval,'A001',15,500000);

--A002 �߰��� 8�� ����
insert into myinput
values(myinput_seq.nextval,'A002',sysdate,8,700000);
--------------------------------------------------------------------------------
--[�ǽ�1] �԰����̺��� ������ ����� ��� (update���� ����ɶ�)
--��ǰ ���̺��� ������ �����ϴ� Ʈ���� �ۼ�
--:old.inqty�����ϰ� :new.inqty���ϴ�
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

--[�ǽ�2] �԰� ���̺� �����Ͱ� ������ ���(DELETE���� ����� ��)
--��ǰ ���̺��� ������ �����ϴ� Ʈ���Ÿ� �ۼ��ϼ���
-- :OLD.INQTY�� ������
create or replace trigger trg_input_product3
after delete on myinput
for each row
declare
begin
    update myproduct set pqty=pqty-:old.inqty
    where pcode=:old.pcode_fk;
    dbms_output.put_line('old: '||:old.inqty||'������ �����Ǿ���');
end;
/
select * from myproduct;
select * from myinput;
delete from myinput where incode=3;
commit;
--------------------------------------------------------------------------------
--[Ʈ���� �ǽ�2] - ���� Ʈ���� : Ʈ���� �̺�Ʈ�� ���� �� �ѹ��� ������.
--EMP ���̺� ���Ի���� ������(INSERT) �α� ����� ������
--� DML������ �����ߴ���, DML�� ����� ������ �ð�, USER �����͸�
--EMP_LOG���̺� �������.
create table emp_log(
    log_code number primary key,
    user_id varchar2(30),
    log_date date default sysdate,
    behavior varchar2(20)
);
--seq����(��ȣ ���������ִ� ����)
create sequence emp_log_seq nocache;
--select to_char(sysdate,'day') from dual;--�ý����� ��������
create or replace trigger trg_emp_log
before insert on emp
declare
begin
    if to_char(sysdate,'dy') in ('��','��','��') then
        raise_application_error(-20001,'��,��,�Ͽ��Ͽ��� �Է���� �Ұ�');--����� ���� ���� 20001~20999(?)
    else
        insert into emp_log(log_code,user_id,log_date,behavior)
        values(emp_log_seq.nextval,user,sysdate,'insert');
    end if;
end;
/
--emp�� ���,�����,�μ���ȣ,�Ի����� ���� insert�ϱ�
insert into emp(empno,ename,deptno,hiredate)
values(9032,'TOMAS',30,sysdate);

select * from emp_log;
