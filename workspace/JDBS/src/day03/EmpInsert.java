package day03;

import java.sql.*;
import java.util.*;
import common.util.*;//[1],[2]

public class EmpInsert {

	public static void main(String[] args) throws Exception{
		//emp테이블에서 사번, 이름, 업무, 부서번호, 급여를 scanner로 입력받아서
		//insert문을 실행시키세요
		//단,PreparedStatement를 이용하기
		
		//Scanner로 입력받기
		Scanner sc=new Scanner(System.in);
		System.out.println("사  번: ");
		int num=sc.nextInt();//enter값을 먹어서 다음작업 수행 안됨
		sc.nextLine();//줄바꿈 넣어서 enter값 먹지않게 한다.(1번만 사용하면 )
		
		System.out.println("이  름: ");
		String name=sc.nextLine();
		
		System.out.println("업  무: ");
		String job=sc.nextLine();
		
		System.out.println("부서번호: ");
		int dnum=sc.nextInt();
		
		System.out.println("급  여: ");
		int sal=sc.nextInt();
		
		//Connection
		Connection con=DButil.getCon();//[3]
		//sql문 작성_in parameter지정
		String sql="INSERT INTO EMP(EMPNO, ENAME, JOB, HIREDATE, DEPTNO, SAL) values(?,?,?,SYSDATE,?,?)";
		//PreparedStatement로 sql불러오기
		PreparedStatement ps=con.prepareStatement(sql);//[4]
		//in parameter값 넣기
		ps.setInt(1,num);
		ps.setString(2,name);
		ps.setString(3,job);
		ps.setInt(4,dnum);
		ps.setInt(5,sal);
		//excuteUpdate()로 실행
		int n=ps.executeUpdate();
		System.out.println(n>0?"입력 성공":"입력 실패");
		//반환
		if(ps!=null)ps.close();//[6]
		if(con!=null)con.close();
		
	}

}
