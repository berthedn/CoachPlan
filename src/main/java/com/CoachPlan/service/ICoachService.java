package com.CoachPlan.service;

import com.CoachPlan.dto.CoachDTO;


public interface ICoachService {
	
	public CoachDTO loginByID(String Id);
	
	public CoachDTO loginByPass(String password);

}
