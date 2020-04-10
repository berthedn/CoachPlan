package com.CoachPlan.dto;

import java.util.ArrayList;

public class CoachDTO extends User implements IData {
	
	private String id; // use this as a primary key? 
	private ArrayList<StudentDTO> studentList;
	
	
	public CoachDTO(String title, String email, String firstName, String password, String coachId) {
		super(title, email, firstName, password, coachId);
		
		studentList = new ArrayList<StudentDTO>();
	}

	
	//overriding to string method so that we can display the login ID of coach in login page
	@Override
	public String toString() {
		String data = "";
		for(StudentDTO student: this.studentList) {
			data += student.toString() + " ";
		}
		return data;
	}
	
	public void setStudentList(ArrayList<StudentDTO> list) {
		studentList = new ArrayList<StudentDTO>();
		this.studentList = list;
	}
	
	public ArrayList<StudentDTO> getStudentList(){
		return this.studentList;
	}

}
