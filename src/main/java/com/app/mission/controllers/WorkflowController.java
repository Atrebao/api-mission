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

import com.app.mission.model.Workflow;
import com.app.mission.services.WorkflowService;

@RestController
@RequestMapping("/api/workflow")
public class WorkflowController {
	
	   @Autowired
	   private WorkflowService workflowService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Workflow> addWorkflow(@RequestBody Workflow workflow) {
	       Workflow newWorkflow = workflowService.addWorkflow(workflow);
	       return new ResponseEntity<>(newWorkflow, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Workflow updateWorkflowById(@PathVariable("id") final Long id, @RequestBody Workflow workflow) {
			Optional<Workflow> e = workflowService.getWorkflowById(id);
			if(e.isPresent()) {
				Workflow currentWorkflow = e.get();
				
				String libelle= workflow.getLibelle();
				if(libelle != null) {
					currentWorkflow.setLibelle(libelle);
					
				}
				
				currentWorkflow.setIsActive(workflow.getIsActive());
			

				workflowService.addWorkflow(currentWorkflow);
				return currentWorkflow;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Workflow updateAllWorkflowById(@PathVariable("id") final Long id, @RequestBody Workflow workflow) {
			Optional<Workflow> e = workflowService.getWorkflowById(id);
			if(e.isPresent()) {
				Workflow currentWorkflow = e.get();
				
				String libelle= workflow.getLibelle();
				if(libelle != null) {
					currentWorkflow.setLibelle(libelle);
					
				}
				
				currentWorkflow.setIsActive(workflow.getIsActive());
				currentWorkflow.setEtapes(workflow.getEtapes());

				workflowService.addWorkflow(currentWorkflow);
				return currentWorkflow;
			} else {
				return null;
			}
		}

		@GetMapping("/workflows")
		public Iterable<Workflow> getAllWorkflows() {
			return workflowService.getAllWorkflow();
		}
		
		@GetMapping("/workflow/{id}")
		public Workflow getWorkflowById(@PathVariable("id") final Long id) {
			Optional<Workflow> workflow = workflowService.getWorkflowById(id);
			if(workflow.isPresent()) {
				return workflow.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteWorkflowById(@PathVariable("id") final Long id) {
			try {
				workflowService.deleteWorkflowById(id);
			} catch (Exception e) {
				System.out.println("Workflow " + id + " n'existe pas");
			}
		}
}
