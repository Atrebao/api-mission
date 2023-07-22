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

import com.app.mission.model.Fonction;
import com.app.mission.services.FonctionService;

@RestController
@RequestMapping("/api/fonction")
public class FonctionController {
		
		@Autowired
	   private FonctionService fonctionService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Fonction> addFonction(@RequestBody Fonction fonction) {
	       Fonction newFonction = fonctionService.addFonction(fonction);
	       return new ResponseEntity<>(newFonction, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Fonction updateFonctionById(@PathVariable("id") final Long id, @RequestBody Fonction fonction) {
			Optional<Fonction> e = fonctionService.getFonctionById(id);
			if(e.isPresent()) {
				Fonction currentFonction = e.get();
				
				currentFonction.setNom_fonction(fonction.getNom_fonction());

				fonctionService.addFonction(currentFonction);
				
				
				return currentFonction;
			} else {
				return null;
			}
		}
		
		
		@PutMapping("/updateAll/{id}")
		public Fonction updateAllFonctionById(@PathVariable("id") final Long id, @RequestBody Fonction fonction) {
			Optional<Fonction> e = fonctionService.getFonctionById(id);
			if(e.isPresent()) {
				Fonction currentFonction = e.get();
				
				
				currentFonction.setNom_fonction(fonction.getNom_fonction());

				fonctionService.addFonction(currentFonction);
				
				
				return currentFonction;
			} else {
				return null;
			}
		}

		@GetMapping("/fonctions")
		public Iterable<Fonction> getAllFonctions() {
			return fonctionService.getAllFonction();
		}
		
		@GetMapping("/fonction/{id}")
		public Fonction getFonction(@PathVariable("id") final Long id) {
			Optional<Fonction> fonction = fonctionService.getFonctionById(id);
			if(fonction.isPresent()) {
				return fonction.get();
			} else {
				return null;
			}
		}
		
		@GetMapping("/fonction/{name}")
		public Fonction getFonctionByName(@PathVariable("name") final String name) {
			Optional<Fonction> fonction = fonctionService.getFonctionByName(name);
			if(fonction.isPresent()) {
				return fonction.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/fonction/{id}")
		public ResponseEntity<Void> deleteFonction(@PathVariable("id") final Long id) {
			fonctionService.deleteFonctionById(id);
			return ResponseEntity.noContent().build();
		}
}
