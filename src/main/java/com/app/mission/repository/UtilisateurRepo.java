package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long>{

}
