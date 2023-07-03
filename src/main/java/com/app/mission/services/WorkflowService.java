package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Workflow;
import com.app.mission.repository.WorkflowRepo;

import lombok.Data;

@Data
@Service
public class WorkflowService {
	private final WorkflowRepo workflowRepo;
	
	@Autowired
	public WorkflowService(WorkflowRepo workflowRepo) {
		this.workflowRepo = workflowRepo;
	}
	
	public Workflow addWorkflow(Workflow workflow) {
		return workflowRepo.save(workflow);
	}
	
	public Iterable<Workflow> getAllWorkflow() {
		return workflowRepo.findAll();
	}
	
	public Optional<Workflow>  getWorkflowById(final Long id) {
		return workflowRepo.findById(id);
	}
	
	public void deleteWorkflowById(final Long id) {
		workflowRepo.deleteById(id);
	}
	
	public Workflow updateWorkflow(Workflow workflow) {
		return	workflowRepo.save(workflow);
	}
}
