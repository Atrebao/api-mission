package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Personnel;
import com.app.mission.repository.PersonnelRepo;

import lombok.Data;
@Data
@Service
public class PersonnelService {
	
	@Autowired
	private PersonnelRepo personnelRepo;
	
	public Optional<Personnel> getPersonnel(final Long id) {
		return personnelRepo.findById(id);
	}
	
	public Iterable<Personnel> getPersonnels(){
		return personnelRepo.findAll();
	}
	
	public void deletePersoneel(final Long id) {
		personnelRepo.deleteById(id);
	}
	
	public Personnel addPersonnel(Personnel peronnel) {
		return personnelRepo.save(peronnel);
	}
	
	public Personnel updtaPersonnel(Personnel peronnel) {
		return personnelRepo.save(peronnel);
	}
	
}
