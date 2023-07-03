package com.app.mission.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Materiel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//Cette strategie est utlisé pour les les classes parent
	private Long id_mat;
	
	@ManyToOne
	@JoinColumn(name = "id_mission")
	private Mission mission;
	
	@OneToMany(mappedBy = "id_equip")
	private List<Equipement> equipements; 
	
	private String designation_mat;
	private String date_heure_sortie;
	private String  date_heure_retour;
	private int quatite;
	private String etat_marche_mat;
	

	
	
	public Materiel() {}





	public Materiel(Long id_mat, String designation_mat, String date_heure_sortie, String date_heure_retour,
			int quatite, String etat_marche_mat) {
		super();
		this.id_mat = id_mat;
		this.designation_mat = designation_mat;
		this.date_heure_sortie = date_heure_sortie;
		this.date_heure_retour = date_heure_retour;
		this.quatite = quatite;
		this.etat_marche_mat = etat_marche_mat;
	}





	public Materiel(Long id_mat, Mission mission, List<Equipement> equipements, String designation_mat,
			String date_heure_sortie, String date_heure_retour, int quatite, String etat_marche_mat) {
		super();
		this.id_mat = id_mat;
		this.mission = mission;
		this.equipements = equipements;
		this.designation_mat = designation_mat;
		this.date_heure_sortie = date_heure_sortie;
		this.date_heure_retour = date_heure_retour;
		this.quatite = quatite;
		this.etat_marche_mat = etat_marche_mat;
	}





	public Long getId_mat() {
		return id_mat;
	}





	public void setId_mat(Long id_mat) {
		this.id_mat = id_mat;
	}





	public Mission getMission() {
		return mission;
	}





	public void setMission(Mission mission) {
		this.mission = mission;
	}





	public List<Equipement> getEquipements() {
		return equipements;
	}





	public void setEquipements(List<Equipement> equipements) {
		this.equipements = equipements;
	}





	public String getDesignation_mat() {
		return designation_mat;
	}





	public void setDesignation_mat(String designation_mat) {
		this.designation_mat = designation_mat;
	}





	public String getDate_heure_sortie() {
		return date_heure_sortie;
	}





	public void setDate_heure_sortie(String date_heure_sortie) {
		this.date_heure_sortie = date_heure_sortie;
	}





	public String getDate_heure_retour() {
		return date_heure_retour;
	}





	public void setDate_heure_retour(String date_heure_retour) {
		this.date_heure_retour = date_heure_retour;
	}





	public int getQuatite() {
		return quatite;
	}





	public void setQuatite(int quatite) {
		this.quatite = quatite;
	}





	public String getEtat_marche_mat() {
		return etat_marche_mat;
	}





	public void setEtat_marche_mat(String etat_marche_mat) {
		this.etat_marche_mat = etat_marche_mat;
	}
	
	

	
	
	
}
