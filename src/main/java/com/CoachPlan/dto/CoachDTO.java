package com.CoachPlan.dto;

public class CoachDTO {
	
	private String loginID;
	//TODO what other fields should a coach DTO have? Should we have a password field?  
	
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
	}
	
	//overriding to string method so that we can display the login ID of coach in login page
	@Override
	public String toString() {
		return loginID;
	}

}
