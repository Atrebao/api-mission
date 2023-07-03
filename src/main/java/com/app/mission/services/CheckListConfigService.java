package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.CheckListConfig;
import com.app.mission.repository.CheckListConfigRepo;

import lombok.Data;

@Data
@Service
public class CheckListConfigService {
	
	private final CheckListConfigRepo checkListConfigRepo;
	
	@Autowired
	public CheckListConfigService(CheckListConfigRepo checkListConfigRepo) {
		this.checkListConfigRepo = checkListConfigRepo;
	}
	
	public CheckListConfig addCheckListConfig(CheckListConfig checkListConfig) {
		return checkListConfigRepo.save(checkListConfig);
	}
	
	public Iterable<CheckListConfig> getAllCheckListConfig() {
		return checkListConfigRepo.findAll();
	}
	
	public Optional<CheckListConfig>  getCheckListConfigById(final Long id) {
		return checkListConfigRepo.findById(id);
	}
	
	public void deleteCheckListConfigById(final Long id) {
		checkListConfigRepo.deleteById(id);
	}
	
	public CheckListConfig updateCheckListConfig(final CheckListConfig checkListConfig) {
		return checkListConfigRepo.save(checkListConfig);
	}
	
	
}
