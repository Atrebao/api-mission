package com.app.mission.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mission.model.Drone;
import com.app.mission.services.DroneService;

@RestController
@RequestMapping("/api/drone")
public class DroneController {
		
	
	   @Autowired
	   private DroneService droneService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Drone> addDrone(@RequestBody Drone drone) {
	       Drone newDrone = droneService.addDrone(drone);
	       return new ResponseEntity<>(newDrone, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Drone updateDroneById(@PathVariable("id") final Long id, @RequestBody Drone drone) {
			Optional<Drone> e = droneService.getDroneById(id);
			if(e.isPresent()) {
				Drone currentDrone = e.get();
				
				currentDrone.setCategotie(drone.getCategotie());
				currentDrone.setCondition_vent_critique(drone.getCondition_vent_critique());
				currentDrone.setStatut(drone.getStatut());
				currentDrone.setReference(drone.getReference());
				currentDrone.setType(drone.getType());
				

				droneService.addDrone(currentDrone);
				
				
				return currentDrone;
			} else {
				return null;
			}
		}

		@GetMapping("/drones")
		public Iterable<Drone> getAllDrones() {
			return droneService.getAllDrones();
		}
		
		@GetMapping("/drone/{id}")
		public Drone getDrone(@PathVariable("id") final Long id) {
			Optional<Drone> drone = droneService.getDroneById(id);
			if(drone.isPresent()) {
				return drone.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteDrone(@PathVariable("id") final Long id) {
			
			try {
				droneService.deleteDroneById(id);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Impossible ");
			}
		}
	
}
