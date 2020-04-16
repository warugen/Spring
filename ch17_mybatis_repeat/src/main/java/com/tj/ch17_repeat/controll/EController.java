package com.tj.ch17_repeat.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch17_repeat.dto.Dept;
import com.tj.ch17_repeat.dto.Emp;
import com.tj.ch17_repeat.service.EmpService;

@Controller
public class EController {
	@Autowired
	private EmpService service;
	/*
	@ModelAttribute("deptList")
	public List<Dept> deptList() {
		return service.deptList();
	}
	*/
	@RequestMapping(value="emp", method= RequestMethod.GET)
	public String emp(@ModelAttribute("searchEmp") Emp searchEmp, Model model) {
		model.addAttribute("empList", service.empList(searchEmp));
		model.addAttribute("deptList", service.deptList());
		return "emp";
	}
}
