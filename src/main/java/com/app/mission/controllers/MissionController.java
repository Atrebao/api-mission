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
import com.app.mission.model.Mission;
import com.app.mission.model.Personnel;
import com.app.mission.model.Ville;
import com.app.mission.repository.ClientRepo;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.PersonnelRepo;
import com.app.mission.repository.VilleRepo;
import com.app.mission.services.MissionService;

@RestController
@RequestMapping("/api/mission")
public class MissionController {
	
	   @Autowired
	   private MissionService missionService;
	   
	   @Autowired
	   private ClientRepo clientRepo;
	   
	   @Autowired
	   private MissionRepo missionRepo;
	   
	   @Autowired
	   private VilleRepo villeRepo;
	   
	   @Autowired
	   private PersonnelRepo personnelRepo;
	   
	   
	   
	   @PostMapping("/add")
	   public ResponseEntity<Mission> addMission(@RequestBody Mission mission) {
	       Mission newMission = missionService.addMission(mission);
	       return new ResponseEntity<>(newMission, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/clients/{clientId}/missions")
	   public ResponseEntity<Mission> createMission(@PathVariable(value = "clientId") Long clientId,
	       @RequestBody Mission missionRequest) {
	     Mission mission = clientRepo.findById(clientId).map(client -> {
	       missionRequest.setClient(client);
	       return missionRepo.save(missionRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Client with id = " + clientId));
	     
	     

	     return new ResponseEntity<>(mission, HttpStatus.CREATED);
	   }
	   
	   @PostMapping("/clients/{clientId}/missions/{idVille}")
	   public ResponseEntity<Mission> createMission(@PathVariable(value = "clientId") Long clientId, @PathVariable(value = "idVille") Long idVille, @RequestBody Mission missionRequest) {
		    Mission mission = clientRepo.findById(clientId).map(client -> {
		        missionRequest.setClient(client);
		        Ville ville = villeRepo.findById(idVille).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + idVille));
		        
		        missionRequest.setVille(villeRepo.findById(idVille).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + idVille)));
		        		        
		        return missionRepo.save(missionRequest);
		    }).orElseThrow(() -> new RessourceNotFoundException("Not found Client with id = " + clientId));

		    return new ResponseEntity<>(mission, HttpStatus.CREATED);
		}
	   


	   
	   
	   @PostMapping("/clients/{clientId}/{idVille}/{personnelId}/missions")
	   public ResponseEntity<Mission> addMission(@PathVariable(value = "clientId") Long clientId, @PathVariable(value = "idVille") Long idVille,@PathVariable(value = "personnelId") Long personnelId, @RequestBody Mission MissionRequest) {
	     Mission mission = personnelRepo.findById(personnelId).map(personnel -> {
	       
	       MissionRequest.setVille(villeRepo.findById(idVille).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + idVille)));
	       MissionRequest.setClient(clientRepo.findById(clientId).orElseThrow(() -> new RessourceNotFoundException("Not found Ville with id = " + idVille)));
	     
	       return missionRepo.save(MissionRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found personnel with id = " + personnelId));

	     return new ResponseEntity<>(mission, HttpStatus.CREATED);
	   }
	   


	   
		
		@PutMapping("/update/{id}")
		public Mission updateMissionById(@PathVariable("id") final Long id, @RequestBody Mission mission) {
			Optional<Mission> e = missionService.getMission(id);
			if(e.isPresent()) {
				Mission currentMission = e.get();
				
				String nom = mission.getNom_mission();
				if(nom != null) {
					currentMission.setNom_mission(mission.getNom_mission());
				}
				
				currentMission.setBalisage(mission.getBalisage());
				currentMission.setClasse_espace_aerien(mission.getClasse_espace_aerien());
				currentMission.setCode_mission(mission.getCode_mission());
				currentMission.setCondition_humidite(mission.getCondition_humidite());
				currentMission.setCondition_visibilite(mission.getCondition_visibilite());
				currentMission.setDescription_mission(mission.getDescription_mission());
				currentMission.setDate_estime_mission(mission.getDate_estime_mission());
				currentMission.setDate_heure_effective_mission(mission.getDate_heure_effective_mission());
				currentMission.setStatut_zone_mission(mission.getStatut_zone_mission());
				currentMission.setScenario_mission(mission.getScenario_mission());
				currentMission.setSurface_decollage(mission.getSurface_decollage());
				currentMission.setSurface_atterissage(mission.getSurface_atterissage());
				currentMission.setEvenements(mission.getEvenements());
				currentMission.setPlage_horaire_mission_debut(mission.getPlage_horaire_mission_debut());
				currentMission.setPlage_horaire_mission_fin(mission.getPlage_horaire_mission_fin());
				currentMission.setClasse_espace_aerien(mission.getClasse_espace_aerien());
				currentMission.setType_mission(mission.getType_mission());
				currentMission.setDate_heure_arrive(mission.getDate_heure_arrive());

				missionService.addMission(currentMission);
				return currentMission;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Mission updateAllMissionById(@PathVariable("id") final Long id, @RequestBody Mission mission) {
			Optional<Mission> e = missionService.getMission(id);
			if(e.isPresent()) {
				Mission currentMission = e.get();
				
				String nom = mission.getNom_mission();
				if(nom != null) {
					currentMission.setNom_mission(mission.getNom_mission());
				}
				
				currentMission.setBalisage(mission.getBalisage());
				currentMission.setClasse_espace_aerien(mission.getClasse_espace_aerien());
				currentMission.setCode_mission(mission.getCode_mission());
				currentMission.setCondition_humidite(mission.getCondition_humidite());
				currentMission.setCondition_visibilite(mission.getCondition_visibilite());
				currentMission.setDescription_mission(mission.getDescription_mission());
				currentMission.setDate_estime_mission(mission.getDate_estime_mission());
				currentMission.setDate_heure_effective_mission(mission.getDate_heure_effective_mission());
				currentMission.setStatut_zone_mission(mission.getStatut_zone_mission());
				currentMission.setScenario_mission(mission.getScenario_mission());
				currentMission.setSurface_decollage(mission.getSurface_decollage());
				currentMission.setSurface_atterissage(mission.getSurface_atterissage());
				currentMission.setEvenements(mission.getEvenements());
				currentMission.setPlage_horaire_mission_debut(mission.getPlage_horaire_mission_debut());
				currentMission.setPlage_horaire_mission_fin(mission.getPlage_horaire_mission_fin());
				currentMission.setClasse_espace_aerien(mission.getClasse_espace_aerien());
				currentMission.setMateriels(mission.getMateriels());
				currentMission.setPersonnels(mission.getPersonnels());
				currentMission.setPieceJointes(mission.getPieceJointes());
				currentMission.setType_mission(mission.getType_mission());
				currentMission.setVille(mission.getVille());
				currentMission.setVols(mission.getVols());
				currentMission.setCheckListConfigs(mission.getCheckListConfigs());
				currentMission.setWorkflowOperation(mission.getWorkflowOperation());
				currentMission.setDate_heure_arrive(mission.getDate_heure_arrive());

				missionService.addMission(currentMission);
				return currentMission;
			} else {
				return null;
			}
		}

		@GetMapping("/missions")
		public Iterable<Mission> getAllMissions() {
			return missionService.getMissions();
		}
		
		@GetMapping("/mission/{id}")
		public Mission getMission(@PathVariable("id") final Long id) {
			Optional<Mission> mission = missionService.getMission(id);
			if(mission.isPresent()) {
				return mission.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteMission(@PathVariable("id") final Long id) {
			try {
				missionService.deleteMission(id);
			} catch (Exception e) {
				System.out.println("Cet element n'existe pas");
			}
		}
		
		  @Transactional
		  @DeleteMapping("/clients/{clientId}/missions")
		  public ResponseEntity<List<Mission>> deleteAllMissionsOfMission(@PathVariable(value = "clientId") Long clientId) {
		    if (!clientRepo.existsById(clientId)) {
		      throw new RessourceNotFoundException("Not found Client with id = " + clientId);
		    }

		    missionRepo.deleteById(clientId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  /*
		  
		  @DeleteMapping("/delete/{clientId}/{idVille}/{personnelId}/missions/{missionId}")
		  public ResponseEntity<HttpStatus> deletemissionFrompersonnel(@PathVariable(value = "personnelId") Long personnelId, @PathVariable(value = "missionId") Long missionId) {
		    Personnel personnel = personnelRepo.findById(personnelId)
		        .orElseThrow(() -> new RessourceNotFoundException("Not found personnel with id = " + personnelId));
		    
		    personnel.removeMission(missionId);
		    personnelRepo.save(personnel);
		    
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  */
	
}
