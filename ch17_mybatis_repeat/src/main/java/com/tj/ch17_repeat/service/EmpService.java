package com.tj.ch17_repeat.service;

import java.util.List;

import com.tj.ch17_repeat.dto.Dept;
import com.tj.ch17_repeat.dto.Emp;

public interface EmpService {
	public List<Emp> empList(Emp searchEmp);
	public List<Dept> deptList();
}
