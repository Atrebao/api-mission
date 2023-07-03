package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_client;
	
	@OneToMany(mappedBy ="id_mission")
	private List<Mission> missions;
	
	private String nom_client;
	private String contact_client;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(Long id_client, String nom_client, String contact_client) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.contact_client = contact_client;
	}

	public Client(Long id_client, List<Mission> missions, String nom_client, String contact_client) {
		super();
		this.id_client = id_client;
		this.missions = missions;
		this.nom_client = nom_client;
		this.contact_client = contact_client;
	}

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getContact_client() {
		return contact_client;
	}

	public void setContact_client(String contact_client) {
		this.contact_client = contact_client;
	}

	
	
	
	

}
