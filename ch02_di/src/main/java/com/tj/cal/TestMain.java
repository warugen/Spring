package com.tj.cal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
//		MyCalculator myCal = new MyCalculator();
//		myCal.setCal(new Calculator());
//		myCal.setNum1(10);
//		myCal.setNum2(5);
		
		String resourceLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		
		MyCalculator myCal = ctx.getBean("myCal", MyCalculator.class);
		
		myCal.add();
		myCal.sub();
		myCal.multiple();
		myCal.div();
		
		ctx.close();
	}
}
