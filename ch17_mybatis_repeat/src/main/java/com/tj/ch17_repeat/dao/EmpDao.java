package com.tj.ch17_repeat.dao;

import java.util.List;

import com.tj.ch17_repeat.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp searchEmp);
}
