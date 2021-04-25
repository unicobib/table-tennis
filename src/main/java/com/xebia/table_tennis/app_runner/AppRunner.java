package com.xebia.table_tennis.app_runner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xebia.table_tennis.pojo.Group;
import com.xebia.table_tennis.pojo.Match;
//import com.xebia.table_tennis.pojo.Group;
import com.xebia.table_tennis.pojo.Participate;
import com.xebia.table_tennis.service.repository.GroupRepository;
import com.xebia.table_tennis.service.repository.MatchRepository;
import com.xebia.table_tennis.service.repository.ParticipateRepository;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	private ParticipateRepository repo;

	@Autowired
	private GroupRepository groupRepo;
	
	@Autowired
	private MatchRepository matchRepo;

	@Override
	public void run(String... args) throws Exception {
		try {
			Group g1 = new Group();
			g1.setGroupName("Tiger"); 
			groupRepo.save(g1);

			Participate p1 = new Participate();
			p1.setFirstName("Bibek");
			p1.setLastName("Dey");
			p1.setTeamName("Finance");
			p1.setGroups(g1);

			repo.save(p1);
			
			Participate p2 = new Participate();
			p2.setFirstName("Sujan");
			p2.setLastName("Dey");
			p2.setTeamName("Finance");
			p2.setGroups(g1);

			repo.save(p2);
			
			Match m1 = new Match();
			m1.setStartTime(new Date());
			m1.setPlayer_1(p1);
			m1.setPlayer_2(p2);
			matchRepo.save(m1);
			
		} catch ( Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
