package com.app.mission.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Fonction;

@Repository
public interface FonctionRepo extends JpaRepository<Fonction, Long>{
	
	Optional<Fonction> findByNom(String nom);

}
