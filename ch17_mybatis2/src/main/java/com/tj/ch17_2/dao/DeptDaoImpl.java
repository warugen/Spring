package com.tj.ch17_2.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch17_2.dto.Dept;
// dao 메모리에 올려놓으라는 어노테이션
@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}
