package common.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "*.me" }, 
		initParams = { 
				@WebInitParam(name = "config", value = "파일경로")
		})
public class FrontController_old extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String,Object> cmdMap=new HashMap<>();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}

	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("process()");
		//http://localhost:9090/MVCWeb/index.do => URL
		//1. 클라이언트의 요청 URI를 분석해보자
		String cmd=req.getServletPath();
		System.out.println("cmd: "+cmd);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req,res);
	}
}
