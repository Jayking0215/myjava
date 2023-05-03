package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.util.DBUtil;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//CRUD 기능의 메서드
	//글 등록
	public void insertBoard(BoardVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			StringBuilder buf=new StringBuilder("insert into bbs(seq, title, writer, content)")
						.append(" values(select nvl(max(seq),0)+1 from bbs),?,?,?)");
			String sql=buf.toString();
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			
			ps.executeUpdate();
		}finally {
			close();
		}
	}//insertBoard()-----
	
	//글 수정
	public void updateBoard(BoardVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="update bbs set title=?, content=?, where seq=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
			
			ps.executeUpdate();
		}finally {
			close();
		}
	}//updateBoard()------
	
	//글 삭제
	public void deleteBoard(BoardVO vo) throws SQLException{
		try {
			con=DBUtil.getCon();
			String sql="delete bbs where seq=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, vo.getSeq());
			
			ps.executeUpdate();
		}finally {
			close();
		}
	}//deleteBoard()------
	
	//글 상세 조회
	public BoardVO getBoard(BoardVO vo) throws SQLException {
		BoardVO board=null;
		try {
			con=DBUtil.getCon();
			String sql="select * from bbs where seq=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, vo.getSeq());
			
			if(rs.next()) {
				board=new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}finally {
			close();
		}
		return board;
	}//getBoard()-----
	
	//글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
		List<BoardVO> boardList=new ArrayList<BoardVO>();
		try {
			con=DBUtil.getCon();
			String sql="select * from bbs order by seq desc";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO board=new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}finally {
			close();
		}
		return boardList;
	}//getBoardList()-----

	
	
	//DB연결 자원반납 메서드
	public void close() throws SQLException{
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//close()----
	
}
