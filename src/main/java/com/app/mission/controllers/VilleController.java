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

import com.app.mission.model.Ville;
import com.app.mission.repository.VilleRepo;
import com.app.mission.services.VilleService;

@RestController
@RequestMapping("/api/ville")
public class VilleController {
	
	   @Autowired
	   private VilleService villeService;
	   
	   @Autowired
	   private VilleRepo villeRepo;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Ville> addVille(@RequestBody Ville ville) {
	       Ville newVille = villeService.addVille(ville);
	       
	       return new ResponseEntity<>(newVille, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Ville updateVilleById(@PathVariable("id") final Long id, @RequestBody Ville ville) {
			Optional<Ville> e = villeService.getVilleById(id);
			if(e.isPresent()) {
				Ville currentVille = e.get();
				
				String nom = ville.getNom_ville();
				if(nom != null) {
					currentVille.setNom_ville(nom);
					
				}
		
				villeService.addVille(currentVille);
				return currentVille;
			} else {
				return null;
			}
		}
		
		
		
		@PutMapping("/updateAll/{id}")
		public Ville updateAllVilleById(@PathVariable("id") final Long id, @RequestBody Ville ville) {
			Optional<Ville> e = villeService.getVilleById(id);
			if(e.isPresent()) {
				Ville currentVille = e.get();
				
				String nom = ville.getNom_ville();
				if(nom != null) {
					currentVille.setNom_ville(nom);
					
				}
				currentVille.setMissions(ville.getMissions());
				
				currentVille.setCommunes(ville.getCommunes());
				currentVille.setMissions(ville.getMissions());

				villeService.addVille(currentVille);
				return currentVille;
			} else {
				return null;
			}
		}

		@GetMapping("/villes")
		public Iterable<Ville> getAllVilles() {
			return villeService.getAllVille();
		}
		
		@GetMapping("/ville/{id}")
		public Ville getVilleById(@PathVariable("id") final Long id) {
			Optional<Ville> ville = villeService.getVilleById(id);
			if(ville.isPresent()) {
				return ville.get();
			} else {
				return null;
			}
		}
		

		
		@DeleteMapping("/delete/{id}")
		public void deleteVilleById(@PathVariable("id") final Long id) {
			try {
				villeService.deleteVilleById(id);
			} catch (Exception e) {
				System.out.println("Ville " + id + " n'existe pas");
			}
		}
}
