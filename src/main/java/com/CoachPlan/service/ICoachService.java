package com.CoachPlan.service;

import com.CoachPlan.dto.CoachDTO;


public interface ICoachService {
	
	//TODO this needs to have a password field as well, we want to login with username and password
	public CoachDTO loginByID(String Id);

}
