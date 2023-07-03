package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Vol;
import com.app.mission.repository.VolRepo;

import lombok.Data;

@Data
@Service
public class VolService {
	@Autowired
	private VolRepo volRepo;
	
	public Optional<Vol> getPersonnel(final Long id) {
		return volRepo.findById(id);
	}
	
	public Iterable<Vol> getPersonnels(){
		return volRepo.findAll();
	}
	
	public void deletePersoneel(final Long id) {
		volRepo.deleteById(id);
	}
	
	public Vol addPersonnel(Vol vol) {
		return volRepo.save(vol);
	}
	
	public Vol updtaPersonnel(Vol vol) {
		return volRepo.save(vol);
	}
}
