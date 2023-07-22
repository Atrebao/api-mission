package com.app.mission.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ville_generator")
	private Long id_ville;
	
	@Column(name = "nom_ville")
	private String nom_ville;
	
	@OneToMany(targetEntity = Mission.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "idMission")
	@JsonIgnore
	private Set<Mission> missions = new HashSet<>();
	
	@OneToMany(mappedBy ="id_commune")
	@JsonIgnore
	private List<Commune> communes;

	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Ville(Long id_ville, String nom_ville) {
		super();
		this.id_ville = id_ville;
		this.nom_ville = nom_ville;
	}





	
	  public Ville(Long id_ville, String nom_ville, Set<Mission> missions, List<Commune> communes) {
		super();
		this.id_ville = id_ville;
		this.nom_ville = nom_ville;
		this.missions = missions;
		this.communes = communes;
	}




	public void addMission(Mission mission) {
		    this.missions.add(mission);
		  }
		  
	


	public Long getId_ville() {
		return id_ville;
	}

	public void setId_ville(Long id_ville) {
		this.id_ville = id_ville;
	}

	public String getNom_ville() {
		return nom_ville;
	}

	public void setNom_ville(String nom_ville) {
		this.nom_ville = nom_ville;
	}



	public Set<Mission> getMissions() {
		return missions;
	}




	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}




	public List<Commune> getCommunes() {
		return communes;
	}

	public void setCommunes(List<Commune> communes) {
		this.communes = communes;
	}
	
	
}
