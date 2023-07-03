package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Obstacles;
import com.app.mission.repository.ObstaclesRepo;

import lombok.Data;

@Data
@Service
public class ObstacleService {
	@Autowired
	private ObstaclesRepo obstaclesRepo;
	
	public Optional<Obstacles> getObstacle(final Long id) {
		return obstaclesRepo.findById(id);
	}
	
	public Iterable<Obstacles> getObstacles(){
		return obstaclesRepo.findAll();
	}
	
	public void deleteObstacle(final Long id) {
		obstaclesRepo.deleteById(id);
	}
	
	public Obstacles addObstacle(Obstacles obstacles) {
		return obstaclesRepo.save(obstacles);
	}
	
	public Obstacles updateEquipement(Obstacles obstacles) {
		return obstaclesRepo.save(obstacles);
	}

}
