package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.CheckConfigType;
import com.app.mission.model.Commune;
import com.app.mission.repository.CommuneRepo;

import lombok.Data;

@Data
@Service
public class CommuneService {
	
	private final CommuneRepo communeRepo;
	
	@Autowired
	public CommuneService(CommuneRepo communeRepo) {
		this.communeRepo = communeRepo;
	}
	
	public Commune addCommune(Commune commune) {
		return communeRepo.save(commune);
	}
	
	public Iterable<Commune> getAllCommune() {
		return communeRepo.findAll();
	}
	
	public Optional<Commune>  getCommuneById(final Long id) {
		return communeRepo.findById(id);
	}
	
	public void deleteCommuneById(final Long id) {
		communeRepo.deleteById(id);
	}
	
	public Commune updateCommune(Commune commune) {
		return	communeRepo.save(commune);
	}
}
