package com.tj.ex2java;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tj.ex1xml.Student;

//설정파일이라고 명시하는 어노테이션을 선언한다.
@Configuration	
public class ApplicationConfig {
	@Bean
	public Student student1() {	// applicationCTX의 Bean id 와 같은 이름으로 함수생성
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("먹방");
		hobbies.add("운동");
		
		Student student = new Student("홍길동", 30, hobbies);
		student.setHeight(180);
		student.setWeight(90);
		
		return student;
	}
	
	@Bean
	public Student student2() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("잠자기");
		
		Student student = new Student("고길동", 20, hobbies);
		student.setHeight(200);
		student.setWeight(80);
		
		return student;
	}
}
