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
import com.app.mission.model.User;
import com.app.mission.repository.UtilisateurRepo;
import com.app.mission.repository.WorkflowOperationRepo;
import com.app.mission.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurController {
	
	   @Autowired
	   private UtilisateurService utilisateurService;
	   

		@Autowired
		private WorkflowOperationRepo workflowOperationRepo;
		
		@Autowired
		private UtilisateurRepo utiisateurRepo;


	   @PostMapping("/workflowOperations/{workflowOperationId}/utiisateurs")
	   public ResponseEntity<User> createUtilisateur(@PathVariable(value = "workflowOperationId") Long workflowOperationId,
	       @RequestBody User utiisateurRequest) {
	     User utiisateur = workflowOperationRepo.findById(workflowOperationId).map(workflowOperation -> {
	       utiisateurRequest.setWorkflowOperation(workflowOperation);
	       return utiisateurRepo.save(utiisateurRequest);
	     }).orElseThrow(() -> new RessourceNotFoundException("Not found WorkflowOperation with id = " + workflowOperationId));

	     return new ResponseEntity<>(utiisateur, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/workflowOperations/{workflowOperationId}/communes")
		  public ResponseEntity<List<User>> deleteAllUtilisateursOfMission(@PathVariable(value = "workflowOperationId") Long workflowOperationId) {
		    if (!workflowOperationRepo.existsById(workflowOperationId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + workflowOperationId);
		    }

		    workflowOperationRepo.deleteById(workflowOperationId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	   
	   @PostMapping("/add")
	   public ResponseEntity<User> addUtilisateur(@RequestBody User utilisateur) {
	       User newUtilisateur = utilisateurService.addUtilisateur(utilisateur);
	       return new ResponseEntity<>(newUtilisateur, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public User updateUtilisateurById(@PathVariable("id") final Long id, @RequestBody User utilisateur) {
			Optional<User> e = utilisateurService.getUtilisateurById(id);
			if(e.isPresent()) {
				User currentUtilisateur = e.get();
				
				String nom = utilisateur.getNom_utilisateur();
				if(nom != null) {
					currentUtilisateur.setNom_utilisateur(nom);
					
				}
				
				currentUtilisateur.setMot_de_passe(utilisateur.getMot_de_passe());

				utilisateurService.addUtilisateur(currentUtilisateur);
				return currentUtilisateur;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public User updateAllUtilisateurById(@PathVariable("id") final Long id, @RequestBody User utilisateur) {
			Optional<User> e = utilisateurService.getUtilisateurById(id);
			if(e.isPresent()) {
				User currentUtilisateur = e.get();
				
				String nom = utilisateur.getNom_utilisateur();
				if(nom != null) {
					currentUtilisateur.setNom_utilisateur(nom);
					
				}
				currentUtilisateur.setMot_de_passe(utilisateur.getMot_de_passe());
				currentUtilisateur.setPersonnel(utilisateur.getPersonnel());
				currentUtilisateur.setRoles(utilisateur.getRoles());
				currentUtilisateur.setWorkflowOperation(utilisateur.getWorkflowOperation());

				utilisateurService.addUtilisateur(currentUtilisateur);
				return currentUtilisateur;
			} else {
				return null;
			}
		}

		@GetMapping("/utilisateurs")
		public Iterable<User> getAllUtilisateurs() {
			return utilisateurService.getAllUtilisateur();
		}
		
		@GetMapping("/utilisateur/{id}")
		public User getUtilisateurById(@PathVariable("id") final Long id) {
			Optional<User> utilisateur = utilisateurService.getUtilisateurById(id);
			if(utilisateur.isPresent()) {
				return utilisateur.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteUtilisateurById(@PathVariable("id") final Long id) {
			try {
				utilisateurService.deleteUtilisateurById(id);
			} catch (Exception e) {
				System.out.println("Utilisateur " + id + " n'existe pas");
			}
		}
	
	
}
