package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{

	 
	

}
