package com.tj.ch12.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);	// 검증할 객체를 명시
	}

	@Override
	public void validate(Object target, Errors errors) {	// 검증하는 메소드
		// controller에서 validator.validate(student, errors) 요청
		String name = ((Student)target).getName();
		int id = ((Student)target).getId();
		/*
		if(name == null || name.trim().isEmpty()) {
			System.out.println("name이 비어서 검증 불가");
			errors.rejectValue("name", "no");
		}
		*/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");
		
		if(id <=0) {
			System.out.println("id가 자연수가 아니여서 검증불가");
			errors.rejectValue("id", "no");
		}
	}

}
