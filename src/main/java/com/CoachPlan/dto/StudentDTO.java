package com.CoachPlan.dto;

import java.util.ArrayList;

public class StudentDTO {
	
	private String loginID;
	//TODO what other fields should a student have? Password field as well? 
	private String id; // foreign key for Student to coach
	private String firstName;
	private String lastName;
	private int workoutId; //primary key for connecting Student to workout
	private ArrayList<WorkoutDTO> schedule;
	
	
	public StudentDTO() {
		this.schedule = new ArrayList<WorkoutDTO>();
	}
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
