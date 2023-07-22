package com.app.mission.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fonction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "fonction_generator")
	private Long id_fonction;
	
	private String nom;
	


	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(Long id_fonction, String nom_fonction) {
		super();
		this.id_fonction = id_fonction;
		this.nom = nom_fonction;
	}

	public Fonction(Long id_fonction, String nom_fonction, List<Personnel> personnels) {
		super();
		this.id_fonction = id_fonction;
		this.nom = nom_fonction;
	}

	public Long getId_fonction() {
		return id_fonction;
	}

	public void setId_fonction(Long id_fonction) {
		this.id_fonction = id_fonction;
	}

	public String getNom_fonction() {
		return nom;
	}

	public void setNom_fonction(String nom_fonction) {
		this.nom = nom_fonction;
	}


	
	
	
}
