package com.CoachPlan.dto;

public class CoachDTO {
	
	private String loginID;
	private String fullName;
	private String Sport;
	//TODO what other fields should a coach DTO have? Should we have a password field?  
	
	public void setName(String name) {
		this.fullName = name;
	}
	
	public String getName() {
		return this.fullName;
	}
	
	public void setSport(String sport) {
		this.Sport = sport;
	}
	
	public String getSport() {
		return this.Sport;
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
