package com.xebia.table_tennis.converter;

import com.xebia.table_tennis.data.request.ParticipateRequest;
import com.xebia.table_tennis.pojo.Participate;

public class EntityConverter {
	
	public static Participate from(ParticipateRequest participateRequest) {
		Participate participate = new Participate();
		participate.setFirstName(participateRequest.getFirstName());
		participate.setLastName(participateRequest.getLastName());
		participate.setTeamName(participateRequest.getTeamName());
		return participate;
	}

}
