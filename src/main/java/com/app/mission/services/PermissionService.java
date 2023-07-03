package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Permission;
import com.app.mission.repository.PermissionRepo;

import lombok.Data;

@Data
@Service
public class PermissionService {
	private final PermissionRepo permissionRepo;
	
	@Autowired
	public PermissionService(PermissionRepo permissionRepo) {
		this.permissionRepo = permissionRepo;
	}
	
	public Permission addPermission(Permission permission) {
		return permissionRepo.save(permission);
	}
	
	public Iterable<Permission> getAllPermission() {
		return permissionRepo.findAll();
	}
	
	public Optional<Permission>  getPermissionById(final Long id) {
		return permissionRepo.findById(id);
	}
	
	public void deletePermissionById(final Long id) {
		permissionRepo.deleteById(id);
	}
	
	public Permission updatePermission(Permission permission) {
		return	permissionRepo.save(permission);
	}
}
