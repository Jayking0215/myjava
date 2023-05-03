package day02;

import java.util.*;
import java.sql.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException
	{
		//Scanner 생성
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자: ");
		String name=sc.nextLine();
		System.out.println("메모 내용: ");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
		//1. Driver Loading
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading 성공!!");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		//2. DB 연결
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 성공!!");
		//3. SQL문 작성
		String sql="INSERT INTO MEMO(NO, NAME, MSG, WDATE)";
		sql+="VALUES(MEMO_SEQ.NEXTVAL,'"+name+"','"+msg+"',SYSDATE)";
		System.out.println(sql);
		//4. Statement얻기
		Statement stmt=con.createStatement();
		//5. execute()실행:모든 sql문을 실행시킨다.
		//public int executeUpdate(String sql) : INSERT/DELETE/UPDATE문을 실행시키고자 할 때
//		boolean b = stmt.execute(sql);
		int b=stmt.executeUpdate(sql);//sql문에 의해 영향받은 레코드 개수를 반환
		
		System.out.println("b: "+b);
		System.out.println("데이터 삽입 성공!!");
		System.out.println((b>0)?"글쓰기 성공":"글쓰기 실패");
		//6. 자원 반납
		if(stmt!=null) {
			stmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
}
