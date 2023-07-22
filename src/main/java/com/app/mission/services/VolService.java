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
	
	public Optional<Vol> getVol(final Long id) {
		return volRepo.findById(id);
	}
	
	public Iterable<Vol> getVols(){
		return volRepo.findAll();
	}
	
	public void deleteVol(final Long id) {
		volRepo.deleteById(id);
	}
	
	public Vol addVol(Vol vol) {
		return volRepo.save(vol);
	}
	
	public Vol updtaVol(Vol vol) {
		return volRepo.save(vol);
	}
}
