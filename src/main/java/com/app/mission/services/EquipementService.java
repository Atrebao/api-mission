package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Equipement;
import com.app.mission.repository.EquipementRepo;

import lombok.Data;

@Data
@Service
public class EquipementService {
	@Autowired
	private EquipementRepo equipementRepo;
	
	public Optional<Equipement> getEquipement(final Long id) {
		return equipementRepo.findById(id);
	}
	
	public Iterable<Equipement> getEquipements(){
		return equipementRepo.findAll();
	}
	
	public void deleteEquipement(final Long id) {
		equipementRepo.deleteById(id);
	}
	
	public Equipement addEquipement(Equipement equipement) {
		return equipementRepo.save(equipement);
	}
	
	public Equipement updateEquipement(Equipement equipement) {
		return equipementRepo.save(equipement);
	}
}
