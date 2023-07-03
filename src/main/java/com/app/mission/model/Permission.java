package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_permission;
	
	private String nom_permission;
	
	@ManyToMany(mappedBy = "permissions")
	private List<Role> roles;

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(Long id_permission, String nom_permission) {
		super();
		this.id_permission = id_permission;
		this.nom_permission = nom_permission;
	}

	public Permission(Long id_permission, String nom_permission, List<Role> roles) {
		super();
		this.id_permission = id_permission;
		this.nom_permission = nom_permission;
		this.roles = roles;
	}

	public Long getId_permission() {
		return id_permission;
	}

	public void setId_permission(Long id_permission) {
		this.id_permission = id_permission;
	}

	public String getNom_permission() {
		return nom_permission;
	}

	public void setNom_permission(String nom_permission) {
		this.nom_permission = nom_permission;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
