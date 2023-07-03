package com.app.mission.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Equipement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_equip;
	
	@ManyToOne
	@JoinColumn(name = "id_mat")
	private Materiel materiel;
	private String nom_equip;
	private String statut;
	
	public Equipement() {
		
	}
	
	public Equipement(Long id_equip, Materiel materiel, String nom_equip, String statut) {
		super();
		this.id_equip = id_equip;
		this.materiel = materiel;
		this.nom_equip = nom_equip;
		this.statut = statut;
	}
	public Long getId_equip() {
		return id_equip;
	}
	public void setId_equip(Long id_equip) {
		this.id_equip = id_equip;
	}
	public Materiel getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}
	public String getNom_equip() {
		return nom_equip;
	}
	public void setNom_equip(String nom_equip) {
		this.nom_equip = nom_equip;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	
	
	
}
