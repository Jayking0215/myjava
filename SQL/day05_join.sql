# TABLE JOIN
--dept�� EMP�� JOIN�Ѵ�
--������
SELECT DEPT.DEPTNO, DNAME, EMP.ENAME, JOB, EMP.DEPTNO--Į���� �ߺ����� ������ ���̺� ��������
FROM DEPT, EMP
WHERE DEPT.DEPTNO = EMP.DEPTNO ORDER BY 1;--DEPT�� �μ���ȣ�� EMP�� �μ���ȣ�� ������
--�����JOIN��=>ǥ��
SELECT D.DEPTNO, DNAME, E.*, LOC
FROM DEPT D JOIN EMP E
ON D.DEPTNO = E.DEPTNO ORDER BY 1;

[1]EQUI JOIN=INNER JOIN, NATURAL JOIN
    PK�� FK�� EQUAL(=)�����ڸ� �̿��ؼ� JOIN�ϴ� ���
--��1]SALESEMAN�� �����ȣ, �̸�,�޿�,�μ���,�ٹ����� ����Ͽ���
SELECT EMPNO, ENAME, SAL, DNAME, LOC
FROM EMP E,DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.JOB='SALESMAN';
--�����JOIN
SELECT EMPNO, ENAME, SAL, DNAME, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO AND E.JOB='SALESMAN';

--��2]CATEGORY�� PRODUCTS�� JOIN�ؼ� ī�װ��ڵ�, ī�װ���, ��ǰ��, �ǸŰ�, �����縦 ���
SELECT CATEGORY_CODE, CATEGORY_NAME, PRODUCTS_NAME, OUTPUT_PRICE, COMPANY
FROM CATEGORY C JOIN PRODUCTS P
ON C.CATEGORY_CODE = P.CATEGORY_FK;
--ī�װ� ���̺�� ��ǰ ���̺��� �����Ͽ� ȭ�鿡 ����ϵ� ��ǰ�� ���� ��
--������ü�� �Ｚ�� ��ǰ�� ������ �����Ͽ� ī�װ� �̸��� ��ǰ�̸�, ��ǰ����
--������ ���� ������ ȭ�鿡 �����ּ���.
SELECT CATEGORY_NAME, PRODUCTS_NAME, OUTPUT_PRICE, COMPANY
FROM CATEGORY C JOIN PRODUCTS P
ON C.CATEGORY_CODE = P.CATEGORY_FK
WHERE COMPANY='�Ｚ';
--�� ��ǰ���� ī�װ� �� ��ǰ��, ������ ����ϼ���. �� ī�װ��� 'TV'�� ���� 
--�����ϰ� ������ ������ ��ǰ�� ������ ������ ������ �����ϼ���.
SELECT CATEGORY_CODE, CATEGORY_NAME, PRODUCTS_NAME, OUTPUT_PRICE, COMPANY
FROM CATEGORY C JOIN PRODUCTS P
ON C.CATEGORY_CODE = P.CATEGORY_FK
WHERE CATEGORY_NAME <> 'TV'
ORDER BY OUTPUT_PRICE ASC;

[2]NON-EQUI JOIN
--EQUAL(=)�� �ƴ� �����ڸ� �̿��ؼ� JOIN�ϴ� ���
SELECT * FROM SALGRADE;
--��1]������� ������ �����ֵ� �޿� ��� ������ �����ּ���
SELECT S.GRADE, ENAME, SAL, LOSAL, HISAL, DEPTNO
FROM EMP E JOIN SALGRADE S
ON E.SAL BETWEEN S.LOSAL AND S.HISAL AND DEPTNO=20;

[3]OUTER JOIN
--������
SELECT D.DEPTNO, D.DNAME, EMPNO, ENAME, JOB , LOC
FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO(+) ORDER BY 1;--NULL���� ����� ���̺� �� �÷��� (+)�� ���δ�.
--����� JOIN��
--LEFT OUTER JOIN:���ʿ� ��ġ�� ���̺��� �������� �����͸� �����ְ��� �Ҷ�
SELECT D.*, ENAME, JOB
FROM DEPT D LEFT OUTER JOIN EMP E
ON D.DEPTNO = E.DEPTNO ORDER BY 1;
--RIGHT OUTER JOIN:�����ʿ� ��ġ�� ���̺��� �������� �����͸� �����ְ��� �Ҷ�
SELECT D.*, ENAME, JOB
FROM DEPT D RIGHT OUTER JOIN EMP E
ON D.DEPTNO = E.DEPTNO ORDER BY 1;
--FULL OUTER JOIN:���ʿ� ��ġ�� ���̺��� �������� �����͸� �����ְ��� �Ҷ�
SELECT D.*, ENAME, JOB
FROM DEPT D FULL OUTER JOIN EMP E
ON D.DEPTNO = E.DEPTNO ORDER BY 1;

