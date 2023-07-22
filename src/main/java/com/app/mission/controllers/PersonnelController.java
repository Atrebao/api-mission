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
import com.app.mission.model.Personnel;
import com.app.mission.repository.FonctionRepo;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.PersonnelRepo;
import com.app.mission.services.PersonnelService;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {
	
	   @Autowired
	   private PersonnelService personnelService;
	   
	   

		@Autowired
		private FonctionRepo fonctionRepo;
		
		@Autowired
		private PersonnelRepo personnelRepo;
		
		
		@Autowired
		private MissionRepo missionRepo;


		   @PostMapping("/fonctions/{fonctionId}/personnels")
		   public ResponseEntity<Personnel> createPersonnel(@PathVariable(value = "fonctionId") Long fonctionId,
		       @RequestBody Personnel personnelRequest) {
		     Personnel personnel = fonctionRepo.findById(fonctionId).map(fonction -> {
		       personnelRequest.setFonctions(fonction);
		       return personnelRepo.save(personnelRequest);
		     }).orElseThrow(() -> new RessourceNotFoundException("Not found Fonction with id = " + fonctionId));
	
		     return new ResponseEntity<>(personnel, HttpStatus.CREATED);
		   }
		   
		   @PostMapping("/fonctions/{fonctionId}/{idMission}/personnels")
		   public ResponseEntity<Personnel> addPersonnelWithAll(@PathVariable(value = "fonctionId") Long fonctionId,@PathVariable(value = "idMission") Long idMission,
		       @RequestBody Personnel personnelRequest) {
		     Personnel personnel = fonctionRepo.findById(fonctionId).map(fonction -> {
		       personnelRequest.setFonctions(fonction);
		       personnelRequest.setMission(missionRepo.findById(idMission).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + idMission)));
		       return personnelRepo.save(personnelRequest);
		     }).orElseThrow(() -> new RessourceNotFoundException("Not found Fonction with id = " + fonctionId));
	
		     return new ResponseEntity<>(personnel, HttpStatus.CREATED);
		   }
		   
		   
		   
		   
	   
		@Transactional
		  @DeleteMapping("/fonctions/{fonctionId}/personnels")
		  public ResponseEntity<List<Personnel>> deleteAllPersonnelsOfMission(@PathVariable(value = "fonctionId") Long fonctionId) {
		    if (!fonctionRepo.existsById(fonctionId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + fonctionId);
		    }

		    fonctionRepo.deleteById(fonctionId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	   
	   @PostMapping("/add")
	   public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel) {
	       Personnel newPersonnel = personnelService.addPersonnel(personnel);
	       return new ResponseEntity<>(newPersonnel, HttpStatus.CREATED);
	   }
	   
		
		@PutMapping("/update/{id}")
		public Personnel updatePersonnelById(@PathVariable("id") final Long id, @RequestBody Personnel personnel) {
			Optional<Personnel> e = personnelService.getPersonnel(id);
			if(e.isPresent()) {
				Personnel currentPersonnel = e.get();
				
				String nom = personnel.getNom_personnel();
				if(nom != null) {
					currentPersonnel.setNom_personnel(nom);
					
				}
				currentPersonnel.setVisa(personnel.getVisa());
				currentPersonnel.setCompetences(personnel.getCompetences());
				currentPersonnel.setPrenoms_personnel(personnel.getPrenoms_personnel());

				personnelService.addPersonnel(currentPersonnel);
				return currentPersonnel;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Personnel updateAllPersonnelById(@PathVariable("id") final Long id, @RequestBody Personnel personnel) {
			Optional<Personnel> e = personnelService.getPersonnel(id);
			if(e.isPresent()) {
				Personnel currentPersonnel = e.get();
				
				String nom = personnel.getNom_personnel();
				if(nom != null) {
					currentPersonnel.setNom_personnel(nom);
					
				}
				currentPersonnel.setVisa(personnel.getVisa());
				currentPersonnel.setMission(personnel.getMission());
				
				currentPersonnel.setCompetences(personnel.getCompetences());
				currentPersonnel.setPrenoms_personnel(personnel.getPrenoms_personnel());
				currentPersonnel.setFonctions(personnel.getFonctions());
				currentPersonnel.setUtilsateur(personnel.getUtilsateur());
				

				personnelService.addPersonnel(currentPersonnel);
				return currentPersonnel;
			} else {
				return null;
			}
		}

		@GetMapping("/personnels")
		public Iterable<Personnel> getAllPersonnels() {
			return personnelService.getPersonnels();
		}
		
		@GetMapping("/personnel/{id}")
		public Personnel getPersonnelById(@PathVariable("id") final Long id) {
			Optional<Personnel> personnel = personnelService.getPersonnel(id);
			if(personnel.isPresent()) {
				return personnel.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deletePersonnelById(@PathVariable("id") final Long id) {
			try {
				personnelService.deletePersoneel(id);
			} catch (Exception e) {
				System.out.println("Personnel " + id + " n'existe pas");
			}
		}
}
