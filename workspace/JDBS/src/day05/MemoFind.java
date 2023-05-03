package day05;

import java.sql.*;
import common.util.*;

//검색어를 입력하면 해당 검색어를 갖는 메모글을 가져오는 프로시저 작성하고
//자바와 연동시키세요
/*
create or replace procedure memo_find
(jmsg in MEMO.msg%type,
mycr out sys_refcursor
    )
is
begin
    open mycr for
    select no,name,MSG,wdate
    from memo where MSG like '%'||jmsg||'%';
end;
/
*/
public class MemoFind {

	public static void main(String[] args) throws Exception {
		
	}//main()

}
