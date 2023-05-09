package com.common.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.user.model.UserVO;

import lombok.extern.log4j.Log4j;

//servlet-context.xml에 빈 등록 후 매핑한다.
//<interceptors>
//중략...
//<interceptor>
//<mapping path="/admin/**"/>
//<beans:bean class="com.common.interceptor.AdminCheckIntercpetor"/>
//</interceptor>
//</interceptors>
@Log4j
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		log.info("AdminCheckInterceptor()...");
		HttpSession session=req.getSession();
		UserVO user=(UserVO)session.getAttribute("loginUser");
		if(user!=null) {
			if(user.getMstate()!=9) {//mstate:0(일반회원),-1(정지회원),-2(탈퇴회원),9(관리자)
				req.setAttribute("msg", "관리자만 이용 가능합니다.");
				req.setAttribute("loc", req.getContextPath()+"/index");//getContextPath()는 절대경로를 나타냄
				
				RequestDispatcher disp=req.getRequestDispatcher("/WEB-INF/views/message.jsp");
				disp.forward(req, res);
				return false;
			}
		}
		return true;
	}
}///---------------------


