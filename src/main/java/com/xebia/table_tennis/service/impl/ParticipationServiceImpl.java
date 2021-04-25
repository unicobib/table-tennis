package com.xebia.table_tennis.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.table_tennis.converter.EntityConverter;
import com.xebia.table_tennis.data.request.ParticipateRequest;
import com.xebia.table_tennis.pojo.Participate;
import com.xebia.table_tennis.service.ParticipationService;
import com.xebia.table_tennis.service.repository.ParticipateRepository;

@Service
public class ParticipationServiceImpl implements ParticipationService {

	@Autowired
	private ParticipateRepository participateRepo;
	
	public List<Participate> getAllParticipate() {
		return (List<Participate>) participateRepo.findAll();
	}

	@Override
	public void register(ParticipateRequest participateRequest) throws SQLIntegrityConstraintViolationException{
		Participate participate = EntityConverter.from(participateRequest);
		participateRepo.save(participate);
		
	}

}
