package com.CoachPlan.service;

import org.springframework.stereotype.Component;

import com.CoachPlan.dto.CoachDTO;

@Component
public class CoachServiceStub implements ICoachService {

	@Override
	public CoachDTO loginByID(String Id) {
		CoachDTO coachDTO = new CoachDTO();
		coachDTO.setLoginID(Id);
		return coachDTO;
	}

}
