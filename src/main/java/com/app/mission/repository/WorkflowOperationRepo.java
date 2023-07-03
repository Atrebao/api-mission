package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.WorkflowOperation;

@Repository
public interface WorkflowOperationRepo extends JpaRepository<WorkflowOperation, Long>{

}
