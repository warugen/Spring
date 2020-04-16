package com.tj.ex2vehicle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:applicationCTX1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		Vehicle vh = ctx.getBean("vh", Vehicle.class);
		vh.ride("홍길동");
		
		ctx.close();
	}
}
