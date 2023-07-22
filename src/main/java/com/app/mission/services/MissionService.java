package com.app.mission.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Client;
import com.app.mission.model.Mission;
import com.app.mission.model.Personnel;
import com.app.mission.model.Ville;
import com.app.mission.model.WorkflowOperation;
import com.app.mission.repository.ClientRepo;
import com.app.mission.repository.MissionRepo;
import com.app.mission.repository.PersonnelRepo;
import com.app.mission.repository.VilleRepo;
import com.app.mission.repository.WorkflowOperationRepo;

import lombok.Data;
@Data
@Service
public class MissionService {	
	List<Personnel> personnels = new ArrayList<Personnel>();
	private MissionRepo missionRepo;
	private ClientRepo clientRepo;
	private PersonnelRepo personnelRepo;
	private WorkflowOperationRepo workflowOperationRepo;
	private VilleRepo villeRepo;
	
	
	

	@Autowired
	public MissionService(MissionRepo missionRepo, ClientRepo clientRepo, PersonnelRepo personnelRepo,
			WorkflowOperationRepo workflowOperationRepo, VilleRepo villeRepo) {
		super();
		this.missionRepo = missionRepo;
		this.clientRepo = clientRepo;
		this.personnelRepo = personnelRepo;
		this.workflowOperationRepo = workflowOperationRepo;
		this.villeRepo = villeRepo;
	}

	public Mission	addMission(Mission mission) {
        
		
		return missionRepo.save(mission);
	}
	
	public Iterable<Mission> getMissions() {
		return  missionRepo.findAll();
	}
	
	public Mission updateMission(Mission mission) {
		return missionRepo.save(mission);
	}
	
	public Optional<Mission> getMission(Long id) {
		return  missionRepo.findById(id);
	}
	
	public void deleteMission(Long id) {
		missionRepo.deleteById(id);
	}
}
