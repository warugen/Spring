package com.tj.ex5Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentInfo {
	@Autowired	// setter가 없어도 자동으로 ctx.xml에 값을 세팅해준다.
	private Student student;

	// setter가 필요하면 set함수 윗줄에 @Autowired를 선언한다.
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	public Student getStudent() {
		return student;
	}

	
	
}
