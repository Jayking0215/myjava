#���
if��
if ���ǽ� then ���๮
elsif ���ǽ� then ���๮
else
    ���๮
end if;--�ڹ��� �߰�ȣ ���� ����
--------------------------------------------------------------------------------
--����� in �Ķ���ͷ� �ѱ�� �ش� ����� �μ���ȣ,�����,�μ����� ����ϴ� ���ν���(�� �μ����� �ѱ۷�)
--10���μ�'ȸ��μ�', 20'�����μ�', 30'�����μ�' 40'��μ�'
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
    if vdno=10 then vdname :='ȸ��μ�';
    elsif vdno=20 then vdname :='�����μ�';
    elsif vdno=30 then vdname :='�����μ�';
    else
        vdname:='��μ�';
    end if;
    dbms_output.put_line(pno||'�� '||vname||'���� '||vdno||'�� �μ� ['||vdname||']�� �־��');    
end;
/
set serveroutput on
select empno from emp
exec dept_search(7369);
exec dept_search(7521);


[�ǽ�]
--IF~END IF ������ SCOTT�� ������ ����ϼ���.
--COMM�� ���� ���� ���� �ƴ� ��츦 ������ ����Ͽ� ����ϼ���
--IF~END IF ������ ���Ķ���ͷ� ������� �޾� �ش� ����� ������ ����ϼ���.
--COMM�� ���� ���� ���� �ƴ� ��츦 ������ ����Ͽ� ����ϼ���
create or replace procedure emp_sal
(pname in varchar2)
is
vsal emp.sal%type;
vcomm emp.comm%type;
vtotal number;
begin
    select sal,comm--��
    into vsal,vcomm--�� �ִ´�
    from emp where ename=upper(pname);
    if vcomm is null then vtotal:=vsal*12; --null�� �񱳴� is���
    else vtotal:=vsal*12+vcomm;
    end if;
    dbms_output.put_line(pname||'���� ������ '||to_char(vtotal,'$999,999')||'�Դϴ�');
    dbms_output.put_line('�� �޿�: '||vsal||', ���ʽ�: '||vcomm);  
    exception
    when no_data_found then 
        dbms_output.put_line(pname||'���� �����ϴ�');
    when too_many_rows then
        dbms_output.put_line(pname||'���� �����Ͱ� 2�� �̻��Դϴ�.');
end;
/
exec emp_sal('smith');
exec emp_sal('smooth');
exec emp_sal('james');
--------------------------------------------------------------------------------
#�ݺ���
--- for loop
--- loop
--- while loop

--[1]for loop��
--for ���� in ���۰� .. ���� loop --�������ϰ� ������� ���۰� �տ� [reverse]�ִ´�(=���ҽ�)
--    ���๮
--end loop;

--for loop�� �̿��ϸ� cursor�� open, fetch, close�ϴ� ������ �ʿ����.(�ڵ����� ��)
declare --�͸� ���ν���
begin
    for i in reverse 10 .. 20 loop
        dbms_output.put_line('Hello '||i);
    end loop;
end;
/

declare
begin
    for k in (select * from member where job='�л�') loop
    --k�� record type�� ����
        dbms_output.put_line(k.name||': '||k.job||' '||k.userid);
    end loop;
end;
/
--------------------------------------------------------------------------------
--[2]loop��
--loop
--    exit when ���ǹ�;
--    ���๮;
--end loop;

--emp���̺� ��������� ����ϵ� �ݺ��� �̿��ؼ� ���9000������ 10�� �������Ѽ� �ֱ�
--����� 'JAMES'
--�Ի��� sysdate
-- 9090���� �Ǹ� �ݺ��� ��Ż
declare
vno number(4):= 9000;
begin
    loop
        insert into emp(empno,ename,hiredate)
        values(vno,upper('james'),sysdate);
        vno := vno+10;
        exit when vno>=9090; --������ ����loop ����.
    end loop;
    dbms_output.put_line('������ ���� ����'||(vno-9000)/10||'���� ������ �Է�');
end;
/

select * from emp order by 1 desc;
rollback;
--------------------------------------------------------------------------------
--[3]while loop��
--while ���ǹ� loop
--    ���๶
--    ���� ������;
--end loop;

declare
    cnt number(4):=1000;
begin
    while cnt<1005 loop
        insert into emp(empno,ename,hiredate)
        values(cnt,'james'||cnt,sysdate);
        cnt:=cnt+1;
    end loop;
    dbms_output.put_line(cnt-1000||'���� ������ �Է� �Ϸ�');
end;
/

select * from emp order by 1 asc;
rollback;
--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
#�Ͻ��� Ŀ��
--��� dml����� select������ �Ͻ��� cursor�� �����Ѵ�.
--�����ڰ� ���� open,fetch,close�� �� ������ �Ӽ��� �̿��ؼ� ���� Ȱ�� ����

