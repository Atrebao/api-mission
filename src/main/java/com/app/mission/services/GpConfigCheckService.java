package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.GpConfigCheck;
import com.app.mission.repository.GpConfigCheckRepo;

import lombok.Data;

@Data
@Service
public class GpConfigCheckService {
	private final GpConfigCheckRepo gpConfigCheckRepo;
	
	@Autowired
	public GpConfigCheckService(GpConfigCheckRepo gpConfigCheckRepo) {
		this.gpConfigCheckRepo = gpConfigCheckRepo;
	}
	
	public GpConfigCheck addGpConfigCheck(GpConfigCheck gpConfigCheck) {
		return gpConfigCheckRepo.save(gpConfigCheck);
	}
	
	public Iterable<GpConfigCheck> getAllGpConfigCheck() {
		return gpConfigCheckRepo.findAll();
	}
	
	public Optional<GpConfigCheck>  getGpConfigCheckById(final Long id) {
		return gpConfigCheckRepo.findById(id);
	}
	
	public void deleteGpConfigCheckById(final Long id) {
		gpConfigCheckRepo.deleteById(id);
	}
	
	public GpConfigCheck updateGpConfigCheck(GpConfigCheck gpConfigCheck) {
		return	gpConfigCheckRepo.save(gpConfigCheck);
	}
}
