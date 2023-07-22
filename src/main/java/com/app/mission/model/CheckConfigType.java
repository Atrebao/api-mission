package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CheckConfigType implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String  nom_ckeckConfigType;
	

		
	

	public CheckConfigType(Long id, String nom_ckeckConfigType) {
		super();
		this.id = id;
		this.nom_ckeckConfigType = nom_ckeckConfigType;
	}

	public CheckConfigType() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public CheckConfigType(Long id, String nom_ckeckConfigType,
		List<CheckListConfig> checkListConfigs) {
		super();
		this.id = id;
		this.nom_ckeckConfigType = nom_ckeckConfigType;

	}

	public Long getId_ckeckConfigType() {
		return id;
	}

	public void setId_ckeckConfigType(Long id) {
		this.id = id;
	}

	public String getNom_ckeckConfigType() {
		return nom_ckeckConfigType;
	}

	public void setNom_ckeckConfigType(String nom_ckeckConfigType) {
		this.nom_ckeckConfigType = nom_ckeckConfigType;
	}


	
}
