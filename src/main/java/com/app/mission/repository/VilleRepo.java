package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Ville;

@Repository
public interface VilleRepo extends JpaRepository<Ville, Long>{

}
