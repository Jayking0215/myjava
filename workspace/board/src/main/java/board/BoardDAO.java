package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import common.DBUtil;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//C(생성)
	public int insertBoard(BoardVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("insert into BBS(num,title,writer,content,regdate,cnt)")
						.append(" values(bbs_seq.nextval,?,?,?,sysdate,0)");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			ps.setString(1,vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			return ps.executeUpdate();
		}finally {
			close();
		}
	}//insertBoard()-----
	
	//R(읽기)
	public List<BoardVO> listBoard() throws SQLException {
		try {
			con=DBUtil.getCon();
			String sql="select * from bbs order by num desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			return makeList(rs);
		}finally {
			close();
		}
	}//listBoard()-----
	
	public List<BoardVO> makeList(ResultSet rs) throws SQLException{
		List<BoardVO> arr=new ArrayList<>();
		while(rs.next()) {
			int num=rs.getInt("num");
			String title=rs.getString("title");
			String writer=rs.getString("writer");
			String content=rs.getString("content");
			Timestamp regdate=rs.getTimestamp("regdate");
			int cnt=rs.getInt("cnt");
			BoardVO vo=new BoardVO(num,title,writer,content,regdate,cnt);
			arr.add(vo);
		}
		return arr;
	}//makeList()------------
	
	//U(갱신)
	public int updateBoard(BoardVO vo)throws SQLException{
		try {
		con=DBUtil.getCon();
		StringBuilder buf=new StringBuilder("update bbs set title=?,")
					.append(" content=?,regdate=systimestamp where num=?");
		String sql=buf.toString();
		ps=con.prepareStatement(sql);
		ps.setString(1, vo.getTitle());
		ps.setString(2, vo.getContent());
		ps.setInt(3, vo.getNum());
		return ps.executeUpdate();
		}finally {
			close();
		}
	}//updateBoard()-----
	
	//D(삭제)
	public int deleteBoard(int num) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="update from bbs where num=?";
			ps.setInt(1, num);
			return ps.executeUpdate();
		}finally {
			close();
		}
	}//deleteBoard()-----
	
	//객체 반환
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}//close()-----
}
