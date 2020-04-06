package com.CoachPlan.dto;

import java.util.ArrayList;

public class CoachDTO {
	
	private String loginID;
	//TODO what other fields should a coach DTO have? Should we have a password field?  
	private String id; // use this as a primary key? 
	private ArrayList<StudentDTO> studentList;
	
	
	//TODO using this for test only, DELETE AFTERWARDS
	public CoachDTO() {
		this.studentList = new ArrayList<StudentDTO>();
		StudentDTO student1 = new StudentDTO();
		StudentDTO student2 = new StudentDTO();
		StudentDTO student3 = new StudentDTO();
		
		student1.setFirstName("Eder");
		student1.setLastName("Aguilar");
		
		student2.setFirstName("Turin");
		student2.setLastName("Auguste");
		
		student3.setFirstName("Damien");
		student3.setLastName("Berthenet");
		
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);

	}
	
	public void setLoginID(String login) {
		this.loginID = login;
	}
	
	public String getLoginID() {
		return this.loginID;
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
