package com.app.mission.controllers;

import java.sql.Blob;
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
import com.app.mission.model.PieceJointe;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.PieceJointeRepo;
import com.app.mission.services.PieceJointeService;

@RestController
@RequestMapping("/api/pieceJointe")
public class PieceJointeController {
		
	   @Autowired
	   private PieceJointeService pieceJointeService;
	   
	   
		@Autowired
		private MissionRepo missionRepo;
		
		@Autowired
		private PieceJointeRepo pieceJointeRepo;


	   @PostMapping("/missions/{missionId}/pieceJointes")
	   public ResponseEntity<PieceJointe> createPieceJointe(@PathVariable(value = "missionId") Long missionId,
	       @RequestBody PieceJointe pieceJointeRequest) {
	     PieceJointe pieceJointe = missionRepo.findById(missionId).map(mission -> {
	       pieceJointeRequest.setMission(mission);
	       return pieceJointeRepo.save(pieceJointeRequest);
	     }
	    		 
	     ).orElseThrow(() -> new RessourceNotFoundException("Not found Mission with id = " + missionId));

	     return new ResponseEntity<>(pieceJointe, HttpStatus.CREATED);
	   }
	   
		@Transactional
		  @DeleteMapping("/missions/{missionId}/pieceJointes")
		  public ResponseEntity<List<PieceJointe>> deleteAllPieceJointesOfMission(@PathVariable(value = "missionId") Long missionId) {
		    if (!missionRepo.existsById(missionId)) {
		      throw new RessourceNotFoundException("Not found Mission with id = " + missionId);
		    }

		    missionRepo.deleteById(missionId);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
	   
	   @PostMapping("/add")
	   public ResponseEntity<PieceJointe> addPieceJointe(@RequestBody PieceJointe pieceJointe) {
	       PieceJointe newPieceJointe = pieceJointeService.addPieceJointe(pieceJointe);
	       return new ResponseEntity<>(newPieceJointe, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public PieceJointe updatePieceJointeById(@PathVariable("id") final Long id, @RequestBody PieceJointe pieceJointe) {
			Optional<PieceJointe> e = pieceJointeService.getPieceJointeById(id);
			if(e.isPresent()) {
				PieceJointe currentPieceJointe = e.get();
				
				Blob contenu = pieceJointe.getContenuePiece();
				if(contenu != null) {
					currentPieceJointe.setContenuePiece(contenu);
					
				}
				pieceJointeService.addPieceJointe(currentPieceJointe);
				return currentPieceJointe;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public PieceJointe updateAllPieceJointeById(@PathVariable("id") final Long id, @RequestBody PieceJointe pieceJointe) {
			Optional<PieceJointe> e = pieceJointeService.getPieceJointeById(id);
			if(e.isPresent()) {
				PieceJointe currentPieceJointe = e.get();
				
				Blob contenu = pieceJointe.getContenuePiece();
				if(contenu != null) {
					currentPieceJointe.setContenuePiece(contenu);
					
				}
				
				currentPieceJointe.setMission(pieceJointe.getMission());
				currentPieceJointe.setWorkflowOperation(pieceJointe.getWorkflowOperation());
				
				

				pieceJointeService.addPieceJointe(currentPieceJointe);
				return currentPieceJointe;
			} else {
				return null;
			}
		}

		@GetMapping("/pieceJointes")
		public Iterable<PieceJointe> getAllPieceJointes() {
			return pieceJointeService.getAllPieceJointe();
		}
		
		@GetMapping("/pieceJointe/{id}")
		public PieceJointe getPieceJointeById(@PathVariable("id") final Long id) {
			Optional<PieceJointe> pieceJointe = pieceJointeService.getPieceJointeById(id);
			if(pieceJointe.isPresent()) {
				return pieceJointe.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deletePieceJointeById(@PathVariable("id") final Long id) {
			try {
				pieceJointeService.deletePieceJointeById(id);
			} catch (Exception e) {
				System.out.println("PieceJointe " + id + " n'existe pas");
			}
		}
}
