package com.mac.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("C")
public class Car extends Vehicle {
	
	private String steeringWheel;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String steeringWheel) {
		super();
		this.steeringWheel = steeringWheel;
	}
	

	public Car(String make, String model, String type) {
		super(make, model, type);
		// TODO Auto-generated constructor stub
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	@Override
	public void steerVehicle() {
		System.out.println("Using steering wheel");
	}
	
}