--����1] ��ǰ���̺��� ��� ��ǰ�� ���޾�ü, ���޾�ü�ڵ�, ��ǰ�̸�, 
--��ǰ���ް�, ��ǰ �ǸŰ� ������ ����ϵ� ���޾�ü�� ����
--��ǰ�� ����ϼ���(��ǰ�� ��������)
--������
SELECT S.*, PRODUCTS_NAME, INPUT_PRICE, OUTPUT_PRICE
FROM SUPPLY_COMP S, PRODUCTS P
WHERE S.EP_CODE(+) = P.EP_CODE_FK;
--����� JOIN
SELCT S.EP_NAME, EP_CODE, P.PRODUCTS_NAME, P.INPUT_PRICE ,P.OUTPUT_PRICE
FROM PRODUCTS P LEFT OUTER JOIN SUPPLY_COMP S
ON S.EP_CODE = P.EP_CODE_FK;--�ٽ�

SELCT S.*, PRODUCTS_NAME, INPUT_PRICE ,OUTPUT_PRICE
FROM SUPPLY_COMP S FULL OUTER JOIN PRODUCTS P
ON S.EP_CODE = P.EP_CODE_FK;--�ٽ�

--����2] ��ǰ���̺��� ��� ��ǰ�� ���޾�ü, ī�װ���, ��ǰ��, ��ǰ�ǸŰ� ������ ����ϼ���. 
--��, ���޾�ü�� ��ǰ ī�װ��� ���� ��ǰ�� ����մϴ�.
SELECT EP_CODE, EP_NAME, CATEGORY_NAME, PRODUCTS_NAME, OUTPUT_PRICE
FROM SUPPLY_COMP S RIGHT OUTER JOIN PRODUCTS P
ON S.EP_CODE = P.EP_CODE_FK
LEFT OUTER JOIN CATEGORY C
ON P.CATEGORY_FK = C.CATEGORY_CODE ORDER BY 1, CATEGORY_CODE;

[4] SELF JOIN:�ڱ� ���̺�� JOIN�ϴ� ���
SELECT E.EMPNO, E.ENAME, E.MGR, M.EMPNO, M.ENAME "�������̸�"
FROM EMP E JOIN EMP M
ON E.MGR = M.EMPNO ORDER BY 1;

--��1]emp���̺��� "������ �����ڴ� �����̴�"�� ������ ����ϼ���.
SELECT E.ENAME||'�� �����ڴ�' ||M.ENAME||'�Դϴ�'
FROM EMP E JOIN EMP M
ON E.MGR=M.EMPNO ORDER BY 1;

# CARTESIAN PRODUCTS- CROSS JOIN
--JOIN������ �߸��ǰų� ������ ���, ������ ����� ��� �����Ͽ� ������
--=>�������� ���� ������
SELECT D.*, E.*
FROM DEPT D, EMP E ORDER BY D.DEPTNO ASC;--(...40�� �μ����� ������ ������ ���յǾ� ��µ�)

# ������/������/������ ==> SET OPERATOR
-UNION*(������)
-UNION ALL(������)
-INTERSECT(������)
-MINUS(������)
--������_UNION
SELECT DEPTNO FROM DEPT
UNION
SELECT DEPTNO FROM EMP;
--������_UNION ALL
SELECT DEPTNO FROM DEPT
UNION ALL--�ߺ��Ǿ �� �����
SELECT DEPTNO FROM EMP;
--������ INTERSECT
SELECT DEPTNO FROM DEPT
INTERSECT
SELECT DEPTNO FROM EMP;
--������ MINUS
SELECT DEPTNO FROM DEPT
MINUS
SELECT DEPTNO FROM EMP;

--��1]emp���̺��� ��� ����� ���� �̸�,�μ���ȣ,�μ����� ����ϴ� ������ �ۼ��ϼ���.
SELECT ENAME, E.DEPTNO, DNAME
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;
--��2]emp���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�,����,�޿�,�μ����� ����ϴ� SELECT���� �ۼ��ϼ���.
SELECT ENAME, E.DEPTNO, DNAME, JOB, SAL, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO AND D.LOC='NEW YORK';
--��3]EMP���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ����ϴ� SELECT���� �ۼ��ϼ���.
SELECT ENAME, E.DEPTNO, DNAME, COMM, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO 
WHERE COMM IS NOT NULL;--NULL�� ��ȣ��X
--��4]EMP���̺��� �̸� �� L�ڰ� �ִ� ����� ���� �̸�,����,�μ���,��ġ�� ����ϴ� ������ �ۼ��ϼ���.
SELECT ENAME, E.DEPTNO, DNAME, JOB, LOC
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
WHERE ENAME LIKE '%L%';
--��5]�Ʒ��� ����� ����ϴ� ������ �ۼ��Ͽ���(�����ڰ� ���� King�� �����Ͽ� ��� ����� ���)
--	---------------------------------------------
--	Emplyee		Emp#		Manager	Mgr#
--	---------------------------------------------
--	KING		7839
--	BLAKE		7698		KING		7839
--	CKARK		7782		KING		7839
--	.....
--	---------------------------------------------
--	14ROWS SELECTED.
SELECT E.ENAME EMPLOYEE, E.EMPNO "EMP#", M.ENAME MANAGER, M.EMPNO "MGR#"
FROM EMP E LEFT OUTER JOIN EMP M
ON E.MGR = M.EMPNO ORDER BY MANAGER DESC;
