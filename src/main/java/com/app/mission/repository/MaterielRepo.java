package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Materiel;

@Repository
public interface MaterielRepo extends JpaRepository<Materiel, Long>{
	

}
