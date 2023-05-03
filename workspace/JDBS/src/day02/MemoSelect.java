package day02;

import java.sql.*;
import common.util.*;

public class MemoSelect {

	public static void main(String[] args) throws SQLException {
		Connection con=DButil.getCon();
//		System.out.println(con);
		
		String sql="SELECT NO, NAME, MSG, WDATE FROM MEMO ORDER BY NO DESC";
		
		Statement st=con.createStatement();
		
		boolean b=st.execute(sql);//SELECT문이면 true반환
		System.out.println("b: "+b);
		//결과 추출하기
		if(b) {//select문이라면=>결과 테이블(ResultSet)
			ResultSet rs=st.getResultSet();
			
			//ResultSet의 메서드
			//boolean next(): 논리적인 커서를 이동시켜서 가리키고 있는 곳에 레코드가 있으면 true반환, 없으면 false
			//				논리적인 커서는 처음에 before first에 위치
			
			while(rs.next()) {
				int no=rs.getInt("NO");
				String name=rs.getString("NAME");
				String msg=rs.getString("MSG");
				java.sql.Date wdate=rs.getDate("WDATE");
				System.out.println(no+"\t"+name+"\t"+msg+"\t"+wdate);
			}
			
			if(rs!=null)rs.close();//꼭 닫아줘야 함
			
		}else {//select문이 아니라면( ex) DML,DDL...)
			int n=st.getUpdateCount();
			System.out.println(n+"개의 레코드가 변경되었습니다.");
		}
		
		if(st!=null)st.close();
		if(con!=null)con.close();
		
		
	}

}
