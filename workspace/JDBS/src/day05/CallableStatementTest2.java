package day05;
import java.sql.*;
import common.util.*;
import javax.swing.*;
/*
create or replace procedure emp_forjava
(
    pdno in emp.deptno%type,
    mycr out sys_refcursor
)
is
begin
    open mycr for
    select ename,job, dname,loc,hiredate from
    (select * from emp where deptno=pdno) A join dept d
    on a.deptno=d.deptno;    
end;
/
-------------------------------------------------------------
*/
public class CallableStatementTest2 {

	public static void main(String[] args) throws Exception{
		String dnoStr=JOptionPane.showInputDialog("검색할 부서 번호를 입력하세요");
		if(dnoStr==null)return;
		Connection con=DButil.getCon();
		
		String sql="{call emp_forjava(?,?)}";//in,out parameter
		
		CallableStatement cs=con.prepareCall(sql);
		
		//in parameter값 setting: setXXXX()
		//out parameter값 setting: registerOutParameter();
		cs.setInt(1, Integer.parseInt(dnoStr));
		cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);//상수(static)
		
		cs.execute();
		
		//cursor는 ResultSet과 호환됨
		ResultSet rs=(ResultSet)cs.getObject(2);
		
		System.out.println("--"+dnoStr+"번 부서 사원 목록------------");
		while(rs.next()) {
			String name=rs.getString(1);
			String job=rs.getString(2);
			String dname=rs.getString(3);
			String loc=rs.getString(4);
			java.sql.Date hdate=rs.getDate(5);
			System.out.println(name+"\t"+job+"\t"+dname+"\t"+loc+"\t"+hdate);
		}//while
		if(rs!=null)rs.close();
		if(rs!=null)cs.close();
		if(rs!=null)con.close();
	}//main()
}
