package com.app.mission.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Obstacles;

@Repository
public interface ObstaclesRepo extends JpaRepository<Obstacles, Long>{
	

}
