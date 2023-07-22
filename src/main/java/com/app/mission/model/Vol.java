package com.app.mission.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Vol implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vol;
	
	 @ManyToOne
	 @OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name="idMission")
	private Mission mission;
	

	private int hauteur_vol_retenue;
	private String heure_decollage;
	private String heure_atterissage;
	private int pourcentage_batteie;
	private int GSD;
	private String chevauchement;
	private int vitesse;
	private int inclinaison_camera;

	
	public Vol() {
		
	}
	
	
	
	public Vol(Long id_vol, int hauteur_vol_retenue, String heure_decollage, String heure_atterissage,
			int pourcentage_batteie, int gSD, String chevauchement, int vitesse, int inclinaison_camera) {
		super();
		this.id_vol = id_vol;
		this.hauteur_vol_retenue = hauteur_vol_retenue;
		this.heure_decollage = heure_decollage;
		this.heure_atterissage = heure_atterissage;
		this.pourcentage_batteie = pourcentage_batteie;
		GSD = gSD;
		this.chevauchement = chevauchement;
		this.vitesse = vitesse;
		this.inclinaison_camera = inclinaison_camera;

	}




	public Vol(Long id_vol, Mission mission, Drone drone, int hauteur_vol_retenue, String heure_decollage,
			String heure_atterissage, int pourcentage_batteie, int gSD, String chevauchement, int vitesse,
			int inclinaison_camera) {
		super();
		this.id_vol = id_vol;
		this.mission = mission;
		this.hauteur_vol_retenue = hauteur_vol_retenue;
		this.heure_decollage = heure_decollage;
		this.heure_atterissage = heure_atterissage;
		this.pourcentage_batteie = pourcentage_batteie;
		this.GSD = gSD;
		this.chevauchement = chevauchement;
		this.vitesse = vitesse;
		this.inclinaison_camera = inclinaison_camera;
	}



	public Long getId_vol() {
		return id_vol;
	}
	public void setId_vol(Long id_vol) {
		this.id_vol = id_vol;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public int getHauteur_vol_retenue() {
		return hauteur_vol_retenue;
	}
	public void setHauteur_vol_retenue(int hauteur_vol_retenue) {
		this.hauteur_vol_retenue = hauteur_vol_retenue;
	}
	public String getHeure_decoolage() {
		return heure_decollage;
	}
	public void setHeure_decoolage(String heure_decoolage) {
		this.heure_decollage = heure_decoolage;
	}
	public String getHeure_atterissage() {
		return heure_atterissage;
	}
	public void setHeure_atterissage(String heure_atterissage) {
		this.heure_atterissage = heure_atterissage;
	}
	public int getPourcentage_batteie() {
		return pourcentage_batteie;
	}
	public void setPourcentage_batteie(int pourcentage_batteie) {
		this.pourcentage_batteie = pourcentage_batteie;
	}
	public int getGSD() {
		return GSD;
	}
	public void setGSD(int gSD) {
		GSD = gSD;
	}
	public String getChevauchement() {
		return chevauchement;
	}
	public void setChevauchement(String chevauchement) {
		this.chevauchement = chevauchement;
	}
	public int getVitesse() {
		return vitesse;
	}
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}
	public int getInclinaison_camera() {
		return inclinaison_camera;
	}
	public void setInclinaison_camera(int inclinaison_camera) {
		this.inclinaison_camera = inclinaison_camera;
	}




	public String getHeure_decollage() {
		return heure_decollage;
	}



	public void setHeure_decollage(String heure_decollage) {
		this.heure_decollage = heure_decollage;
	}


		
	
	
	
	
	
	
	
	
}
