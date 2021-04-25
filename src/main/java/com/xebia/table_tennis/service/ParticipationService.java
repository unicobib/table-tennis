package com.xebia.table_tennis.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.xebia.table_tennis.data.request.ParticipateRequest;
import com.xebia.table_tennis.pojo.Participate;

public interface ParticipationService {

	List<Participate> getAllParticipate();

	void register(ParticipateRequest participate) throws SQLIntegrityConstraintViolationException;
}
