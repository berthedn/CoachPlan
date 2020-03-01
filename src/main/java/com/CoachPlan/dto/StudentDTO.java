package com.CoachPlan.dto;

public class StudentDTO {
	
	private String loginID;
	//TODO what other fields should a student have? Password field as well? 
	public String firstName;
	public String preferredName;
	public String lastName;
	public String fullName;
	
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
	}
	
	public void setfirstName(String fName) {
		this.firstName=fName;
	}
	
	public String getfirstName() {
		return this.firstName;
	}
	
	public void setpreferredName(String pName) {
		this.preferredName=pName;
	}
	
	public String getpreferredName() {
		return this.preferredName;
	}
	
	public void setlastName(String lName) {
		this.lastName=lName;
	}
	
	public String getlastName() {
		return this.lastName;
	}
	
	public void setfullName(String FullName) {
		if (preferredName !=""){
				FullName = preferredName + " " + lastName;
		}
		else {
			FullName = firstName + " " + lastName;
		}
		this.fullName=FullName;
	}

}
