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
	private Long id_ckeckConfigType;
	
	private String  nom_ckeckConfigType;
	
	@OneToMany(mappedBy ="id_ckeckListConfig")
	private List<CheckListConfig> checkListConfigs;
	
	
	

	public CheckConfigType(Long id_ckeckConfigType, String nom_ckeckConfigType) {
		super();
		this.id_ckeckConfigType = id_ckeckConfigType;
		this.nom_ckeckConfigType = nom_ckeckConfigType;
	}

	public CheckConfigType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CheckConfigType(Long id_ckeckConfigType, String nom_ckeckConfigType,
			List<CheckListConfig> checkListConfigs) {
		super();
		this.id_ckeckConfigType = id_ckeckConfigType;
		this.nom_ckeckConfigType = nom_ckeckConfigType;
		this.checkListConfigs = checkListConfigs;
	}

	public Long getId_ckeckConfigType() {
		return id_ckeckConfigType;
	}

	public void setId_ckeckConfigType(Long id_ckeckConfigType) {
		this.id_ckeckConfigType = id_ckeckConfigType;
	}

	public String getNom_ckeckConfigType() {
		return nom_ckeckConfigType;
	}

	public void setNom_ckeckConfigType(String nom_ckeckConfigType) {
		this.nom_ckeckConfigType = nom_ckeckConfigType;
	}

	public List<CheckListConfig> getCheckListConfigs() {
		return checkListConfigs;
	}

	public void setCheckListConfigs(List<CheckListConfig> checkListConfigs) {
		this.checkListConfigs = checkListConfigs;
	}
	
	
}
