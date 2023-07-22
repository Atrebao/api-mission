package com.app.mission.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Obstacle;

@Repository
public interface ObstaclesRepo extends JpaRepository<Obstacle, Long>{
	
	
}