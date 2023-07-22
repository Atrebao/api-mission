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

import com.app.mission.model.WorkflowOperation;
import com.app.mission.services.WorkflowOperationService;

@RestController
@RequestMapping("/api/workflowOperation")
public class WorkflowOperationController {
	
	  @Autowired
	   private WorkflowOperationService workflowOperationService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<WorkflowOperation> addWorkflowOperation(@RequestBody WorkflowOperation workflowOperation) {
	       WorkflowOperation newWorkflowOperation = workflowOperationService.addWorkflowOperation(workflowOperation);
	       return new ResponseEntity<>(newWorkflowOperation, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public WorkflowOperation updateWorkflowOperationById(@PathVariable("id") final Long id, @RequestBody WorkflowOperation workflowOperation) {
			Optional<WorkflowOperation> e = workflowOperationService.getWorkflowOperationById(id);
			if(e.isPresent()) {
				WorkflowOperation currentWorkflowOperation = e.get();
				

				currentWorkflowOperation.setIsActive(workflowOperation.getIsActive());
				currentWorkflowOperation.setDataJson(workflowOperation.getDataJson());
				currentWorkflowOperation.setDate_creation(workflowOperation.getDate_creation());
				currentWorkflowOperation.setDate_miseAjour(workflowOperation.getDate_miseAjour());
				currentWorkflowOperation.setId_userInsert(workflowOperation.getId_userInsert());
				currentWorkflowOperation.setId_userUpdate(workflowOperation.getId_userUpdate());
				
				
		

				workflowOperationService.addWorkflowOperation(currentWorkflowOperation);
				return currentWorkflowOperation;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public WorkflowOperation updateAllWorkflowOperationById(@PathVariable("id") final Long id, @RequestBody WorkflowOperation workflowOperation) {
			Optional<WorkflowOperation> e = workflowOperationService.getWorkflowOperationById(id);
			if(e.isPresent()) {
				WorkflowOperation currentWorkflowOperation = e.get();
				
			
				currentWorkflowOperation.setDataJson(workflowOperation.getDataJson());
				currentWorkflowOperation.setDate_creation(workflowOperation.getDate_creation());
				currentWorkflowOperation.setDate_miseAjour(workflowOperation.getDate_miseAjour());
				
				
				currentWorkflowOperation.setEtape(workflowOperation.getEtape());
				
				currentWorkflowOperation.setId_userInsert(workflowOperation.getId_userInsert());
				currentWorkflowOperation.setId_userUpdate(workflowOperation.getId_userUpdate());
				
				currentWorkflowOperation.setIsActive(workflowOperation.getIsActive());
				
				currentWorkflowOperation.setMission(workflowOperation.getMission());
				currentWorkflowOperation.setPieceJointes(workflowOperation.getPieceJointes());
				currentWorkflowOperation.setUtilisateurs(workflowOperation.getUtilisateurs());
				
				

				workflowOperationService.addWorkflowOperation(currentWorkflowOperation);
				return currentWorkflowOperation;
			} else {
				return null;
			}
		}

		@GetMapping("/workflowOperations")
		public Iterable<WorkflowOperation> getAllWorkflowOperations() {
			return workflowOperationService.getAllWorkflowOperation();
		}
		
		@GetMapping("/workflowOperation/{id}")
		public WorkflowOperation getWorkflowOperationById(@PathVariable("id") final Long id) {
			Optional<WorkflowOperation> workflowOperation = workflowOperationService.getWorkflowOperationById(id);
			if(workflowOperation.isPresent()) {
				return workflowOperation.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteWorkflowOperationById(@PathVariable("id") final Long id) {
			try {
				workflowOperationService.deleteWorkflowOperationById(id);
			} catch (Exception e) {
				System.out.println("WorkflowOperation " + id + " n'existe pas");
			}
		}
	
}
