package com.app.mission.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mission.model.ERole;
import com.app.mission.model.Role;
import com.app.mission.services.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	   @Autowired
	   private RoleService roleService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Role> addRole(@RequestBody Role role) {
	       Role newRole = roleService.addRole(role);
	       return new ResponseEntity<>(newRole, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Role updateRoleById(@PathVariable("id") final Long id, @RequestBody Role role) {
			Optional<Role> e = roleService.getRoleById(id);
			if(e.isPresent()) {
				Role currentRole = e.get();
				
				ERole nom = role.getNom_role();
				if(nom != null) {
					currentRole.setNom_role(nom);
					
				}
				
				
			

				roleService.addRole(currentRole);
				return currentRole;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Role updateAllRoleById(@PathVariable("id") final Long id, @RequestBody Role role) {
			Optional<Role> e = roleService.getRoleById(id);
			if(e.isPresent()) {
				Role currentRole = e.get();
				
				ERole nom = role.getNom_role();
				if(nom != null) {
					currentRole.setNom_role(nom);
					
				}
				currentRole.setPermissions(role.getPermissions());
				currentRole.setEtapes(role.getEtapes());

				roleService.addRole(currentRole);
				return currentRole;
			} else {
				return null;
			}
		}

		@GetMapping("/roles")
		public Iterable<Role> getAllRoles() {
			return roleService.getAllRole();
		}
		
		@GetMapping("/role/{id}")
		public Role getRoleById(@PathVariable("id") final Long id) {
			Optional<Role> role = roleService.getRoleById(id);
			if(role.isPresent()) {
				return role.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deleteRoleById(@PathVariable("id") final Long id) {
			try {
				roleService.deleteRoleById(id);
			} catch (Exception e) {
				System.out.println("Role " + id + " n'existe pas");
			}
		}
}
