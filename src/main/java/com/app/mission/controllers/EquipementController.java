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
import com.app.mission.model.Equipement;
import com.app.mission.repository.EquipementRepo;
import com.app.mission.repository.MaterielRepo;
import com.app.mission.model.Equipement;
import com.app.mission.services.EquipementService;

@RestController
@RequestMapping("/api/equipment")
public class EquipementController {
	
	   @Autowired
	   private EquipementService equipementService;
	   
	   @Autowired
	   private MaterielRepo materielRepo;
	   
	   @Autowired
	   private EquipementRepo equipementRepo;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement equipement) {
	       Equipement newEquipement = equipementService.addEquipement(equipement);
	       return new ResponseEntity<>(newEquipement, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/materiels/{materielId}/equipements")
	   public ResponseEntity<Equipement> createEquipement(@PathVariable(value = "materielId") Long materielId,
	       @RequestBody Equipement equipementRequest) {
	     Equipement equipement = materielRepo.findById(materielId).map(materiel -> {
	       equipementRequest.setMateriel(materiel);
	       return equipementRepo.save(equipementRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Materiel with id = " + materielId));

	     return new ResponseEntity<>(equipement, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/materiels/{materielId}/equipements")
		  public ResponseEntity<List<Equipement>> deleteAllEquipementsOfMission(@PathVariable(value = "materielId") Long materielId) {
		    if (!materielRepo.existsById(materielId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + materielId);
		    }

		    materielRepo.deleteById(materielId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		
		@PutMapping("/update/{id}")
		public Equipement updateEquipementById(@PathVariable("id") final Long id, @RequestBody Equipement equipement) {
			Optional<Equipement> e = equipementService.getEquipement(id);
			if(e.isPresent()) {
				Equipement currentEquipement = e.get();
				
				currentEquipement.setNom_equip(equipement.getNom_equip());
				currentEquipement.setStatut(equipement.getStatut());
		

				equipementService.addEquipement(currentEquipement);
				
				
				return currentEquipement;
			} else {
				return null;
			}
		}

		@GetMapping("/equipements")
		public Iterable<Equipement> getAllEquipements() {
			return equipementService.getEquipements();
		}
		
		@GetMapping("/equipement/{id}")
		public Equipement getEquipement(@PathVariable("id") final Long id) {
			Optional<Equipement> equipement = equipementService.getEquipement(id);
			if(equipement.isPresent()) {
				return equipement.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/equipement/{id}")
		public void deleteEquipement(@PathVariable("id") final Long id) {
			equipementService.deleteEquipement(id);
		}
}