����� in �Ķ���ͷ� �ѱ�� �ش� ����� �޿��� 10% �λ��Ű�� ���ν���
create or replace procedure IMPLICIT_CURSOR
(pno in emp.empno%type)
is
    vsal emp.sal%type;
    vrow number;
begin
    select sal
    into vsal
    from emp where empno=pno;
    --�����Ͱ� �߰ߵ� ����� �޿��� 10%�λ�
    if sql%found then
        dbms_output.put_line('�˻��� �����Ͱ� �־��: �޿�=>'||vsal);
    end if;
    
    update emp set sal=sal*1.1 where empno=pno;
    --������ ������ ���� vrow�� ����
    vrow := sql%rowcount;
    dbms_output.put_line('�޿��� �λ�� ��� ��: '||vrow);
    
    select sal
    into vsal
    from emp where empno=pno;
    --�����Ͱ� �߰ߵ� ����� �޿��� 10%�λ�
    if sql%found then
        dbms_output.put_line('10% �޿� �λ� ��: �޿�=>'||vsal);
    end if;
end;
/
exec implicit_cursor(7788);
select * from emp;
rollback;
--------------------------------------------------------------------------------
���� ���� �����͸� select�ϴ� ���忡�� ������ cursor�� ����ϸ� too_many_rows���� �߻�
==>����� cursor ��� ����

create or replace procedure dept_all
is--���������
vno number;
vname varchar2(30);
vloc varchar2(30);
begin--�����
    select deptno,dname,loc
    into vno,vname,vloc
    from dept;
end;
/
exec dept_all;--�����߻�
----->����� cursor�� ���� �ذ�
--���𹮿���
--cursor Ŀ���� is select��;
--open Ŀ����
--�ݺ��� �̿��ؼ� fetch�ؾ���
--close Ŀ����;
create or replace procedure dept_all
is
vno number;
vname varchar2(30);
vloc varchar2(30);
--cursor ����
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

--[�ǽ�]
--�μ��� �ش� �μ��� �μ���ȣ, �μ���� �����, ��ձ޿��� ������ ����ϴ�
--���ν����� �ۼ��ϼ���
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
        dbms_output.put_line('�μ���ȣ      �μ���        �����      ��ձ޿�');
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
#for �������� Ŀ�� ���
create or replace procedure forcur
is--Ŀ�� ����
cursor pcr is
select products_name, output_price
from products order by 1;
begin
--for�������� Ŀ�����(open,fetch,close�� �˾Ƽ� ��)
    for p in pcr loop--p������ record Ÿ��
        dbms_output.put_line(rpad(p.products_name,14,' ')||to_char(p.output_price,'L999,999,999'));
    end loop;
end;
/
exec forcur;

#for �������� �������� ���
--Ŀ���� ������ �ʿ䰡 ����
--for ���� in (subquery) loop
--  ���๮
--end loop;
declare
begin
    for k in (select * from category order by 3 asc) loop
        dbms_output.put_line(k.category_code||lpad(k.category_name,16,' '));
    end loop;
end;
/
--------------------------------------------------------------------------------
#����ó��
--�̸� ���ǵ� ����ó��
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
        DBMS_OUTPUT.PUT_LINE('���: '||K.EMPNO);
        DBMS_OUTPUT.PUT_LINE('�̸�: '||K.ENAME);
        DBMS_OUTPUT.PUT_LINE('�μ���ȣ: '||K.DEPTNO);    
    END LOOP;
    
    EXCEPTION
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�����Ͱ� 2�� �̻��̿���. Ŀ���� �̿��ϼ���');
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE(VENO||'�� ����� �̹� �ֽ��ϴ�');
    when others then
        dbms_output.put_line('��Ÿ ���� �߻�: '||SQLERRM||' '||SQLCODE);
END;
/
exec except_test(10,1000,'peter');--�����߻�
exec except_test(10,1001,'susan');
rollback;
alter table emp add constraint emp_empno_uk unique(empno);--uk��� �߰�����
--------------------------------------------------------------------------------
#����� ���� ����ó��
--job���� ������� 4���� ������ ����� ���� ���ܸ� �߻���Ų��
--in�Ķ���ͷ� job�� �޾Ƽ� �ο��� 4�� �̸��̸� ���� �߻�
create or replace procedure user_except 
(pjob in emp.job%type)
is
--����� ���� ���� ����[1]
--�����̸� exception
    user_define_error exception;
    vcnt number;
begin
--raise���� �̿��� ���ܸ� �߻�[2]
    select count(empno) 
    into vcnt
    from emp
    where job=upper(pjob);
    if vcnt<4 then 
        raise user_define_error;
    end if;
    dbms_output.put_line(pjob||'��� ���� '||vcnt||'���Դϴ�');
exception
    --����ó�� �ܰ� raise_application_error()�Լ� Ȱ��[3]
    when user_define_error then
        raise_application_error(-20001,pjob||'������ ����� �ʹ� �����. �ο��� �÷��ּ���');
end;
/
exec user_except('analist');
exec user_except('clerk');

