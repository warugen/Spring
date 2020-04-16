package com.tj.ch17_repeat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.ch17_repeat.dao.DeptDao;
import com.tj.ch17_repeat.dao.EmpDao;
import com.tj.ch17_repeat.dto.Dept;
import com.tj.ch17_repeat.dto.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpDao eDao;
	@Autowired
	private DeptDao dDao;
	@Override
	public List<Emp> empList(Emp searchEmp) {
		if(searchEmp.getEname()!=null) {
			searchEmp.setEname(searchEmp.getEname().toUpperCase());
		}
		if(searchEmp.getJob()!=null) {
			searchEmp.setJob(searchEmp.getJob().toUpperCase());
		}
		return eDao.empList(searchEmp);
	}

	@Override
	public List<Dept> deptList() {
		return dDao.deptList();
	}

}
