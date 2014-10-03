package com.mac.dto;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="VEHICLE")
//@DiscriminatorColumn(name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.CHAR)
//@DiscriminatorValue("V")
@Inheritance(strategy=InheritanceType.JOINED)
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public abstract class Vehicle {
	
	@Id
	@Column(name="VEHICLE_ID")
	@GeneratedValue(generator="gen", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="gen", allocationSize=1, sequenceName="SEQ_VEHICLE")
	private int id;
	private String make;
	private String model;
	private String type;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails userDetails;
	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vehicle(String make, String model, String type) {
		super();
		this.make = make;
		this.model = model;
		this.type = type;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public int getId() {
		return id;
	}

	public abstract void steerVehicle();
	
}
