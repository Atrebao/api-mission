package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Fonction;

@Repository
public interface FonctionRepo extends JpaRepository<Fonction, Long>{

}
