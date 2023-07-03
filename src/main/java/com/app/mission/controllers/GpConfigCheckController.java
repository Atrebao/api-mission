package com.app.mission.controllers;

import java.util.Optional;

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

import com.app.mission.model.GpConfigCheck;
import com.app.mission.services.GpConfigCheckService;

@RestController
@RequestMapping("/api/gpConfigCheck")
public class GpConfigCheckController {
	
	   private GpConfigCheckService gpConfigCheckService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<GpConfigCheck> addGpConfigCheck(@RequestBody GpConfigCheck gpConfigCheck) {
	       GpConfigCheck newGpConfigCheck = gpConfigCheckService.addGpConfigCheck(gpConfigCheck);
	       return new ResponseEntity<>(newGpConfigCheck, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public GpConfigCheck updateGpConfigCheckById(@PathVariable("id") final Long id, @RequestBody GpConfigCheck gpConfigCheck) {
			Optional<GpConfigCheck> e = gpConfigCheckService.getGpConfigCheckById(id);
			if(e.isPresent()) {
				GpConfigCheck currentGpConfigCheck = e.get();
				
				currentGpConfigCheck.setNom_GpConfig(gpConfigCheck.getNom_GpConfig());

				gpConfigCheckService.addGpConfigCheck(currentGpConfigCheck);
				
				
				return currentGpConfigCheck;
			} else {
				return null;
			}
		}
		
		
		@PutMapping("/updateAll/{id}")
		public GpConfigCheck updateAllGpConfigCheckById(@PathVariable("id") final Long id, @RequestBody GpConfigCheck gpConfigCheck) {
			Optional<GpConfigCheck> e = gpConfigCheckService.getGpConfigCheckById(id);
			if(e.isPresent()) {
				GpConfigCheck currentGpConfigCheck = e.get();
			
				
				currentGpConfigCheck.setNom_GpConfig(gpConfigCheck.getNom_GpConfig());
				currentGpConfigCheck.setCheckListConfigs(gpConfigCheck.getCheckListConfigs());
				

				gpConfigCheckService.addGpConfigCheck(currentGpConfigCheck);
				
				
				return currentGpConfigCheck;
			} else {
				return null;
			}
		}

		@GetMapping("/gpConfigChecks")
		public Iterable<GpConfigCheck> getAllGpConfigChecks() {
			return gpConfigCheckService.getAllGpConfigCheck();
		}
		
		@GetMapping("/gpConfigCheck/{id}")
		public GpConfigCheck getGpConfigCheck(@PathVariable("id") final Long id) {
			Optional<GpConfigCheck> gpConfigCheck = gpConfigCheckService.getGpConfigCheckById(id);
			if(gpConfigCheck.isPresent()) {
				return gpConfigCheck.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/gpConfigCheck/{id}")
		public ResponseEntity<Void> deleteGpConfigCheck(@PathVariable("id") final Long id) {
			gpConfigCheckService.deleteGpConfigCheckById(id);
			return ResponseEntity.noContent().build();
		}
}
