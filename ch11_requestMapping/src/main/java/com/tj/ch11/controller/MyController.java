package com.tj.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	/*
	@RequestMapping(value="student")
	public String student(HttpServletRequest request, Model model) {
		String method = request.getMethod();	// GET, POST방식인지 넘겨준다.
		String id = request.getParameter("id");
		model.addAttribute("method", method);
		model.addAttribute("id", id);
		return "studentId";
	}
	*/
	
	@RequestMapping(value="student", method = RequestMethod.GET)
	public String student(String id, Model model) {
		System.out.println("get방식 student 메소드");
		model.addAttribute("id", id);
		model.addAttribute("method", "GET");
		return "studentId";
	}
	
	@RequestMapping(value="student", method = RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		System.out.println("post방식 student 메소드");
		mav.addObject("id", id);
		mav.addObject("method", "POST");
		mav.setViewName("studentId");
		return mav;
	}
	
	@RequestMapping(value="studentConfirm", method = RequestMethod.GET)
	public String studentConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
//			return "redirect:studentOk.do";	// 새로운 요청(새로운 request 요청)
			return "forward:studentOk.do";	// id값까지 그대로 studeontOk.do로 보내준다.
		}
		return "redirect:studentNg.do?id="+id;
	}
	
	@RequestMapping(value="studentOk", method = RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	
	@RequestMapping(value="studentNg", method = RequestMethod.GET)
	public String studentNg(String id, Model model) {
		model.addAttribute("id", id);
		return "studentNg";
	}
	
	@RequestMapping(value="fullPath", method =  RequestMethod.GET)
	public String fullPath() {
		return "redirect:http://localhost:8181/ch11/student/fullPath.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
