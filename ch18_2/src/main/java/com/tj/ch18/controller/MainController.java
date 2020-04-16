package com.tj.ch18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch18.service.BookService;

@Controller
public class MainController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="main")
	public String main(Model model) {
		model.addAttribute("main", bookService.mainList());
		return "main/main";
	}
}
