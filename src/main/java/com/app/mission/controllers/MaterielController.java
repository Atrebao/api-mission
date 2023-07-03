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

import com.app.mission.model.Materiel;
import com.app.mission.services.MaterielService;

@RestController
@RequestMapping("/api/materiel")
public class MaterielController {
	
	   private MaterielService materielService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Materiel> addMateriel(@RequestBody Materiel materiel) {
	       Materiel newMateriel = materielService.addMateriel(materiel);
	       return new ResponseEntity<>(newMateriel, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Materiel updateMaterielById(@PathVariable("id") final Long id, @RequestBody Materiel materiel) {
			Optional<Materiel> e = materielService.getMaterielById(id);
			if(e.isPresent()) {
				Materiel currentMateriel = e.get();
				
				currentMateriel.setQuatite(materiel.getQuatite());
				currentMateriel.setDesignation_mat(materiel.getDesignation_mat());
				currentMateriel.setEtat_marche_mat(materiel.getEtat_marche_mat());
				currentMateriel.setDate_heure_sortie(materiel.getDate_heure_sortie());
				currentMateriel.setDate_heure_retour(materiel.getDate_heure_retour());


				materielService.addMateriel(currentMateriel);
				
				
				return currentMateriel;
			} else {
				return null;
			}
		}
		
		
		@PutMapping("/updateAll/{id}")
		public Materiel updateAllMaterielById(@PathVariable("id") final Long id, @RequestBody Materiel materiel) {
			Optional<Materiel> e = materielService.getMaterielById(id);
			if(e.isPresent()) {
				Materiel currentMateriel = e.get();
			
				
				currentMateriel.setQuatite(materiel.getQuatite());
				currentMateriel.setDesignation_mat(materiel.getDesignation_mat());
				currentMateriel.setEtat_marche_mat(materiel.getEtat_marche_mat());
				currentMateriel.setDate_heure_sortie(materiel.getDate_heure_sortie());
				currentMateriel.setDate_heure_retour(materiel.getDate_heure_retour());
				currentMateriel.setMission(materiel.getMission());
				currentMateriel.setEquipements(materiel.getEquipements());
				
				

				materielService.addMateriel(currentMateriel);
				
				
				return currentMateriel;
			} else {
				return null;
			}
		}

		@GetMapping("/materiels")
		public Iterable<Materiel> getAllMateriels() {
			return materielService.getAllMateriel();
		}
		
		@GetMapping("/materiel/{id}")
		public Materiel getMateriel(@PathVariable("id") final Long id) {
			Optional<Materiel> materiel = materielService.getMaterielById(id);
			if(materiel.isPresent()) {
				return materiel.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/materiel/{id}")
		public ResponseEntity<Void> deleteMateriel(@PathVariable("id") final Long id) {
			materielService.deleteMaterielById(id);
			return ResponseEntity.noContent().build();
		}
}
