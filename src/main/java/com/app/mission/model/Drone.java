package com.app.mission.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
//@PrimaryKeyJoinColumn(name="id_mat")
public class Drone{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id_drone;
	
	/*
	 * @ManyToOne
		@JoinColumn(name = "id_mission")
		private Mission mission;
	 * */
	
	@OneToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;
		
	private String name;
	private String categorie;
	private String reference;
	private String statut;
	private String condition_vent_critique;
	private String type;
	
		

	public Drone() {}



	
	


	public Drone(Long id_drone, String name, String categorie, String reference, String statut,
			String condition_vent_critique, String type) {
		super();
		this.id_drone = id_drone;
		this.name = name;
		this.categorie = categorie;
		this.reference = reference;
		this.statut = statut;
		this.condition_vent_critique = condition_vent_critique;
		this.type = type;
	}







	public Drone(Long id_drone, Vol vol, String name, String categorie, String reference, String statut,
			String condition_vent_critique, String type) {
		super();
		this.id_drone = id_drone;
		this.vol = vol;
		this.name = name;
		this.categorie = categorie;
		this.reference = reference;
		this.statut = statut;
		this.condition_vent_critique = condition_vent_critique;
		this.type = type;
	}







	public String getCategotie() {
		return categorie;
	}



	public void setCategotie(String categotie) {
		this.categorie = categotie;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}



	public String getCondition_vent_critique() {
		return condition_vent_critique;
	}



	public void setCondition_vent_critique(String condition_vent_critique) {
		this.condition_vent_critique = condition_vent_critique;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Vol getVol() {
		return vol;
	}



	public void setVol(Vol vol) {
		this.vol = vol;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCategorie() {
		return categorie;
	}



	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
	
	
	

	
	
}
