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

import com.app.mission.model.CheckConfigType;
import com.app.mission.services.CheckListConfigTypeService;

@RestController
@RequestMapping("/api/checkConfigType")
public class CheckConfigTypeController {
	   @Autowired
	   private CheckListConfigTypeService checkListConfigTypeService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<CheckConfigType> addCheckConfigType(@RequestBody CheckConfigType checkConfigType) {
	       CheckConfigType newCheckConfigType = checkListConfigTypeService.addCheckListConfigType(checkConfigType);
	       return new ResponseEntity<>(newCheckConfigType, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public CheckConfigType updateCheckConfigTypeById(@PathVariable("id") final Long id, @RequestBody CheckConfigType checkConfigType) {
			Optional<CheckConfigType> e = checkListConfigTypeService.getCheckListConfigTypeById(id);
			if(e.isPresent()) {
				CheckConfigType currentCheckConfigType = e.get();
				
				String nom = checkConfigType.getNom_ckeckConfigType();
				if(nom != null) {
					currentCheckConfigType.setNom_ckeckConfigType(nom);
				}

				checkListConfigTypeService.addCheckListConfigType(currentCheckConfigType);
				return currentCheckConfigType;
			} else {
				return null;
			}
		}

		@GetMapping("/checkConfigTypes")
		public Iterable<CheckConfigType> getAllCheckConfigTypes() {
			return checkListConfigTypeService.getAllCheckListConfigType();
		}
		
		@GetMapping("/checkConfigType/{id}")
		public CheckConfigType getCheckConfigType(@PathVariable("id") final Long id) {
			Optional<CheckConfigType> checkConfigType = checkListConfigTypeService.getCheckListConfigTypeById(id);
			if(checkConfigType.isPresent()) {
				return checkConfigType.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteCheckConfigType(@PathVariable("id") final Long id) {
			try {
				checkListConfigTypeService.deleteCheckListConfigById(id);
			} catch (Exception e) {
				System.out.println("Ce element n'existe pas");
			}
		}
}
