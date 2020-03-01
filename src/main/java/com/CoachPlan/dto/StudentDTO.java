package com.CoachPlan.dto;


public class StudentDTO {
	
	private String loginID;
	public String fullName;
	public String Position;
	public String Sport;
	//TODO what other fields should a student have? Password field as well? 
	
	public String getPosition() {
		return this.Position;
	}
	
	public void setName(String name) {
		this.fullName = name;
	}
	
	public String getName() {
		return this.fullName;
	}
	
	public String getLoginID() {
		return this.loginID;
	}

}
