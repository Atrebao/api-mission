package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Obstacle;
import com.app.mission.repository.ObstaclesRepo;

import lombok.Data;

@Data
@Service
public class ObstacleService {
	@Autowired
	private ObstaclesRepo obstaclesRepo;
	
	public Optional<Obstacle> getObstacle(final Long id) {
		return obstaclesRepo.findById(id);
	}
	
	public Iterable<Obstacle> getObstacles(){
		return obstaclesRepo.findAll();
	}
	
	public void deleteObstacle(final Long id) {
		obstaclesRepo.deleteById(id);
	}
	
	public Obstacle addObstacle(Obstacle obstacles) {
		return obstaclesRepo.save(obstacles);
	}
	
	public Obstacle updateEquipement(Obstacle obstacles) {
		return obstaclesRepo.save(obstacles);
	}

}
