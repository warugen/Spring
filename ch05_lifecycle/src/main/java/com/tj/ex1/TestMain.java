package com.tj.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성(환경설정)
		ctx.load("classpath:applicationCTX.xml");	// 파싱
		ctx.refresh();   	// 빈생성
		Student student = ctx.getBean("student", Student.class);
		OtherStudent otherstudent = ctx.getBean("otherstudent", OtherStudent.class);
		
		System.out.println("student : " + student);
		System.out.println("otherstudent : " + otherstudent);
		
		ctx.close();	// 빈소멸, 컨테이너 소멸
		
	}
}
