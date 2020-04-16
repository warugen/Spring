package com.tj.ex5Autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:ex5/applicationCTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		
		System.out.println(studentInfo.getStudent());
		ctx.close();
	}
}
