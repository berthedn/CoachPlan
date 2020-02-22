package com.CoachPlan.dto;

public class StudentDTO {
	
	private String loginID;
	//TODO what other fields should a student have? Password field as well? 
	
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
	}

}
