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

import com.app.mission.model.Etape;
import com.app.mission.services.EtapeService;

@RestController
@RequestMapping("/api/etape")
public class EtapeController {
	
	   @Autowired
	   private EtapeService etapeService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Etape> addEtape(@RequestBody Etape etape) {
	       Etape newEtape = etapeService.addEtape(etape);
	       return new ResponseEntity<>(newEtape, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Etape updateEtapeById(@PathVariable("id") final Long id, @RequestBody Etape etape) {
			Optional<Etape> e = etapeService.getEtapeById(id);
			if(e.isPresent()) {
				Etape currentEtape = e.get();
				
				currentEtape.setId_etape_prec(etape.getId_etape_prec());
				currentEtape.setId_etape_suiv(etape.getId_etape_suiv());
				currentEtape.setLibelle_etape(etape.getLibelle_etape());
				currentEtape.setIsActive(etape.getIsActive());

				etapeService.addEtape(currentEtape);
				
				
				return currentEtape;
			} else {
				return null;
			}
		}
		
		
		@PutMapping("/updateAll/{id}")
		public Etape updateAllEtapeById(@PathVariable("id") final Long id, @RequestBody Etape etape) {
			Optional<Etape> e = etapeService.getEtapeById(id);
			if(e.isPresent()) {
				Etape currentEtape = e.get();
				
				currentEtape.setId_etape_prec(etape.getId_etape_prec());
				currentEtape.setId_etape_suiv(etape.getId_etape_suiv());
				currentEtape.setIsActive(etape.getIsActive());
				currentEtape.setLibelle_etape(etape.getLibelle_etape());
				currentEtape.setRoles(etape.getRoles());
				currentEtape.setWorkflow(etape.getWorkflow());
				currentEtape.setWorkflow_operation(etape.getWorkflow_operation());

				etapeService.addEtape(currentEtape);
				
				
				return currentEtape;
			} else {
				return null;
			}
		}

		@GetMapping("/etapes")
		public Iterable<Etape> getAllEtapes() {
			return etapeService.getAllEtape();
		}
		
		@GetMapping("/etape/{id}")
		public Etape getEtape(@PathVariable("id") final Long id) {
			Optional<Etape> etape = etapeService.getEtapeById(id);
			if(etape.isPresent()) {
				return etape.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteEtape(@PathVariable("id") final Long id) {
			try {
				etapeService.deleteEtapeById(id);
			} catch (Exception e) {
				System.out.println("Cet element n'existe pas");
			}
		}
}
