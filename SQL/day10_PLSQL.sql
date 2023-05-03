PL/SQL�� ����
[1] Anonymous Block(�͸��)
[2] Subprogram(Procedure, Function)
----------------------------------------
[1]�͸��
�����
�����
����ó����
-----------------------------------------
/*--�� �ȵ���?????????
DECLARE--�����
    --���� ����
    MSG VARCHAR2(100);
BEGIN--�����...END;
    MSG := 'HELLO ORACLE~';
    DBMS_OUTPUT.PUT_LINE(MSG); --��¹�
--    EXCEPTION--����ó����
END;
/

SET SERVEROUTPUT ON--����Ϸ��� ����Ǿ���(DEFAULT OFF)
*/
--------------------------------------------------
#�͸��
--��1]���� �ð����� 1�ð� ���� 3�ð� �ĸ� ����ϴ� PROCEDURE�� �ۼ�
DECLARE
    VTIME1 TIMESTAMP;
    VTIME3 TIMESTAMP;
BEGIN
    SELECT SYSTIMESTAMP - 1/24,
        SYSTIMESTAMP + 3/24 INTO VTIME1, VTIME3
        FROM DUAL;
        DBMS_OUTPUT.PUT_LINE('�� �ð� ��'||VTIME1);
        DBMS_OUTPUT.PUT_LINE('3�ð� ��'||VTIME3);
END;
/

SET SERVEROUTPUT ON
----------------------------------------------------------------
#�̸��ִ� PROCEDURE
CREATE OR REPLACE PROCEDURE EVEN_ODD(NUM IN NUMBER)--(�Ű����� ���Ķ���� IN �ڷ�����)
IS
--�����
    MSG VARCHAR2(30);
BEGIN
--�����
    IF MOD(NUM,2) = 0 THEN
        MSG:='¦��';
    ELSE
        MSG:='Ȧ��';
    END IF;
    DBMS_OUTPUT.PUT_LINE(NUM||'�� '||MSG||'�Դϴ�');
END;
/
EXECUTE EVEN_ODD(45);--�̸��ִ� ���ν��� ������
EXECUTE EVEN_ODD(88);
--------------------------------------------------------------------------------
--��1]
--�� �Ķ���� 2���� �޾Ƽ� MEMBER���̺�
--�����͸� INSERT�ϴ� ���ν����� �ۼ��ϼ���
--���ν�����: MEMO_ADD
CREATE OR REPLACE PROCEDURE MEMO_ADD(
PNAME IN VARCHAR2, PMSG IN VARCHAR2)
IS
BEGIN
    INSERT INTO MEMO(NO, NAME, MSG)
    VALUES(MEMO_SEQ.NEXTVAL, PNAME, PMSG);
    COMMIT;
END;
/
EXECUTE MEMO_ADD('�輺��','���ν����� �ۼ��߽��ϴ�');
EXECUTE MEMO_ADD('�ֳ���','���� �ۼ�����');
SELECT * FROM MEMO;
-------------------------------------------------------------------------------
/*[�ǽ� 1]
memo���̺� ����
�۳����� �����ϴ� ���ν����� �ۼ��غ��ô�.
���Ķ���ͷ�
(�۹�ȣ,  ������ �ۼ��ڸ�, ������ �޸��)
�� �Է¹޾� �ش� �۹�ȣ ���� �ۼ��ڸ�� �޸𳻿��� �����ϴ� 
���ν����� �ۼ��ϼ���
���ν�����: memo_edit
*/
create or replace procedure memo_edit(
pno in number, pname in varchar2, pmsg in varchar2)
is
begin
    update memo set name=pname, msg=pmsg
    where no=pno;
    commit;
end;
/
--Ȯ��
select * from memo;
execute memo_edit(4,'pigaro','this is edited');
