package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.WorkflowOperation;
import com.app.mission.repository.WorkflowOperationRepo;

import lombok.Data;

@Data
@Service
public class WorkflowOperationService {
	
	private final WorkflowOperationRepo workflowOperationRepo;
	
	@Autowired
	public WorkflowOperationService(WorkflowOperationRepo workflowOperationRepo) {
		this.workflowOperationRepo = workflowOperationRepo;
	}
	
	public WorkflowOperation addWorkflowOperation(WorkflowOperation workflowOperation) {
		return workflowOperationRepo.save(workflowOperation);
	}
	
	public Iterable<WorkflowOperation> getAllWorkflowOperation() {
		return workflowOperationRepo.findAll();
	}
	
	public Optional<WorkflowOperation>  getWorkflowOperationById(final Long id) {
		return workflowOperationRepo.findById(id);
	}
	
	public void deleteWorkflowOperationById(final Long id) {
		workflowOperationRepo.deleteById(id);
	}
	
	public WorkflowOperation updateWorkflowOperation(WorkflowOperation workflowOperation) {
		return	workflowOperationRepo.save(workflowOperation);
	}
}
