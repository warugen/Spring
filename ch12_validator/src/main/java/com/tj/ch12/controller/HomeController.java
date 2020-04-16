package com.tj.ch12.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch12.dto.Student;
import com.tj.ch12.dto.StudentValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String inputForm() {		
		return "inputForm";
	}
	
	@RequestMapping(value="input", method = RequestMethod.POST)
	//public String input(@Validated Student student, BindingResult errors, Model model) {
	public String input(@Valid Student student, BindingResult errors, Model model) {
		//StudentValidator validator = new StudentValidator();
		//validator.validate(student, errors);	// 검증처리
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 반드시 입력해라");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수로 입력해라");
			}
			return "inputForm";
		}
		return "inputResult";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}
	
}
