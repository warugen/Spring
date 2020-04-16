package com.tj.ch17_2.service;

import java.util.List;

import com.tj.ch17_2.dto.Dept;
import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp emp);	// paging은 controller에서처리
	
	public int total();
	
	public Emp detail(int empno);
	
	public List<Emp> managerList();
	
	public int empInsert(Emp emp);
	
	public int empUpdate(Emp emp);
	
	public int empDelete(int empno);
	
	public List<EmpDept> empDeptList(String pageNum);	// paging처리 service단에서
	
	public void insert50();
	
}
