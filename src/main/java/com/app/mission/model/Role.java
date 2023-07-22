package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_role;
	
	private ERole name;
	
	@ManyToMany(mappedBy ="roles")
	private List<User> utilisateurs;
	
	@ManyToMany(mappedBy ="roles")
	private List<Etape> etapes;
	
	@ManyToMany
	@JoinTable(name = "avoir_permission",
	joinColumns = @JoinColumn(name = "id_role"),
	inverseJoinColumns = @JoinColumn(name = "id_permission")
	)
	private List<Permission> permissions;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id_role, ERole nom_role) {
		super();
		this.id_role = id_role;
		this.name = nom_role;
	}

	public Role(Long id_role, ERole nom_role, List<User> utilisateurs, List<Etape> etapes,
			List<Permission> permissions) {
		super();
		this.id_role = id_role;
		this.name = nom_role;
		this.utilisateurs = utilisateurs;
		this.etapes = etapes;
		this.permissions = permissions;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}

	public ERole getNom_role() {
		return name;
	}

	public void setNom_role(ERole nom_role) {
		this.name = nom_role;
	}

	public List<User> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<User> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	
	
	
}
