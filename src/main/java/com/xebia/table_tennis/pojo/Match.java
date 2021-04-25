package com.xebia.table_tennis.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xebia.table_tennis.enums.MatchResult;

import lombok.Data;

@Data
@Entity
@Table(name = "match")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Participate player_1;
	
	@ManyToOne
	private Participate player_2;
	
	private Date startTime;
	
	private Date endTime;
	
	private MatchResult matchResult;
	
	private String comments;
	
}
