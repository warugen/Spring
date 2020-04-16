package com.tj.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
//		Calculation calculation = new Calculation();
//		calculation.setNum1(10);
//		calculation.setNum2(20);
		
		// 스프링 컨테이너를 생성하여 xml설정파일을 파싱
//		String resourceLocation = "applicationCTX.xml";
		String resourceLocation = "classpath:applicationCTX.xml";	// 앞에 classpath:를 붙이면 자동으로 resources밑에 있는 경로로 지정된다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationCTX.xml");
		Calculation calculation = ctx.getBean("calculation", Calculation.class); // applicationCTX.xml안에 있는 bean id를 적어준다.
		
		calculation.add();
		calculation.sub();
		calculation.multiple();
		calculation.div();
		
		ctx.close(); // 스프링 컨테이너 안의 빈객체 제거, 스프링 컨테이너도 제거
	}
}
