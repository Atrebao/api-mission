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

import com.app.mission.model.Permission;
import com.app.mission.services.PermissionService;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
	   @Autowired
	   private PermissionService permissionService;
	   
	   @PostMapping("/add")
	   public ResponseEntity<Permission> addPermission(@RequestBody Permission permission) {
	       Permission newPermission = permissionService.addPermission(permission);
	       return new ResponseEntity<>(newPermission, HttpStatus.CREATED);
	   }
		
		@PutMapping("/update/{id}")
		public Permission updatePermissionById(@PathVariable("id") final Long id, @RequestBody Permission permission) {
			Optional<Permission> e = permissionService.getPermissionById(id);
			if(e.isPresent()) {
				Permission currentPermission = e.get();
				
				String nom = permission.getNom_permission();
				if(nom != null) {
					currentPermission.setNom_permission(nom);
					
				}
				

				permissionService.addPermission(currentPermission);
				return currentPermission;
			} else {
				return null;
			}
		}
		
		@PutMapping("/updateAll/{id}")
		public Permission updateAllPermissionById(@PathVariable("id") final Long id, @RequestBody Permission permission) {
			Optional<Permission> e = permissionService.getPermissionById(id);
			if(e.isPresent()) {
				Permission currentPermission = e.get();
				
				String nom = permission.getNom_permission();
				if(nom != null) {
					currentPermission.setNom_permission(nom);
					
				}
				currentPermission.setRoles(permission.getRoles());
				

				permissionService.addPermission(currentPermission);
				return currentPermission;
			} else {
				return null;
			}
		}

		@GetMapping("/permissions")
		public Iterable<Permission> getAllPermissions() {
			return permissionService.getAllPermission();
		}
		
		@GetMapping("/permission/{id}")
		public Permission getPermissionById(@PathVariable("id") final Long id) {
			Optional<Permission> permission = permissionService.getPermissionById(id);
			if(permission.isPresent()) {
				return permission.get();
			} else {
				return null;
			}
		}
		
		@DeleteMapping("/delete/{id}")
		public void deletePermissionById(@PathVariable("id") final Long id) {
			try {
				permissionService.deletePermissionById(id);
			} catch (Exception e) {
				System.out.println("Permission " + id + " n'existe pas");
			}
		}
}
