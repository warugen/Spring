package com.tj.ch13.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch13.dto.BoardDto;
import com.tj.ch13.service.BContentService;
import com.tj.ch13.service.BDeleteService;
import com.tj.ch13.service.BListService;
import com.tj.ch13.service.BModifyService;
import com.tj.ch13.service.BModifyViewService;
import com.tj.ch13.service.BReplyService;
import com.tj.ch13.service.BReplyViewService;
import com.tj.ch13.service.BService;	// 서비스들이 들어있는 패키지
import com.tj.ch13.service.BWriteService;

@Controller
public class BController {
	private BService service;
	private boolean writable = false;
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		model.addAttribute("pageNum", pageNum);
		service = new BListService();
		service.execute(model);
		return "mvcboard/list";
	}
	
	@RequestMapping(value="write_view", method = RequestMethod.GET)
	public String write_view() {
		writable = true;
		return "mvcboard/write_view";
	}
	
	@RequestMapping(value="write", method = RequestMethod.POST)
	public String write(BoardDto boardDto, HttpServletRequest request, Model model) {
		if(writable) {	// write_view를 거쳐온 경우만 글쓰기 가능하도록 설정
			model.addAttribute("request", request);		// 서비스단에서 ip 추출하기 위해서 model에 넣어준다.
			model.addAttribute("bip", request.getRemoteAddr());	// 아니면 model에 바로 request에서 ip추출한값 넣어주기
			service = new BWriteService();
			service.execute(model);
			writable = false;	// 글쓰기 못하게 설정
		}
		return "forward:list.do";
	}
	
	@RequestMapping(value="content_view", method = RequestMethod.GET)
	public String content_view(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BContentService();
		service.execute(model);
		return "mvcboard/content_view";
	}
	
	@RequestMapping(value="modify_view", method = RequestMethod.GET)
	public String modify_view(int bid, Model model) {
		writable = true;
		model.addAttribute("bid", bid);
		service = new BModifyViewService();
		service.execute(model);
		return "mvcboard/modify_view";
	}
	
	@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modify(BoardDto boardDto, HttpServletRequest request, Model model) {
		if(writable) {
			model.addAttribute("bip", request.getRemoteAddr());
			service = new BModifyService();
			service.execute(model);
			writable = false;
		}
		return "forward:list.do";
	}
	
	@RequestMapping(value="delete", method = RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid", bid);
		service = new BDeleteService();
		service.execute(model);
		return "forward:list.do";
	}
	
	@RequestMapping(value="reply_view", method = RequestMethod.GET)
	public String reply_view(int bid, Model model) {
		writable = true;
		model.addAttribute("bid", bid);
		service = new BReplyViewService();
		service.execute(model);
		return "mvcboard/reply_view";
	}
	
	@RequestMapping(value="reply", method = RequestMethod.POST)
	public String reply(BoardDto boardDto, HttpServletRequest request, Model model) {
		if(writable) {
			// bgroup, bstep, bindent : 원글에 대한 정보는 자동으로 boardDto에 저장되있다.
			model.addAttribute("request", request);
			service = new BReplyService();
			service.execute(model);
			writable = false;
		}
		return "forward:list.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
