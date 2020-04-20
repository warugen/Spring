package com.tj.kakao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping(params="method=login")
	public String login(Model model) {
		
		return "login/login";
	}
	
	@RequestMapping(params="method=glogin")
	public String glogin(Model model) {
		
		return "login/glogin";
	}
}
