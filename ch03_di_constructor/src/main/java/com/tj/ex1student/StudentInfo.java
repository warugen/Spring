package com.tj.ex1student;

public class StudentInfo {
	private Student student;

	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void print() {
		// 외부에서 쓸 메소드
		if(student != null) {
			System.out.println("이름 : " + student.getName());			
			System.out.println("나이 : " + student.getAge());			
			System.out.println("학년 : " + student.getGradeNum());			
			System.out.println("반 : " + student.getClassNum());
			System.out.println("=======================================================");
		} else {
			System.out.println("학생 정보가 참조되지 않았습니다.");
		}
	}

	public Student getStudent() {
		return student;
	}
	
	
}
