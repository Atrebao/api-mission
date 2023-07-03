package com.app.mission.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Obstacles implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_obst;
	
	@ManyToOne
	@JoinColumn(name = "id_mission")
	private Mission mission;
	
	private String nom_obst;
	private String type_obst;
	private String haute_obst;
	private String meprise_obst;
	
	public Obstacles() {
		
	}
	
	public Obstacles(Long id_obst, Mission mission, String nom_obst, String type_obst, String haute_obst,
			String meprise_obst) {
		super();
		this.id_obst = id_obst;
		this.mission = mission;
		this.nom_obst = nom_obst;
		this.type_obst = type_obst;
		this.haute_obst = haute_obst;
		this.meprise_obst = meprise_obst;
	}
	public Long getId_obst() {
		return id_obst;
	}
	public void setId_obst(Long id_obst) {
		this.id_obst = id_obst;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getNom_obst() {
		return nom_obst;
	}
	public void setNom_obst(String nom_obst) {
		this.nom_obst = nom_obst;
	}
	public String getType_obst() {
		return type_obst;
	}
	public void setType_obst(String type_obst) {
		this.type_obst = type_obst;
	}
	public String getHaute_obst() {
		return haute_obst;
	}
	public void setHaute_obst(String haute_obst) {
		this.haute_obst = haute_obst;
	}
	public String getMeprise_obst() {
		return meprise_obst;
	}
	public void setMeprise_obst(String meprise_obst) {
		this.meprise_obst = meprise_obst;
	}
	
	
	
	
}
