package com.tj.ex3;

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
		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("ip 번호 : " + serverInfo.getIpNum());
		System.out.println("port 번호 : " + serverInfo.getPortNum());
		
		ctx.close();
		
	}
}
