package com.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.log4j.Log4j;

/*�������� ���� ó�� ���
 * [1] @ExceptionHandler�� �̿��ϴ� ���
 * [2] @ControllerAdvice�� �̿��ϴ� ���
 * [3] @ResponseStatus �� �̿��ؼ� HTTP�����ڵ� ó���ϴ� ���
 * */
//servlet-context.xml�� component-scan �� com.common��Ű�� ����ؾ� ��
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex, Model m) {
		//ex.printStackTrace();
		//log.error(ex);
		m.addAttribute("exception", ex);
		return "login/errorAlert";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler2(Exception ex,Model m) {
		//log.error(ex);
		m.addAttribute("exception",ex);
		return "login/errorAlert";
	}

}
