package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Role;
import com.app.mission.repository.RoleRepo;

import lombok.Data;

@Data
@Service
public class RoleService {
	private final RoleRepo roleRepo;
	
	@Autowired
	public RoleService(RoleRepo roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}
	
	public Iterable<Role> getAllRole() {
		return roleRepo.findAll();
	}
	
	public Optional<Role>  getRoleById(final Long id) {
		return roleRepo.findById(id);
	}
	
	public void deleteRoleById(final Long id) {
		roleRepo.deleteById(id);
	}
	
	public Role updateRole(Role role) {
		return	roleRepo.save(role);
	}
}
