package com.tj.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProxyClass {
	/*
	@Pointcut("within(com.tj.ex2.*)")
	private void aroundM() {}
	@Around("aroundM")
	*/
	// 윗 3줄을 1줄로 처리
	@Around("within(com.tj.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★★★★★★ 공통기능 around Advice 시작 ★★★★★★");
		String signatureName = joinPoint.getSignature().toShortString();
		System.out.println(signatureName + "기능 시작");
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			System.out.println(signatureName + "기능 종료");
		}
	}

	@Before("within(com.tj.ex2.Worker2)")
	public void beforeAdvice() {
		System.out.println("핵심기능 수행 전 Advice()");
	}
	
	@After("execution(* com.tj.ex2.Student2.*())")	// execution다음에 *을 붙이면 모든 리턴타입이라는 뜻
	public void afterAdvice() {
		System.out.println("핵심기능 수행 한 후 Advice()");
	}
	
	@AfterThrowing("within(com.tj.ex2.Student2)")
	public void afterThrowing() {
		System.out.println("핵심기능 수행후 afterAdvice()");
	}
	
	@AfterReturning("execution(public void com.tj.ex2.Student2.getStudentInfo())")
	public void afterReturning() {
		System.out.println("예외가 발생되지 않는 핵심기능 수행후 afterReturnin()");
	}
	
	
	
	
	
	
	
}
