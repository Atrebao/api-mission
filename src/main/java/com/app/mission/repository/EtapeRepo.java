package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Etape;

@Repository
public interface EtapeRepo extends JpaRepository<Etape, Long>{

}
