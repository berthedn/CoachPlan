package com.CoachPlan.dto;

public class LoginDTO {
	private String loginID;
	private String password;
	private String userType;
	//userType refers to coach or student
	//TODO what other fields should a coach DTO have? Should we have a password field?  
	
	
	public void login(String loginID, String password, String userType) {
		this.loginID = loginID;
		this.password = password;
		this.userType = userType;
	}
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
	}
	
	public String changePassword(String oldPassword, String newPassword) {
		if(oldPassword == this.password) {
			this.password = newPassword;
			return this.password;
		}
		return "Password could not be changed.";
	}
	
}
