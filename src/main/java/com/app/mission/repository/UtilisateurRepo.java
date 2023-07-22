package com.app.mission.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.User;

@Repository
public interface UtilisateurRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String name);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
