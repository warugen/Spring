package com.tj.inputTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.inputTest.Student;

@Controller
public class SController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 4;
	}
	
	@RequestMapping(value="inputForm", method = RequestMethod.GET)
	public String inputForm() {
		return "inputForm";
	}
	
	@RequestMapping(value="input", method = RequestMethod.GET)
	//public String input(Student student, Model model) {
	public String input(Student student) {
		
		int tot = student.getKor() + student.getEng() + student.getMath();
		double avg = (double)Math.round((double)tot / 3 * 100 ) / 100;
		
		student.setTotal(tot);
		student.setAvg(avg);
		
		//model.addAttribute("student", student);
		return "input";
	}
}
