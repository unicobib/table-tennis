package com.xebia.table_tennis.service.repository;

import org.springframework.data.repository.CrudRepository;

import com.xebia.table_tennis.pojo.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

}
