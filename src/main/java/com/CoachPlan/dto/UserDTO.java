package com.CoachPlan.dto;

public class UserDTO {
	
	private int ID;
	private String email;
	private String name;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(int ID, String email, String name) {
		this.ID = ID;
		this.email = email;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
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
