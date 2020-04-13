package com.CoachPlan.dto;

import java.util.ArrayList;

public class CoachDTO extends User implements IData {
	
	private ArrayList<StudentDTO> studentList;
	
	
	public CoachDTO(String title, String email, String firstName, String password, String coachId) {
		super(title, email, firstName, password, coachId);
		
		studentList = new ArrayList<StudentDTO>();
	}
	
	public CoachDTO(String email) {
		super(email);
	}
	
	public CoachDTO(String email, String userName, String password, String coachId) {
		super(email, userName, password, coachId);
	}

	
	//overriding to string method so that we can display the login ID of coach in login page
	@Override
	public String toString() {
		
		return this.getUserName();
	}
	
	public void setStudentList(ArrayList<StudentDTO> list) {
		studentList = new ArrayList<StudentDTO>();
		this.studentList = list;
	}
	
	public ArrayList<StudentDTO> getStudentList(){
		return this.studentList;
	}

}
