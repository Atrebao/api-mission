package com.app.mission.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import com.app.mission.exception.RessourceNotFoundException;
import com.app.mission.model.Obstacle;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.ObstaclesRepo;
import com.app.mission.services.ObstacleService;

@RestController
@RequestMapping("/api/obstacle")
public class ObstacleController {
	
		@Autowired
		private MissionRepo missionRepo;
		
		@Autowired
		private ObstaclesRepo obstacleRepo;
	
	   @Autowired
	   private ObstacleService obstacleService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Obstacle> addObstacle(@RequestBody Obstacle obstacle) {
	       Obstacle newObstacle = obstacleService.addObstacle(obstacle);
	       return new ResponseEntity<>(newObstacle, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/missions/{missionId}/obstacles")
	   public ResponseEntity<Obstacle> createObstacle(@PathVariable(value = "missionId") Long missionId,
	       @RequestBody Obstacle obstacleRequest) {
	     Obstacle obstacle = missionRepo.findById(missionId).map(mission -> {
	       obstacleRequest.setMission(mission);
	       return obstacleRepo.save(obstacleRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Mission with id = " + missionId));

	     return new ResponseEntity<>(obstacle, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/missions/{missionId}/obstacles")
		  public ResponseEntity<List<Obstacle>> deleteAllObstaclesOfMission(@PathVariable(value = "missionId") Long missionId) {
		    if (!missionRepo.existsById(missionId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + missionId);
		    }

		    obstacleRepo.deleteById(missionId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	   
	   @GetMapping("/missions/{missionId}/obstacles")
	   public Optional<Obstacle> getAllObstaclesByMissionId(@PathVariable(value = "missionId") Long missionId) {
	     if (!missionRepo.existsById(missionId)) {
	       throw new RessourceNotFoundException("Not found Mission with id = " + missionId);
	     }

	     Optional<Obstacle> obstacles = obstacleRepo.findById(missionId);
	     return obstacles;
	   }
		
		@PutMapping("/update/{id}")
		public Obstacle updateObstacleById(@PathVariable("id") final Long id, @RequestBody Obstacle obstacle) {
			Optional<Obstacle> e = obstacleService.getObstacle(id);
			if(e.isPresent()) {
				Obstacle currentObstacle = e.get();
				
				String nom = obstacle.getNom_obst();
				if(nom != null) {
					currentObstacle.setNom_obst(nom);
				}
				
				currentObstacle.setHaute_obst(obstacle.getHaute_obst());
				currentObstacle.setType_obst(obstacle.getType_obst());
				currentObstacle.setMeprise_obst(obstacle.getMeprise_obst());
				
				

				obstacleService.addObstacle(currentObstacle);
				return currentObstacle;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Obstacle updateAllObstacleById(@PathVariable("id") final Long id, @RequestBody Obstacle obstacle) {
			Optional<Obstacle> e = obstacleService.getObstacle(id);
			if(e.isPresent()) {
				Obstacle currentObstacle = e.get();
				
				String nom = obstacle.getNom_obst();
				if(nom != null) {
					currentObstacle.setNom_obst(nom);
					
				}
				
				currentObstacle.setHaute_obst(obstacle.getHaute_obst());
				currentObstacle.setType_obst(obstacle.getType_obst());
				currentObstacle.setMeprise_obst(obstacle.getMeprise_obst());
				

				obstacleService.addObstacle(currentObstacle);
				return currentObstacle;
			} else {
				return null;
			}
		}

		@GetMapping("/obstacles")
		public Iterable<Obstacle> getAllObstacles() {
			return obstacleService.getObstacles();
		}
		
		@GetMapping("/obstacle/{id}")
		public Obstacle getObstacleById(@PathVariable("id") final Long id) {
			Optional<Obstacle> obstacle = obstacleService.getObstacle(id);
			if(obstacle.isPresent()) {
				return obstacle.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteObstacleById(@PathVariable("id") final Long id) {
			try {
				obstacleService.deleteObstacle(id);
			} catch (Exception e) {
				System.out.println("Obstacle " + id + " n'existe pas");
			}
		}
	

	
}
