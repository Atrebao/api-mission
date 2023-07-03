package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.PieceJointe;

@Repository
public interface PieceJointeRepo extends JpaRepository<PieceJointe, Long>{

}
