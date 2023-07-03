package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Etape;
import com.app.mission.repository.EtapeRepo;

import lombok.Data;

@Data
@Service
public class EtapeService {
	
	private final EtapeRepo etapeRepo;
	
	@Autowired
	public EtapeService(EtapeRepo etapeRepo) {
		this.etapeRepo = etapeRepo;
	}
	
	public Etape addEtape(Etape etape) {
		return etapeRepo.save(etape);
	}
	
	public Iterable<Etape> getAllEtape() {
		return etapeRepo.findAll();
	}
	
	public Optional<Etape>  getEtapeById(final Long id) {
		return etapeRepo.findById(id);
	}
	
	public void deleteEtapeById(final Long id) {
		etapeRepo.deleteById(id);
	}
	
	public Etape updateEtape(Etape etape) {
		return	etapeRepo.save(etape);
	}
}
