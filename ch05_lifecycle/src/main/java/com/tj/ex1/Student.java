package com.tj.ex1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class Student implements InitializingBean, DisposableBean, EnvironmentAware {
	private String name;
	private int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" 2. Student 빈 객체 생성함. 초기화 작업은 여기서");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(" 3. 이제 Student 빈객체는 소멸된다. 마무리 작업은 여기서");
		
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.out.println(" 1. Student 빈이 생성되기 바로 직전에 수행");
		
	}
	
	
}
