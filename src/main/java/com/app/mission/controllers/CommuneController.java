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
import com.app.mission.model.Commune;
import com.app.mission.repository.CommuneRepo;
import com.app.mission.repository.VilleRepo;
import com.app.mission.services.CommuneService;

@RestController
@RequestMapping("/api/commune")
public class CommuneController {
	
		@Autowired
		private VilleRepo villeRepo;
		
		@Autowired
		private CommuneRepo communeRepo;
	
	
	   @Autowired
	   private CommuneService communeService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Commune> addCommune(@RequestBody Commune commune) {
		   Commune newCommuneType = communeService.addCommune(commune);
	       return new ResponseEntity<>(newCommuneType, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/villes/{villeId}/communes")
	   public ResponseEntity<Commune> createCommune(@PathVariable(value = "villeId") Long villeId,
	       @RequestBody Commune communeRequest) {
	     Commune commune = villeRepo.findById(villeId).map(ville -> {
	       communeRequest.setVille(ville);
	       return communeRepo.save(communeRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + villeId));

	     return new ResponseEntity<>(commune, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/villes/{villeId}/communes")
		  public ResponseEntity<List<Commune>> deleteAllCommunesOfMission(@PathVariable(value = "villeId") Long villeId) {
		    if (!villeRepo.existsById(villeId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + villeId);
		    }

		    villeRepo.deleteById(villeId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
