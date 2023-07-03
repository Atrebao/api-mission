package com.app.mission.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_mat")
public class Drone extends Materiel{
	
	
	
	/*
	 * @ManyToOne
		@JoinColumn(name = "id_mission")
		private Mission mission;
	 * */
		

	private String categotie;
	private String reference;
	private String statut;
	private String condition_vent_critique;
	private String type;
	
		

	public Drone() {}



	public Drone(String categotie, String reference, String statut, String condition_vent_critique, String type) {
		super();
		this.categotie = categotie;
		this.reference = reference;
		this.statut = statut;
		this.condition_vent_critique = condition_vent_critique;
		this.type = type;
	}



	public String getCategotie() {
		return categotie;
	}



	public void setCategotie(String categotie) {
		this.categotie = categotie;
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
	
	
	
	
	

	
	
}
