package com.tj.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student2 student = ctx.getBean("student2", Student2.class);
		Worker2 worker = ctx.getBean("worker2", Worker2.class);
		
		student.getStudentInfo();
		worker.getWorkerInfo();
		
		ctx.close();
	}
}
