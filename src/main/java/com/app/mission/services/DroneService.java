package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Drone;
import com.app.mission.repository.DroneRepo;

import lombok.Data;

@Data
@Service
public class DroneService {
	@Autowired
	private DroneRepo droneRepo;
	
	public Optional<Drone> getDroneById(final Long id) {
		return droneRepo.findById(id);
	}
	
	public Iterable<Drone> getAllDrones(){
		return droneRepo.findAll();
	}
	
	public void deleteDroneById(final Long id) {
		droneRepo.deleteById(id);
	}
	
	public Drone addDrone(Drone drone) {
		return droneRepo.save(drone);
	}
	
	public Drone updateDrone(Drone drone) {
		return droneRepo.save(drone);
	}
}
