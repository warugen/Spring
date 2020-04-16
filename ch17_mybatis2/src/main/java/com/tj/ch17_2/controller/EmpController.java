package com.tj.ch17_2.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.service.EmpService;
import com.tj.ch17_2.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String list(String pageNum, Model model, Emp emp) {
		Paging paging = new Paging(empService.total(), pageNum, 10, 10);
		//Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.empList(emp));
		
		return "list";
	}
	
	@RequestMapping(value="joinlist", method=RequestMethod.GET)
	public String joinList(String pageNum, Model model) {
		Paging paging = new Paging(empService.total(), pageNum, 10, 10);
		model.addAttribute("paging", paging);
		model.addAttribute("joinlist", empService.empDeptList(pageNum));
		
		return "joinlist";
	}
	
	@RequestMapping(value="joinlist", method=RequestMethod.POST)
	public String joinListpost(String pageNum, Model model) {
		Paging paging = new Paging(empService.total(), pageNum, 10, 10);
		model.addAttribute("paging", paging);
		model.addAttribute("joinlist", empService.empDeptList(pageNum));
		
		return "joinlist";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
//	public String detail(String pageNum, Model model, int empno) {
	public String detail(Model model, int empno) {
		model.addAttribute("detail", empService.detail(empno));
		return "detail";
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
//	public String updateForm(String pageNum, Model model, int empno) {
	public String updateForm(Model model, int empno) {
		model.addAttribute("updateForm", empService.detail(empno));
		return "updateForm";
	}
	
	@RequestMapping(value="updateForm", method=RequestMethod.POST)
	public String updateFormpost(Model model, int empno) {
		model.addAttribute("updateForm", empService.detail(empno));
		return "updateForm";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Model model, Emp emp, String tempHiredate) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			empService.empUpdate(emp);
		} catch (Exception e) {
			model.addAttribute("updateResult", "수정실패");
			System.out.println("수정실패");
			return "forward:updateForm.do";
		}
		
		return "forward:joinlist.do";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int empno) {
		empService.empDelete(empno);
		return "forward:joinlist.do";
	}
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "writeForm";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			empService.empInsert(emp);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("writeResult", "등록실패");
			return "forward:writeFrom.do";
		}
		return "redirect:joinlist.do";
	}
	
	@RequestMapping(value="confirmNo", method=RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(empService.detail(empno) == null) {
			model.addAttribute("msg", "사용가능한 사번입니다.");
		} else {
			model.addAttribute("msg", "사용불가능한 사번입니다.");
		}
		return "forward:writeForm.do";
	}
	
	
	
	@RequestMapping(value="dummyinsert", method=RequestMethod.GET)
	public String dummyinsert() {
		empService.insert50();
		return "redirect:joinlist.do";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
