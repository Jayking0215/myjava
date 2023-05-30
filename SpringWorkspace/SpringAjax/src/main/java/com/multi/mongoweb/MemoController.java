package com.multi.mongoweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.multi.domain.MemoVO;
import com.multi.service.MemoService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MemoController {
	
	@Autowired	
	private MemoService mService;
	
	@GetMapping("/memo")
	public String memoForm() {
		
		return "memo/input";
		//WEB-INF/memo/input.jsp
	}
	
	@PostMapping("/memo")
	public String memoInsert(@ModelAttribute MemoVO memo) {
		log.info("memo==="+memo);
		int n=mService.insertMemo(memo);
		
		return "redirect:list";
	
	}

}
