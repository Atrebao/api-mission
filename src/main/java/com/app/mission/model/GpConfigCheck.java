package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GpConfigCheck implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGpConfig;
	
	private String nom_GpConfig;
	
	@OneToMany(mappedBy ="id_ckeckListConfig")
	private List<CheckListConfig> checkListConfigs;

	public GpConfigCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GpConfigCheck(Long idGpConfig, String nom_GpConfig) {
		super();
		this.idGpConfig = idGpConfig;
		this.nom_GpConfig = nom_GpConfig;
	}

	public GpConfigCheck(Long idGpConfig, String nom_GpConfig, List<CheckListConfig> checkListConfigs) {
		super();
		this.idGpConfig = idGpConfig;
		this.nom_GpConfig = nom_GpConfig;
		this.checkListConfigs = checkListConfigs;
	}

	public Long getIdGpConfig() {
		return idGpConfig;
	}

	public void setIdGpConfig(Long idGpConfig) {
		this.idGpConfig = idGpConfig;
	}

	public String getNom_GpConfig() {
		return nom_GpConfig;
	}

	public void setNom_GpConfig(String nom_GpConfig) {
		this.nom_GpConfig = nom_GpConfig;
	}

	public List<CheckListConfig> getCheckListConfigs() {
		return checkListConfigs;
	}

	public void setCheckListConfigs(List<CheckListConfig> checkListConfigs) {
		this.checkListConfigs = checkListConfigs;
	}
	
	
	
}
