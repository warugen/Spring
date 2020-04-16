package com.tj.ex4Java_xml;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.tj.ex1xml.Student;

@Configuration
@ImportResource("ex4/applicationCTX.xml")
public class ApplicationConfig {
	@Bean
	public Student student1() {
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("요가");
		hobbies.add("먹방");
		
		Student student = new Student("또경영", 60, hobbies);
		student.setHeight(178);
		student.setWeight(80);
		
		return student;
	}
	
	
}
