package com.tj.ch10.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tj.ch10.dto.MemberDto;

@Controller
@RequestMapping("member")
public class MController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test");
		list.add("test2");
		list.add("test3");
		
		return list;
	}
	@RequestMapping("join1")
	public String join1(HttpServletRequest request, Model model) {
		// 파일첨부를 한다면 이방법으로 해야한다.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		
		return "member/result1";
	}
	
	@RequestMapping("join2")
	public String join2(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pw") String pw, 
					@RequestParam("age") int age, @RequestParam("email") String email, @RequestParam("address") String address, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "/member/result1";
	}
	
	@RequestMapping("join3")
	// 변수이름과 파라이터 이름이 일치하면 자동으로 달라붙는다.
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "/member/result1";
	}
	
	@RequestMapping("join4")
	public String join4(@ModelAttribute("member") MemberDto memberDto) {
		// @ModelAttribute("member") MemberDto memberDto를 선언해주면 자동으로 알아서 세팅해준다.
		// 파일첨부로는 이방법을 사용못한다.
		return "/member/result4";
	}
	
	@RequestMapping("join5")
	public String join5(MemberDto memberDto, Model model) {
		model.addAttribute("member", memberDto);
		return "/member/result4";
	}
	
	@RequestMapping("join6")
	public String join6(MemberDto member) {
		// model.addAttribute("memberDto", member); 자동으로 이과정을 해준다.
		return "/member/result6";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
