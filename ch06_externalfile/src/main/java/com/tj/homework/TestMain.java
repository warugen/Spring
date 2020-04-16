package com.tj.homework;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("dev? run?");
		config = sc.next();
		if(!config.equals("dev")) {
			config = "run";
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:homework/dev.xml", "classpath:homework/run.xml");
		ctx.refresh();
		EnvInfo envInfo = ctx.getBean("envInfo", EnvInfo.class);
		
		System.out.println("ipNum : " + envInfo.getIpNum());
		System.out.println("portNum : " + envInfo.getPortNum());
		System.out.println("userId : " + envInfo.getUserId());
		System.out.println("userPw : " + envInfo.getUserPw());
		
		ctx.close();
	}
}
