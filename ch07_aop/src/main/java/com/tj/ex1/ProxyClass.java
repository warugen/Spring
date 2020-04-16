package com.tj.ex1;

import org.aspectj.lang.ProceedingJoinPoint;

public class ProxyClass {
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable { // joinPoint : 핵심기능
		// aroundAdvice : 핵심기능 전후로 공통기능 수행
		System.out.println("★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toShortString();	// 핵심기능 메소드명
		System.out.println(signatureName + "가 시작되었습니다.");
		long startTime = System.currentTimeMillis();	// 시작시점
		try {
			Object obj = joinPoint.proceed();// 핵심기능 수행해라
			return obj;
		} finally {
			long endTime = System.currentTimeMillis();	// 핵심기능 수행후 시검
			System.out.println(signatureName + "가 수행끝났습니다. 경과시간 : " +(endTime - startTime));
		}	
	}
	
	public void beforeAdvice() {
		System.out.println("공통기능 수행하고 알아서 핵심기능 수행하고 끝");
	}
	
	public void afterAdvice() {
		System.out.println("핵심기능 수행 후 이 공통기능 수행");
	}
	
	public void afterReturningAdvice() {
		System.out.println("정상적으로 핵심기능이 수행된 후 공통기능 수행");
	}
	
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 공통기능 수행");
	}
}
