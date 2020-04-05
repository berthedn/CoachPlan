package com.CoachPlan.dto;

public class CoachDTO {
	
	private String loginID;
	private String loginPass;
	
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public void setLoginPass(String password) {
		this.loginPass = password;
	}
	
	public String getLoginID() {
		return this.loginID;
	}
	
	public String getLoginPass() {
		return this.loginPass;
	}
	
	//overriding to string method so that we can display the login ID of coach in login page
	@Override
	public String toString() {
		return loginID;
	}

}
