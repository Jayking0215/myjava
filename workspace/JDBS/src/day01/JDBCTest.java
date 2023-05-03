package day01;

import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		//1.Driver Loading;통역사=>ojdbc6.jar
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//오라클 드라이버를 패키지에 오리기
			System.out.println("Driver Loading 성공!!");
		//2.오라클DB에 접속:DirverManager클래스의 getConnection()메서드 이용
			String url="jdbc:oracle:thin:@localhost:1521:XE";
					//프로토콜:dbms유형:드라이버타입:@DB서버host:port:전역DB명
			String user="scott", pwd="tiger";
			Connection con=DriverManager.getConnection(url,user,pwd);
			
			System.out.println("DB Connected!!");
		//3.SQL문을 작성(java언어로)
			String sql="CREATE TABLE memo (no number(4) primary key,";
					sql+="name varchar2(30) not null,";
					sql+="msg varchar2(100),";
					sql+="wdate date default sysdate)";
					
		//4.Statement객체를 Connection의 createStatement()매서드를 이용해서 얻어온다
			Statement stmt = con.createStatement();
					
		//5.execute()/executeUpdate()/executeQuery()매서드 중 하나를 이용해서 sql문을 실행
			boolean b=stmt.execute(sql);//sql문을 실행시킨다
			System.out.println("b: "+b);//select문을 실행하면 true반환, 그 외의 문장을 false로 반환
		//6.DB와 연결된 자원을 반납=>반드시 실행해야 하는 부분
			if(stmt!=null) stmt.close();//[1]
			if(con!=null) con.close();//[2] 순서 중요!
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading 실패!!");
			e.printStackTrace();
		}catch(SQLException e) {//오타발생시
			System.out.println("DB연결 중 에러 발생!!!");
			e.printStackTrace();
		}
	}

}
