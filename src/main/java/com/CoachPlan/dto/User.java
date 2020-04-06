package com.CoachPlan.dto;

public abstract class User {


	private String title;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String loginId;

		
	public User(String loginId, String email, String fName, String lName, String password) {
			this.email = email;
			this.firstName = fName;
			this.lastName = lName;
			this.password = password;
			this.loginId = loginId;
	}

	public String getTitle() {
			return title;
	}
		
	public void setTitle(String title) {
			this.title = title;
	}

	public String getFirstName() {
			return this.firstName;
	}

	public void setFirstName(String name) {
			this.firstName = name;
	}
		
	public String getLastName() {
			return this.lastName;
	}
		
	public void setLastName(String name) {
			this.lastName = name;
	}

	public String getEmail() {
			return email;
	}

	public void setEmail(String email) {
			this.email = email;
	}
		
	public String getPassword() {
			return password;
	}

	public void setPassword(String password) {
			this.password = password;
	}
		
	public void setLoginID(String login) {
			this.loginId = login;
	}
		
	public String getLoginID() {
			return this.loginId;
	}
	

}
