package com.tj.ex1;
import javax.annotation.*;
public class OtherStudent {
	private String name;
	private int age;
	public OtherStudent(String name, int age) {
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
	
	@PostConstruct
	public void init() {
		System.out.println("★★ OtherStudent 빈객체 막 생성함 ★★");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("★★ OtherStudent 빈객체 막 소멸할 것임 ★★");
	}
}
