package com.app.mission.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Fonction {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id_fonction;
	
	private String nom_fonction;
	
	@ManyToMany(mappedBy="fonctions")
	private List<Personnel> personnels;

	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(Long id_fonction, String nom_fonction) {
		super();
		this.id_fonction = id_fonction;
		this.nom_fonction = nom_fonction;
	}

	public Fonction(Long id_fonction, String nom_fonction, List<Personnel> personnels) {
		super();
		this.id_fonction = id_fonction;
		this.nom_fonction = nom_fonction;
		this.personnels = personnels;
	}

	public Long getId_fonction() {
		return id_fonction;
	}

	public void setId_fonction(Long id_fonction) {
		this.id_fonction = id_fonction;
	}

	public String getNom_fonction() {
		return nom_fonction;
	}

	public void setNom_fonction(String nom_fonction) {
		this.nom_fonction = nom_fonction;
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}
	
	
	
}
