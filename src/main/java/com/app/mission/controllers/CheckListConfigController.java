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
import com.app.mission.model.CheckListConfig;
import com.app.mission.model.CheckListConfig;
import com.app.mission.repository.CheckListConfigRepo;
import com.app.mission.repository.MissionRepo;
import com.app.mission.services.CheckListConfigService;

@RestController
@RequestMapping("/api/checkConfig")
public class CheckListConfigController {
	
	   @Autowired
	   private CheckListConfigService checkListConfigService;
	   
	   @Autowired
	   private CheckListConfigRepo checkListConfigRepo;
	   
	   @Autowired
	   private MissionRepo missionRepo;
	   
	   @PostMapping("/add")
	   public ResponseEntity<CheckListConfig> addCheckListConfig(@RequestBody CheckListConfig checkListConfig) {
		   CheckListConfig newCheckListConfigType = checkListConfigService.addCheckListConfig(checkListConfig);
	       return new ResponseEntity<>(newCheckListConfigType, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/missions/{missionId}/checkListConfigs")
	   public ResponseEntity<CheckListConfig> createCheckListConfig(@PathVariable(value = "missionId") Long missionId,
	       @RequestBody CheckListConfig checkListConfigRequest) {
	     CheckListConfig checkListConfig = missionRepo.findById(missionId).map(mission -> {
	       checkListConfigRequest.setMission(mission);
	       return checkListConfigRepo.save(checkListConfigRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Mission with id = " + missionId));

	     return new ResponseEntity<>(checkListConfig, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/missions/{missionId}/checkListConfigs")
		  public ResponseEntity<List<CheckListConfig>> deleteAllCheckListConfigsOfMission(@PathVariable(value = "missionId") Long missionId) {
		    if (!missionRepo.existsById(missionId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + missionId);
		    }

		    checkListConfigRepo.deleteById(missionId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		
		@PutMapping("/update/{id}")
		public CheckListConfig updateCheckListConfigById(@PathVariable("id") final Long id, @RequestBody CheckListConfig checkListConfig) {
			Optional<CheckListConfig> e = checkListConfigService.getCheckListConfigById(id);
			if(e.isPresent()) {
				CheckListConfig currentCheckListConfig = e.get();
				
				String libelle = checkListConfig.getLibelle();
				if(libelle != null) {
					currentCheckListConfig.setLibelle(libelle);
				}
				
				currentCheckListConfig.setCkeckConfigType(checkListConfig.getCkeckConfigType());
				currentCheckListConfig.setGpConfigCheck(checkListConfig.getGpConfigCheck());
				currentCheckListConfig.setMission(checkListConfig.getMission());

				checkListConfigService.addCheckListConfig(currentCheckListConfig);
				return currentCheckListConfig;
			} else {
				return null;
			}
		}

		@GetMapping("/checkListConfigs")
		public Iterable<CheckListConfig> getAllCheckListConfigs() {
			return checkListConfigService.getAllCheckListConfig();
		}
		
		@GetMapping("/checkListConfig/{id}")
		public CheckListConfig getCheckListConfigById(@PathVariable("id") final Long id) {
			Optional<CheckListConfig> checkListConfig = checkListConfigService.getCheckListConfigById(id);
			if(checkListConfig.isPresent()) {
				return checkListConfig.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/checkListConfig/{id}")
		public void deleteCheckListConfigById(@PathVariable("id") final Long id) {
			checkListConfigService.deleteCheckListConfigById(id);
		}
	
}
