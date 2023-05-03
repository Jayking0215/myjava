package day03;

import java.sql.*;
import common.util.DButil;//[1][2]처리 되어잇음
import java.util.*;//Scanner사용

/*
 * Statement
 *  +--PreparedStatement
 *  :sql문을 미리 dbms포멧에 맞게 컴파일 시켜서 준비시킨다(Statement문은 '"컬럼명"'으로 입력해야 했음)
 *  Statement보다 DB와 연동하는 속도가 빠르다.
 *  */
public class PreparedStatementTest {

	public static void main(String[] args) throws Exception{
		//메모글을 수정하는 문장을 작성하자
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자: ");
		String name=sc.nextLine();
		
		System.out.println("수정할 메모 내용: ");
		String msg=sc.nextLine();
		
		Connection con=DButil.getCon();
		String sql="UPDATE MEMO SET MSG=?, WDATE=SYSDATE WHERE NAME=?";
		//?:in parameter:변경된 값을 in parameter로 처리
		
		PreparedStatement ps=con.prepareStatement(sql);//sql문을 ?만 제외하고 미리 컴파일 시킨다.
		
		//in parameter값을 setting...?값 설정
		ps.setString(1, msg);
		ps.setString(2, name);
		
		int n=ps.executeUpdate();//sql문 이미 컴파일 되었기때문에 실행만 시키면 된다.
		
		System.out.println(n>0?"글 수정 성공":"수정 실패");
		
		//반환
		if(ps!=null)ps.close();
		if(con!=null)con.close();
		
		
	}//main()

}//
