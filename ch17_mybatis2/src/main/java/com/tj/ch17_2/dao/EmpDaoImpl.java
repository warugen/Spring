package com.tj.ch17_2.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch17_2.dto.Emp;
import com.tj.ch17_2.dto.EmpDept;
@Repository
public class EmpDaoImpl implements EmpDao {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List<Emp> empList(Emp emp) {
		return sessionTemplate.selectList("empList", emp);
	}

	@Override
	public int total() {
		return sessionTemplate.selectOne("total");
	}

	@Override
	public Emp detail(int empno) {
		return sessionTemplate.selectOne("detail", empno);
	}

	@Override
	public List<Emp> managerList() {
		return sessionTemplate.selectList("managerList");
	}

	@Override
	public int empInsert(Emp emp) {
		return sessionTemplate.insert("empInsert", emp);
	}

	@Override
	public int empUpdate(Emp emp) {
		return sessionTemplate.update("empUpdate", emp);
	}

	@Override
	public int empDelete(int empno) {
		return sessionTemplate.delete("empDelete", empno);
	}

	@Override
	public List<EmpDept> empDeptList(EmpDept empDept) {
		return sessionTemplate.selectList("empDeptList", empDept);
	}

}
