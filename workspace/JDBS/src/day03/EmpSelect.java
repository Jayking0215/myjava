package day03;

import java.sql.*;
import common.util.DButil;//Driver load[1], 계정가저오기[2] 되어있음

public class EmpSelect {

	public static void main(String[] args) throws Exception{
		Connection con=DButil.getCon();
		//emp의 모든 정보를 가져오자
//		String sql="SELECT * FROM EMP ORDER BY EMPNO ASC";///[3]
		//lpad()/rpad()...출력문 간격맞추기=>table이 더 적함하긴 하다.
		String sql="SELECT EMPNO, ENAME, rpad(JOB,12,' ') JOB,";
			sql+="rpad(MGR,10,' ') MGR, HIREDATE,";
			sql+="lpad(SAL,10,' ') SAL, lpad(COMM,10,' ') COMM,";
			sql+="DEPTNO FROM EMP ORDER BY 1";
		System.out.println(sql);
		
		Statement st=con.createStatement();////[4]
		//boolean execute():모든 sql문 실행
		//int executeUpadate():DML문장 실행
		//ResultSet executeQuery():DQL문장(select문) 실행
		ResultSet rs=st.executeQuery(sql);//SELECT문에 적합하다.//[5]
		
		//반복문 돌면서 데이터 꺼내 출력하기
		while(rs.next()) {
			int no=rs.getInt(1);//컬럼 인덱스
			String name=rs.getString(2);
			String job=rs.getString(3);
			int mgr=rs.getInt(4);
			Date hdate=rs.getDate(5);
			int sal=rs.getInt(6);
			int comm=rs.getInt(7);
			int dno=rs.getInt(8);
			System.out.printf("%d\t%s\t%s\t%d\t%s\t%d\t%d\t%d\n",
					no,name,job,mgr,hdate.toString(),sal,comm,dno);
		}
		if(rs!=null)rs.close();
		
		//자원 반납
		if(st!=null)st.close();//[6]
		if(con!=null)con.close();
	}//main()

}//
