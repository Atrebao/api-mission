package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Personnel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_personnel;
	
	
	
	@ManyToMany
	@JoinTable(
			name= "effectuer_mission",
			joinColumns= @JoinColumn(name="id_personnel"),
			inverseJoinColumns= @JoinColumn(name="id_mission")
			)
	private List<Mission> missions;
	
	
	@OneToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilsateur;
	
	@ManyToMany
	@JoinTable(
			name= "avoir_fonction",
			joinColumns= @JoinColumn(name="id_personnel"),
			inverseJoinColumns= @JoinColumn(name ="id_fonction")
			)
	private List<Fonction> fonctions;
	

	 
	
	/*
	 * 	@ManyToOne
	@JoinColumn(name="id_mission")
	private Mission mission;
	 * */
	
	public Personnel() {}

	
	public Personnel(Long id_personnel,  String nom_personnel, String prenoms_personnel,
			String competences, String visa) {
		super();
		this.id_personnel = id_personnel;
		this.nom_personnel = nom_personnel;
		this.prenoms_personnel = prenoms_personnel;
		this.competences = competences;
		this.visa = visa;
	
	}
	
	
	
	public Personnel(Long id_personnel, List<Mission> missions, Utilisateur utilsateur, List<Fonction> fonctions,
			String nom_personnel, String prenoms_personnel, String competences, String visa) {
		super();
		this.id_personnel = id_personnel;
		this.missions = missions;
		this.utilsateur = utilsateur;
		this.fonctions = fonctions;
		this.nom_personnel = nom_personnel;
		this.prenoms_personnel = prenoms_personnel;
		this.competences = competences;
		this.visa = visa;
	}



	private String nom_personnel;
	private String prenoms_personnel;
	private String competences;
	private String visa;

	public Long getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(Long id_personnel) {
		this.id_personnel = id_personnel;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public String getNom_personnel() {
		return nom_personnel;
	}
	public void setNom_personnel(String nom_personnel) {
		this.nom_personnel = nom_personnel;
	}
	public String getPrenoms_personnel() {
		return prenoms_personnel;
	}
	public void setPrenoms_personnel(String prenoms_personnel) {
		this.prenoms_personnel = prenoms_personnel;
	}
	public String getCompetences() {
		return competences;
	}
	public void setCompetences(String competences) {
		this.competences = competences;
	}
	public Utilisateur getUtilsateur() {
		return utilsateur;
	}


	public void setUtilsateur(Utilisateur utilsateur) {
		this.utilsateur = utilsateur;
	}


	public List<Fonction> getFonctions() {
		return fonctions;
	}


	public void setFonctions(List<Fonction> fonctions) {
		this.fonctions = fonctions;
	}


	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}

	
	
	
	
	
	

}
