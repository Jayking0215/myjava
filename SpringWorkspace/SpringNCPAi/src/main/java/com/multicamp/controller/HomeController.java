package com.multicamp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public String showHome(Model m) {
		Date today=new Date();
		m.addAttribute("today", today.toString());
		
		return "home";
		//WEB-INF/views/home.jsp
	}

}
