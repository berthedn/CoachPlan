package com.CoachPlan.dto;

public abstract class User {


	private String title;
	private String email;
	private String firstName;
	private String password;
	private String coachId;

		
	public User(String title, String email, String fName, String password, String coachId) {
			this.email = email;
			this.firstName = fName;
			this.password = password;
			this.title = title;
			this.coachId = coachId;
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
		
	public void setCoachID(String coach) {
			this.coachId = coach;
	}
		
	public String getCoachID() {
			return this.coachId;
	}
	

}
