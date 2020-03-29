package com.CoachPlan.dto;

public class UserDTO {

	private String title;
	private String email;
	private String name;
	private String password;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String title, String email, String name, String password) {
		this.title = title;
		this.email = email;
		this.name = name;
		this.password = password;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
