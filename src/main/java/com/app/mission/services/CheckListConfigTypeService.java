package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.CheckConfigType;
import com.app.mission.model.CheckListConfig;
import com.app.mission.repository.CheckListConfigTypeRepo;

import lombok.Data;

@Data
@Service
public class CheckListConfigTypeService {
	
	private final CheckListConfigTypeRepo checkListConfigTypeRepo;
	
	@Autowired
	public CheckListConfigTypeService(CheckListConfigTypeRepo checkListConfigTypeRepo) {
		this.checkListConfigTypeRepo = checkListConfigTypeRepo;
	}
	
	public CheckConfigType addCheckListConfigType(CheckConfigType checkListConfigType) {
		return checkListConfigTypeRepo.save(checkListConfigType);
	}
	
	public Iterable<CheckConfigType> getAllCheckListConfigType() {
		return checkListConfigTypeRepo.findAll();
	}
	
	public Optional<CheckConfigType>  getCheckListConfigTypeById(final Long id) {
		return checkListConfigTypeRepo.findById(id);
	}
	
	public void deleteCheckListConfigById(final Long id) {
		checkListConfigTypeRepo.deleteById(id);
	}
	
	public CheckConfigType updateCheckListConfigType(CheckConfigType checkListConfigType) {
		return	checkListConfigTypeRepo.save(checkListConfigType);
	}
}
