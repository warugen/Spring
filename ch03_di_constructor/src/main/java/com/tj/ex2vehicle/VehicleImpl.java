package com.tj.ex2vehicle;

public class VehicleImpl implements Vehicle {
	private String vehicle;	// 탈것
	private int speed;	// 속도
	
	@Override
	public void ride(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + "은 " + vehicle + "을(를) " + speed + "km/h 속도로 간다.");
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}
