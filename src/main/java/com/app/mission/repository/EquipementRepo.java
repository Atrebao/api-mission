package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Equipement;

@Repository
public interface EquipementRepo extends JpaRepository<Equipement, Long>{
	


}
