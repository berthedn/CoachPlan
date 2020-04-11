package com.CoachPlan.dto;

public abstract class User {


	private String title;
	private String email;
	private String userName;
	private String password;
	private String coachId;

		
	public User(String title, String email, String userName, String password, String coachId) {
			this.email = email;
			this.userName = userName;
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

	public String getUserName() {
			return this.userName;
	}

	public void setUserName(String name) {
			this.userName = name;
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
