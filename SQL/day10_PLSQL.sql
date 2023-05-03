PL/SQL의 유형
[1] Anonymous Block(익명블럭)
[2] Subprogram(Procedure, Function)
----------------------------------------
[1]익명블럭
선언부
실행부
예외처리부
-----------------------------------------
/*--왜 안되지?????????
DECLARE--선언부
    --변수 선언
    MSG VARCHAR2(100);
BEGIN--실행부...END;
    MSG := 'HELLO ORACLE~';
    DBMS_OUTPUT.PUT_LINE(MSG); --출력문
--    EXCEPTION--예외처리부
END;
/

SET SERVEROUTPUT ON--출력하려면 선행되야함(DEFAULT OFF)
*/
--------------------------------------------------
#익명블럭
--문1]현재 시간에서 1시간 전과 3시간 후를 출력하는 PROCEDURE를 작성
DECLARE
    VTIME1 TIMESTAMP;
    VTIME3 TIMESTAMP;
BEGIN
    SELECT SYSTIMESTAMP - 1/24,
        SYSTIMESTAMP + 3/24 INTO VTIME1, VTIME3
        FROM DUAL;
        DBMS_OUTPUT.PUT_LINE('한 시간 전'||VTIME1);
        DBMS_OUTPUT.PUT_LINE('3시간 뒤'||VTIME3);
END;
/

SET SERVEROUTPUT ON
----------------------------------------------------------------
#이름있는 PROCEDURE
CREATE OR REPLACE PROCEDURE EVEN_ODD(NUM IN NUMBER)--(매개변수 인파라미터 IN 자료유형)
IS
--선언부
    MSG VARCHAR2(30);
BEGIN
--실행부
    IF MOD(NUM,2) = 0 THEN
        MSG:='짝수';
    ELSE
        MSG:='홀수';
    END IF;
    DBMS_OUTPUT.PUT_LINE(NUM||'은 '||MSG||'입니다');
END;
/
EXECUTE EVEN_ODD(45);--이름있는 프로시져 실행방법
EXECUTE EVEN_ODD(88);
--------------------------------------------------------------------------------
--문1]
--인 파라미터 2개를 받아서 MEMBER테이블에
--데이터를 INSERT하는 프로시저를 작성하세요
--프로시저명: MEMO_ADD
CREATE OR REPLACE PROCEDURE MEMO_ADD(
PNAME IN VARCHAR2, PMSG IN VARCHAR2)
IS
BEGIN
    INSERT INTO MEMO(NO, NAME, MSG)
    VALUES(MEMO_SEQ.NEXTVAL, PNAME, PMSG);
    COMMIT;
END;
/
EXECUTE MEMO_ADD('김성주','프로시저로 작성했습니다');
EXECUTE MEMO_ADD('최남주','저도 작성했음');
SELECT * FROM MEMO;
-------------------------------------------------------------------------------
/*[실습 1]
memo테이블 관련
글내용을 수정하는 프로시저를 작성해봅시다.
인파라미터로
(글번호,  수정할 작성자명, 수정할 메모글)
을 입력받아 해당 글번호 글의 작성자명과 메모내용을 수정하는 
프로시저를 작성하세요
프로시저명: memo_edit
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
--확인
select * from memo;
execute memo_edit(4,'pigaro','this is edited');
