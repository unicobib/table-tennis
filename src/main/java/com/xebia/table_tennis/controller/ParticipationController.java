package com.xebia.table_tennis.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.table_tennis.data.request.ParticipateRequest;
import com.xebia.table_tennis.data.response.BaseResponse;
import com.xebia.table_tennis.exceptions.ApiException;
import com.xebia.table_tennis.pojo.Participate;
import com.xebia.table_tennis.service.ParticipationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/table-tennis/")
@Slf4j
public class ParticipationController {

	@Autowired
	private ParticipationService participationService;


	@RequestMapping(value = "/participates", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity getAllParticipates() {

		List<Participate> participates = participationService.getAllParticipate();

		return new ResponseEntity(participates, HttpStatus.OK);
	}

	@RequestMapping(value = "/participate", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public BaseResponse registration(@RequestBody ParticipateRequest participate) {

		try {
			participationService.register(participate);
			return new BaseResponse(200, HttpStatus.CREATED.toString());
		} catch (SQLIntegrityConstraintViolationException e) {
			log.warn("Participate Already registered");
			throw new RuntimeException("You are already registered");
		} catch(Exception e) {
			log.error("Failed to register participate", e.getCause());
			throw new ApiException("Failed to register participate", e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
