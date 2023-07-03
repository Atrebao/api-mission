package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Workflow implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_workflow;
	
	private String libelle;
	private Boolean isActive;
	
	@OneToMany(mappedBy ="id_etape")
	private List<Etape> etapes;

	public Workflow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Workflow(Long id_workflow, String libelle, Boolean isActive) {
		super();
		this.id_workflow = id_workflow;
		this.libelle = libelle;
		this.isActive = isActive;
	}

	public Workflow(Long id_workflow, String libelle, Boolean isActive, List<Etape> etapes) {
		super();
		this.id_workflow = id_workflow;
		this.libelle = libelle;
		this.isActive = isActive;
		this.etapes = etapes;
	}

	public Long getId_workflow() {
		return id_workflow;
	}

	public void setId_workflow(Long id_workflow) {
		this.id_workflow = id_workflow;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}
	
	
	
}
