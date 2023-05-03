[����]
	
--1] ������̺��� �޿��� 3000�̻��� ����� ������ ��� ����ϼ���.
select * 
from emp 
where sal>=3000;

--2] ������̺��� ����� 7788�� ����� �̸��� �μ���ȣ�� ����ϼ���
select ename,deptno
from emp
where empno = 7788;

--3] ������̺��̼� �Ի����� 1981 2��20�� ~ 1981 5��1�� ���̿�
-- �Ի��� ����� �̸�,���� �Ի����� ����ϵ�, �Ի��� ������ ����ϼ���.
select ename,job,hiredate
from emp
where hiredate between '1981-02-20' and '1981-05-01'
order by hiredate asc;--order by 3;

--4] ������̺��� �μ���ȣ�� 10,20�� ����� �̸�,�μ���ȣ,������ ����ϵ�
--�̸� ������ �����Ͻÿ�.
select ename,deptno,job
from emp where deptno in (10,20)
order by ename asc;

--5] ������̺��� 1982�⿡ �Ի��� ����� ��� ������ ����ϼ���.
select *
from emp
where hiredate like '1982%';

--6] ������̺��� ���ʽ��� �޿����� 10%�� ���� ����� �̸�,�޿�,���ʽ��� ����ϼ���.
select ename,sal,comm
from emp
where (sal*1.1<=comm);

--7] ������̺��� ������ CLERK�̰ų� ANALYST�̰�
--�޿��� 1000,3000,5000�� �ƴ� ��� ����� ������ ����ϼ���.
select *
from emp
where job in ('CLERK','ANALYST') and sal not in (1000,3000,5000);

--8] ������̺��� �̸��� L�� ���ڰ� �ְ� �μ��� 30�̰ų�
--�Ǵ� �����ڰ� 7782���� ����� ������ ����ϼ���.
select *
from emp
where ename like '%LL%' and deptno=30 or mgr=7782;
--������ �켱���� AND>OR

--9] EMP���̺��� �޿��� 1000�̻� 1500���ϰ� �ƴ� ����� ������ �����ּ���
select *
from emp
where sal not between 1000 and 1500;

--10] EMP���̺��� �̸��� 'S'�ڰ� ���� ���� ����� �̸��� ��� ����ϼ���.
select ename
from emp  
where ename not like '%S%';

--11] ������̺��� ������ PRESIDENT�̰� �޿��� 1500�̻��̰ų�
--������ SALESMAN�� ����� ���,�̸�,����,�޿��� ����ϼ���.
select empno,ename,job,sal
from emp
where job='PRESIDENT' and (sal>=1500 or job='SALESMAN');

--12] �� ���̺��� �̸��� ȫ�浿�̸鼭 ������ �л��� ������ ��� �����ּ���.
select *
from member
where name='ȫ�浿' and job='�л�';

--13] �� ���̺��� �̸��� ȫ�浿�̰ų� ������ �л��� ������ ��� �����ּ���.
select *
from member
where name='ȫ�浿' or job='�л�';

--14] ��ǰ ���̺��� �����簡 S�� �Ǵ� D���̸鼭 
--�ǸŰ��� 100���� �̸��� ��ǰ ����� �����ּ���.
select *
from products
where (company='�Ｚ' or company='���') and output_price<1000000;

--15] ��ǰ ���̺��� ��ۺ��� ������������ �����ϵ�, 
--���� ��ۺ� �ִ� ��쿡�� ���ϸ����� ������������ �����Ͽ� �����ּ���.
select *
from products
order by trans_cost DESC, mileage DESC;

--16] DEPT���̺��� �÷��� ù ���ڵ鸸 �빮�ڷ� ��ȯ�Ͽ� ��� �μ������� ����϶�.
select deptno, initcap(DNAME),initcap(LOC)
from dept;

--17] ��ǰ ���̺��� �ǸŰ��� ȭ�鿡 ������ �� �ݾ��� ������ �Բ� �ٿ��� ����ϼ���.
select products_name, concat(output_price,'��')price
from products;

--18] �����̺��� �� �̸��� ���̸� �ϳ��� �÷����� ����� ������� ȭ�鿡 �����ּ���.
select concat(name,age)
from member;