package user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.NotUserException;
import user.model.UserDAO;
import user.model.UserVO;

public class LoginEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid=req.getParameter("userid");
		String pwd=req.getParameter("pwd");
		String saveId=req.getParameter("saveId");
		if(userid==null||pwd==null||userid.trim().isEmpty()||pwd.trim().isEmpty()) {
			this.setViewPage("login.do");
			this.setRedirect(true);
			return;
		}
		UserDAO userDao=new UserDAO();
		try {
			UserVO user=userDao.loginCheck(userid, pwd);
			//아이디와 pwd가 일치하지 않으면 NotUserException을 발생시킴
			HttpSession session=req.getSession();
			if(user!=null) {
				//회원인증 받았다면=>session에 UserVO를 저장하자
				session.setAttribute("loginUser", user);
				Cookie ck=new Cookie("uid", user.getUserid());
				if(saveId!=null) {
					ck.setMaxAge(7*24*60*60);
				}else {
					ck.setMaxAge(0);
				}
				ck.setPath("/");
				res.addCookie(ck);
			}//if()----
			this.setViewPage("index.do");
			this.setRedirect(true);
		}catch(NotUserException e){
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("loc", "javascript:history.back()");
			this.setViewPage("/message.jsp");
			this.setRedirect(false);
		}
	}
}
