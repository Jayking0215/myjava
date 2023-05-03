package com.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.memo.model.MemoDAO;
import com.memo.model.MemoVO;

@Controller
public class MemoController {
	
	//@Autowired : MemoDAO타입의 객체가 있으면 해당 객체를 주입해준다.
	@Autowired
	private MemoDAO memoDao;
	
	@RequestMapping(value="/memo", method=RequestMethod.GET)
	public String memoForm() {
		
		return "memo/input";//view name
		// /WEB-INF/Views/memo/input.jsp
	}
	
	@RequestMapping(value="/memo", method=RequestMethod.POST)
	public String memoInsert(Model model, @ModelAttribute MemoVO memo) {
		//@ModelAttribute를 붙이면 html의 input name하고 VO객체의 property명이 같을 경우 자동으로
		//입력값을 VO에 setting해준다.
		//System.out.println(memo.getName()+"/"+memo.getMsg());
		
		int n=memoDao.insertMemo(memo);
		/*
		String str=(n>0)?"메모 등록 완료":"메모 등록 실패";
		String loc=(n>0)?"memoList":"javascript:history.back()";
		
		model.addAttribute("msg",str);
		model.addAttribute("loc",loc);
		
		return "message";
		// /WEB-INF/Views/message.jsp
		//----접두사-------       -접미사-
		 * 
		 */
		return "redirect:memoList";
	}
	
	@RequestMapping(value="/memoList")//, method=RequestMethod.GET) =>GET Default
	public String memoList(Model model,@RequestParam(defaultValue="1")int cpage) {
		//System.out.println("cpage: "+cpage);
		//총 게시글 수 가져오기
		if(cpage<=0) {
			cpage=1;
		}
		int totalCount=memoDao.getTotalCount();
		int pageSize=5;
		int pageCount=(totalCount-1)/pageSize+1;
		if(cpage>pageCount) {
			cpage=pageCount;
		}
		int end=cpage*pageSize;
		//int start=end-(pageSize-1);
		int start=end-pageSize;
		//전체 글 가져오기
		List<MemoVO> memoArr=memoDao.listMemo(start, end);
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("memoArr", memoArr);
		model.addAttribute("pageCount",pageCount);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("cpage", cpage);
		return "memo/list";
	}

	@RequestMapping(value="/memoEdit", method=RequestMethod.GET)
	public String memoEditForm(Model model, @RequestParam(defaultValue="0")int no) {
		//1. 글 번호 유효성 체크 => memoList로 redirect이동
		if(no==0) {
			return "redirect:memoList";
		}
		//2.memoDao.getMemo(글번호) => MemoVO객체를 model에 저장
		MemoVO vo=memoDao.getMemo(no);
		
		model.addAttribute("memo",vo);
		
		return "memo/edit";
	}
	
	@RequestMapping(value="/memoEdit", method=RequestMethod.POST)
	public String  memoEditEnd(Model model, @ModelAttribute("memo")MemoVO memo) {
		
		//memoDao의 updateMemo(memo)
		int n=memoDao.updateMemo(memo);
		String str=(n>0)?"수정 성공":"수정 실패";
		String loc=(n>0)?"memoList":"javascript:history.back()";
		
		model.addAttribute("msg", str);
		model.addAttribute("loc", loc);
		return "message";
	}

	@RequestMapping(value="/memoDel")
	public String memoDelete(Model model,@RequestParam(defaultValue="0") int no) {
		//no 파라미터값이 넘어오지 않으면 default값으로 0준다.
		
		if(no==0) {
			//유효성 체크
			return "redirect:memoList";
			//"redirect:뷰이름" 접두어 redirect:을 붙이면 redirect방식으로 이동
		}
		int n=memoDao.deleteMemo(no);
		
		String str=(n>0)?"삭제 성공":"삭제 실패";
		String loc="memoList";
		
		model.addAttribute("msg", str);
		model.addAttribute("loc", loc);
		return "message";
	}
}
