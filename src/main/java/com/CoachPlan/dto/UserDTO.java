package com.CoachPlan.dto;

public class UserDTO {
	
	private int ID;
	private String name;
	private String title;
	
	public UserDTO() {
		
	}
	
	public UserDTO(int IDIn, String nameIn, String titleIn) {
		super();
		ID = IDIn;
		name = nameIn;
		title = titleIn;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
