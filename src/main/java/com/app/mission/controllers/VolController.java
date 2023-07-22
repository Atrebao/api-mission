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
import com.app.mission.model.Vol;
import com.app.mission.repository.DroneRepo;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.VolRepo;
import com.app.mission.services.DroneService;
import com.app.mission.services.VolService;

@RestController
@RequestMapping("/api/vol")
public class VolController {
	
	   @Autowired
	   private VolService volService;
	   
	   @Autowired
		private MissionRepo missionRepo;
		
		@Autowired
		private VolRepo volRepo;
		
		@Autowired
		private DroneRepo droneRepo;


	   @PostMapping("/missions/{missionId}/vols")
	   public ResponseEntity<Vol> createVol(@PathVariable(value = "missionId") Long missionId,
	       @RequestBody Vol volRequest) {
	     Vol vol = missionRepo.findById(missionId).map(mission -> {
	       volRequest.setMission(mission);
	       return volRepo.save(volRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found Mission with id = " + missionId));

	     return new ResponseEntity<>(vol, HttpStatus.CREATED);
	   }
	   

	   
	   
	   
		@Transactional
		  @DeleteMapping("/missions/{missionId}/vols")
		  public ResponseEntity<List<Vol>> deleteAllVolsOfMission(@PathVariable(value = "missionId") Long missionId) {
		    if (!missionRepo.existsById(missionId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + missionId);
		    }

		    missionRepo.deleteById(missionId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	   
	   @PostMapping("/add")
	   public ResponseEntity<Vol> addVol(@RequestBody Vol vol) {
	       Vol newVol = volService.addVol(vol);
	       return new ResponseEntity<>(newVol, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Vol updateVolById(@PathVariable("id") final Long id, @RequestBody Vol vol) {
			Optional<Vol> e = volService.getVol(id);
			if(e.isPresent()) {
				Vol currentVol = e.get();
				
				currentVol.setChevauchement(vol.getChevauchement());
				currentVol.setGSD(vol.getGSD());
				currentVol.setHauteur_vol_retenue(vol.getHauteur_vol_retenue());
				currentVol.setHeure_atterissage(vol.getHeure_atterissage());
				currentVol.setHeure_decoolage(vol.getHeure_decoolage());
				currentVol.setInclinaison_camera(vol.getInclinaison_camera());
				currentVol.setVitesse(vol.getVitesse());
				currentVol.setPourcentage_batteie(vol.getPourcentage_batteie());
				

				
				

				volService.addVol(currentVol);
				return currentVol;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Vol updateAllVolById(@PathVariable("id") final Long id, @RequestBody Vol vol) {
			Optional<Vol> e = volService.getVol(id);
			if(e.isPresent()) {
				Vol currentVol = e.get();
				currentVol.setChevauchement(vol.getChevauchement());
				currentVol.setGSD(vol.getGSD());
				currentVol.setHauteur_vol_retenue(vol.getHauteur_vol_retenue());
				currentVol.setHeure_atterissage(vol.getHeure_atterissage());
				currentVol.setHeure_decoolage(vol.getHeure_decoolage());
				currentVol.setInclinaison_camera(vol.getInclinaison_camera());
				currentVol.setVitesse(vol.getVitesse());
				currentVol.setPourcentage_batteie(vol.getPourcentage_batteie());
				currentVol.setMission(vol.getMission());
				


				volService.addVol(currentVol);
				return currentVol;
			} else {
				return null;
			}
		}

		@GetMapping("/vols")
		public Iterable<Vol> getAllVols() {
			return volService.getVols();
		}
		
		@GetMapping("/vol/{id}")
		public Vol getVolById(@PathVariable("id") final Long id) {
			Optional<Vol> vol = volService.getVol(id);
			if(vol.isPresent()) {
				return vol.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteVolById(@PathVariable("id") final Long id) {
			try {
				volService.deleteVol(id);
			} catch (Exception e) {
				System.out.println("Vol " + id + " n'existe pas");
			}
		}

	
}
