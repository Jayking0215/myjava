package board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GetBoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
		
		//1. 연동처리
		BoardVO vo=new BoardVO();
		BoardDAO dao=new BoardDAO();
		List<BoardVO> boardList = null;
		try {
			boardList = dao.getBoardList(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//2. 응답화면 구성
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out=res.getWriter();
		
		out.println("<h1>게시글 목록</h1>");
		out.println("<hr>");
		
		for(BoardVO board : boardList) {
			out.println("---> "+board.toString()+"</br>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
