package com.tj.cal;

public class MyCalculator {
	private int num1;
	private int num2;
	private Calculator cal;
	
	public void add() {
		cal.addition(num1, num2);
	}
	
	public void sub() {
		cal.subtraction(num1, num2);
	}
	
	public void multiple() {
		cal.multiplcation(num1, num2);
	}
	
	public void div() {
		cal.division(num1, num2);
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public Calculator getCal() {
		return cal;
	}

	public void setCal(Calculator cal) {
		this.cal = cal;
	}
	
	
}
