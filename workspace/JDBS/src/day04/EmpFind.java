package day04;
//DML
import java.sql.*;
import java.util.*;
import common.util.DButil;//[1],[2]
//PreparedStatement 활용
public class EmpFind {

	public static void main(String[] args) throws Exception {
		//검색할 사원의 이름 키워드를 입력받아서 해당 사원정보를 출력하세요
		//사번, 사원명, 부서명, 담당업무, 입사일, 근무지 가져와 출력하기
		Scanner sc=new Scanner(System.in);
		System.out.println("검색할 사원의 키워드 이름: ");
		String keyword=sc.nextLine();

		Connection con=DButil.getCon();//[3]
		
		String sql="SELECT EMPNO, ENAME, DNAME, JOB, HIREDATE, LOC";
			sql+=" FROM EMP E JOIN DEPT D";
			sql+=" ON E.DEPTNO = D.DEPTNO";
			sql+=" WHERE ENAME LIKE ?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,"%"+keyword+"%");//''붙여주는 역할을 함
		ResultSet rs=ps.executeQuery();
		
		int cnt=0;
		while(rs.next()) {
			cnt++;
			int no=rs.getInt("empno");
			String name=rs.getString("ename");
			String dname=rs.getString("dname");
			String job=rs.getString("job");
			java.sql.Date hdate=rs.getDate("hiredate");
			String loc=rs.getString("loc");
			
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t\n",no,name,dname,job,hdate.toString(),loc);
		}
		if(cnt==0) {
			System.out.println("검색한 사원 정보는 없습니다.");
		}
		if(rs!=null)rs.close();
		if(ps!=null)rs.close();
		if(con!=null)rs.close();
		
		
	}//main()

}
