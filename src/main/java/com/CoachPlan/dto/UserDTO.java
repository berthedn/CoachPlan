package com.CoachPlan.dto;

public class UserDTO {

	private String title;
	private String email;
	private String name;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String title, String email, String name) {
		this.title = title;
		this.email = email;
		this.name = name;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
