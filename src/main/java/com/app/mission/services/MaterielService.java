package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Materiel;
import com.app.mission.repository.MaterielRepo;

import lombok.Data;

@Data
@Service
public class MaterielService {
	private final MaterielRepo materielRepo;
	
	@Autowired
	public MaterielService(MaterielRepo materielRepo) {
		this.materielRepo = materielRepo;
	}
	
	public Materiel addMateriel(Materiel materiel) {
		return materielRepo.save(materiel);
	}
	
	public Iterable<Materiel> getAllMateriel() {
		return materielRepo.findAll();
	}
	
	public Optional<Materiel>  getMaterielById(final Long id) {
		return materielRepo.findById(id);
	}
	
	public void deleteMaterielById(final Long id) {
		materielRepo.deleteById(id);
	}
	
	public Materiel updateMateriel(Materiel materiel) {
		return	materielRepo.save(materiel);
	}
}
