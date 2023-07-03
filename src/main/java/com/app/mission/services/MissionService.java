package com.app.mission.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Mission;
import com.app.mission.repository.MissionRepo;

import lombok.Data;
@Data
@Service
public class MissionService {	
	@Autowired
	private MissionRepo missionRepo;

	
	public Mission	addMission(Mission mission) {
		//mission.setCode_mission(UUID.randomUUID().toString());
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
