package com.ssamz.web.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsetTest {
	
	public static void main(String[] args) {
		//JDBC관련 변수	
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			//JDBC 1단계 : 드라이브 객체 로딩
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			//JDBC 2단계 : 커넥션 연결
			String jdbcUrl="jdbc:oracle:thin:@localhost:1521:XE";
			con=DriverManager.getConnection(jdbcUrl, "scott", "tiger");
			
			//JDBC 3단계 : Statement 생성
			String sql="insert into users values(?,?,?,?)";
			stmt=con.prepareStatement(sql);
			
			//JDBC 4단계 : SQL전송
			stmt.setString(1, "ssamz");
			stmt.setString(2, "ssamz123");
			stmt.setString(3, "쌤즈");
			stmt.setString(4, "ADMIN");
			
			//SQL 전송
			int count=stmt.executeUpdate();
			System.out.println(count+"건 데이터 처리 성공!");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}

