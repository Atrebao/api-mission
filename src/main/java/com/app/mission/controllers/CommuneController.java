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

import com.app.mission.model.Commune;
import com.app.mission.services.CommuneService;

@RestController
@RequestMapping("/api/commune")
public class CommuneController {
	
	
	   @Autowired
	   private CommuneService communeService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Commune> addCommune(@RequestBody Commune commune) {
		   Commune newCommuneType = communeService.addCommune(commune);
	       return new ResponseEntity<>(newCommuneType, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Commune updateCommuneById(@PathVariable("id") final Long id, @RequestBody Commune commune) {
			Optional<Commune> e = communeService.getCommuneById(id);
			if(e.isPresent()) {
				Commune currentCommune = e.get();
				
				String nom = commune.getNom_commune();
				if(nom != null) {
					currentCommune.setNom_commune(nom);
				}
				
				currentCommune.setVille(commune.getVille());
				
				communeService.addCommune(currentCommune);
				return currentCommune;
			} else {
				return null;
			}
		}

		@GetMapping("/communes")
		public Iterable<Commune> getAllCommunes() {
			return communeService.getAllCommune();
		}
		
		@GetMapping("/commune/{id}")
		public Commune getCommuneById(@PathVariable("id") final Long id) {
			Optional<Commune> commune = communeService.getCommuneById(id);
			if(commune.isPresent()) {
				return commune.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/commune/{id}")
		public void deleteCommuneById(@PathVariable("id") final Long id) {
			communeService.deleteCommuneById(id);
		}
}
