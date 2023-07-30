package com.app.mission.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Personnel implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "personnel_generator")
	private Long id_personnel;
	
	
	/*
	 * 	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE })
	@JoinTable(
			name= "effectuer_mission",
			joinColumns= {@JoinColumn(name="id_personnel")},
			inverseJoinColumns= @JoinColumn(name="idMission")
			)
	private Set<Mission> missions = new HashSet<>();
	
	
		  public void addMission(Mission mission) {
		    this.missions.add(mission);
		    mission.getPersonnels().add(this);
		  }
		  
		  public void removeMission(long missionId) {
		    Mission mission = this.missions.stream().filter(t -> t.getId_mission() == missionId).findFirst().orElse(null);
		    if (mission != null) {
		      this.missions.remove(mission);
		      mission.getPersonnels().remove(this);
		    }
		  }
	 * */
	
	
	@ManyToOne
	@JoinColumn(name="idMission")
	private Mission mission;
	
	
	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}



	@OneToOne
	@JoinColumn(name="id_user")
	private User utilsateur;
	
		
	
	  @ManyToOne
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JoinColumn(name="id_fonction")
	  private Fonction fonction;
	

	 
	
	/*
	 * 	@ManyToOne
	@JoinColumn(name="idMission")
	private Mission mission;
	 * */
	
	public Personnel() {}

	




	public Personnel(Long id_personnel, Mission mission, User utilsateur, Fonction fonction,
			String nom_personnel, String prenoms_personnel, String competences, String visa) {
		super();
		this.id_personnel = id_personnel;
		this.mission = mission;
		this.utilsateur = utilsateur;
		this.fonction = fonction;
		this.nom_personnel = nom_personnel;
		this.prenoms_personnel = prenoms_personnel;
		this.competences = competences;
		this.visa = visa;
	}



	private String nom_personnel;
	private String prenoms_personnel;
	private String competences;
	private String visa;
	
	
	



	public Fonction getFonction() {
		return fonction;
	}


	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}


	public Long getId_personnel() {
		return id_personnel;
	}
	public void setId_personnel(Long id_personnel) {
		this.id_personnel = id_personnel;
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
	public User getUtilsateur() {
		return utilsateur;
	}


	public void setUtilsateur(User utilsateur) {
		this.utilsateur = utilsateur;
	}


	public Fonction getFonctions() {
		return fonction;
	}


	public void setFonctions(Fonction fonction) {
		this.fonction = fonction;
	}


	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}

	
	
	
	
	
	

}
