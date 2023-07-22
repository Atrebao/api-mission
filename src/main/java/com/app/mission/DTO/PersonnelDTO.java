package com.app.mission.DTO;

import com.app.mission.model.Personnel;

import lombok.Data;

@Data
public class PersonnelDTO {
	
	private Long id_personnel;private String nom_personnel;
	private String prenoms_personnel;
	private String competences;
	private String visa;
	
	
	public PersonnelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	public PersonnelDTO(Long id_personnel, String nom_personnel, String prenoms_personnel, String competences,
			String visa) {
		super();
		this.id_personnel = id_personnel;
		this.nom_personnel = nom_personnel;
		this.prenoms_personnel = prenoms_personnel;
		this.competences = competences;
		this.visa = visa;
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
	public String getVisa() {
		return visa;
	}
	public void setVisa(String visa) {
		this.visa = visa;
	}
	
	
	
}
