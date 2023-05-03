package day04;
/*
 * [실습 2] Java class명: MemoUpdate
memo_edit프로시저를 호출하는 jdbc코드를 구현하세요
*/

import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import common.util.DButil;

public class MemoUpdate {

	public static void main(String[] args) throws Exception{
		String noStr=JOptionPane.showInputDialog("수정할 글 번호를 입력하세요");
		String name=JOptionPane.showInputDialog("수정할 작성자명을 입력하세요.");
		String msg=JOptionPane.showInputDialog("수정할 메모 내용을 입력하세요.");
		if(noStr==null||name==null||msg==null) return;
		
		Connection con=DButil.getCon();
		String sql="{call memo_edit(?,?,?)}";
		
		CallableStatement cs=con.prepareCall(sql);
		//in parameter값 setting
		cs.setInt(1, Integer.parseInt(noStr));//noStr은 string이니까 형변환
		cs.setString(2, name);
		cs.setString(3, msg);
		
		//실행
		cs.execute();
		System.out.println("메모 글 등록 성공!!");
		
		if(cs!=null)cs.close();
		if(con!=null)con.close();
	}

}
