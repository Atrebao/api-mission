package com.app.mission.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_ville;
	
	private String nom_ville;
	
	@OneToMany(mappedBy ="id_mission")
	private List<Mission> missions;
	
	@OneToMany(mappedBy ="id_commune")
	private List<Commune> communes;

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ville(Long id_ville, String nom_ville) {
		super();
		this.id_ville = id_ville;
		this.nom_ville = nom_ville;
	}

	public Ville(Long id_ville, String nom_ville, List<Mission> missions, List<Commune> communes) {
		super();
		this.id_ville = id_ville;
		this.nom_ville = nom_ville;
		this.missions = missions;
		this.communes = communes;
	}

	public Long getId_ville() {
		return id_ville;
	}

	public void setId_ville(Long id_ville) {
		this.id_ville = id_ville;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public List<Commune> getCommunes() {
		return communes;
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}
	
	
}
