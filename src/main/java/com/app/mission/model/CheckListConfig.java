package com.app.mission.model;

import java.io.Serializable;

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
public class CheckListConfig implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_ckeckListConfig;
	
	private String libelle;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "idMission", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	private Mission mission;
	
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idGpConfig")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private GpConfigCheck gpConfigCheck;
	
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_ckeckConfigType")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private CheckConfigType ckeckConfigType;

	public CheckListConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckListConfig(Long id_ckeckListConfig, String libelle) {
		super();
		this.id_ckeckListConfig = id_ckeckListConfig;
		this.libelle = libelle;
	}

	public CheckListConfig(Long id_ckeckListConfig, String libelle, Mission mission, GpConfigCheck gpConfigCheck,
			CheckConfigType ckeckConfigType) {
		super();
		this.id_ckeckListConfig = id_ckeckListConfig;
		this.libelle = libelle;
		this.mission = mission;
		this.gpConfigCheck = gpConfigCheck;
		this.ckeckConfigType = ckeckConfigType;
	}

	public Long getId_ckeckListConfig() {
		return id_ckeckListConfig;
	}

	public void setId_ckeckListConfig(Long id_ckeckListConfig) {
		this.id_ckeckListConfig = id_ckeckListConfig;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public GpConfigCheck getGpConfigCheck() {
		return gpConfigCheck;
	}

	public void setGpConfigCheck(GpConfigCheck gpConfigCheck) {
		this.gpConfigCheck = gpConfigCheck;
	}

	public CheckConfigType getCkeckConfigType() {
		return ckeckConfigType;
	}

	public void setCkeckConfigType(CheckConfigType ckeckConfigType) {
		this.ckeckConfigType = ckeckConfigType;
	}
	
	
	
	
}
