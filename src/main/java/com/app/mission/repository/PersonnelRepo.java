package com.app.mission.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Personnel;

@Repository
public interface PersonnelRepo extends JpaRepository<Personnel, Long>{
	
	

}
