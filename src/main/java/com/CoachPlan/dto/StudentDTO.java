package com.CoachPlan.dto;

public class StudentDTO {
	
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

}
