package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Fonction;
import com.app.mission.repository.FonctionRepo;

import lombok.Data;

@Data
@Service
public class FonctionService {
	private final FonctionRepo fonctionRepo;
	
	@Autowired
	public FonctionService(FonctionRepo fonctionRepo) {
		this.fonctionRepo = fonctionRepo;
	}
	
	public Fonction addFonction(Fonction fonction) {
		return fonctionRepo.save(fonction);
	}
	
	public Iterable<Fonction> getAllFonction() {
		return fonctionRepo.findAll();
	}
	
	public Optional<Fonction>  getFonctionById(final Long id) {
		return fonctionRepo.findById(id);
	}
	
	public Optional<Fonction> getFonctionByName(String name) {
		return fonctionRepo.findByNom(name);
	}
	
	public void deleteFonctionById(final Long id) {
		fonctionRepo.deleteById(id);
	}
	
	public Fonction updateFonction(Fonction fonction) {
		return	fonctionRepo.save(fonction);
	}
}
