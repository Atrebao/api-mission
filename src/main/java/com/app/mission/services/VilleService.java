package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Ville;
import com.app.mission.repository.VilleRepo;

import lombok.Data;

@Data
@Service
public class VilleService {
	
	private final VilleRepo villeRepo;
	
	@Autowired
	public VilleService(VilleRepo villeRepo) {
		this.villeRepo = villeRepo;
	}
	
	public Ville addVille(Ville ville) {
		return villeRepo.save(ville);
	}
	
	public Iterable<Ville> getAllVille() {
		return villeRepo.findAll();
	}
	
	public Optional<Ville>  getVilleById(final Long id) {
		return villeRepo.findById(id);
	}
	
	public void deleteVilleById(final Long id) {
		villeRepo.deleteById(id);
	}
	
	public Ville updateVille(Ville ville) {
		return	villeRepo.save(ville);
	}
}
