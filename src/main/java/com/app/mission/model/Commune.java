package com.app.mission.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commune;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "id_ville", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Ville ville;
	
	private String nom_commune;

	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commune(Long id_commune, String nom_commune) {
		super();
		this.id_commune = id_commune;
		this.nom_commune = nom_commune;
	}

	public Commune(Long id_commune, Ville ville, String nom_commune) {
		super();
		this.id_commune = id_commune;
		this.ville = ville;
		this.nom_commune = nom_commune;
	}

	public Long getId_commune() {
		return id_commune;
	}

	public void setId_commune(Long id_commune) {
		this.id_commune = id_commune;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}
	
	
}
