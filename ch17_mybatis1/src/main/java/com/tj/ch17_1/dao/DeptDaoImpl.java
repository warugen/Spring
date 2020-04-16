package com.tj.ch17_1.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tj.ch17_1.dto.Dept;

@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
//	private SqlSessionTemplate sessionTemplate;
	private SqlSession sessionTemplate;		// SqlSessionTemplate의 부모클래스로 선언해도 무방하다
	@Override
	public List<Dept> deptList() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("deptList");
	}
}
