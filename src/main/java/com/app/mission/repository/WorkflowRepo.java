package com.app.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mission.model.Workflow;

@Repository
public interface WorkflowRepo extends JpaRepository<Workflow, Long>{

}
