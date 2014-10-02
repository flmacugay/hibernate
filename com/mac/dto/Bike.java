package com.mac.dto;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("B")
public class Bike extends Vehicle {
	
	private String steeringHandle;
	
	public Bike() {
		super();
	}
	public Bike(String steeringHandle) {
		super();
		this.steeringHandle = steeringHandle;
	}
	public Bike(String make, String model, String type) {
		super(make, model, type);
		// TODO Auto-generated constructor stub
	}

	public String getSteeringHandle() {
		return steeringHandle;
	}
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	@Override
	public void steerVehicle() {
		System.out.println("Using steering handle");

	}

}
