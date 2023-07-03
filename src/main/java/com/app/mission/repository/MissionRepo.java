package com.app.mission.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Mission;

@Repository
public interface MissionRepo extends CrudRepository<Mission, Long>{

 	
	
}
