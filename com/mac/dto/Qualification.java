package com.mac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Qualification {

	@Id
	@Column(name="QUAL_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", allocationSize=1, sequenceName="SEQ_QUAL")
	private int id;
	private String course;
	private String school;
	@OneToOne
	@JoinColumn(name="USER_ID")
	private UserDetails userDetails;
	
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualification(String course, String school) {
		super();
		this.course = course;
		this.school = school;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	
}
