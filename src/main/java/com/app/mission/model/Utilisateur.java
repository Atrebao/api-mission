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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_utilisateur;
	
	private String nom_utilisateur;
	
	private String mot_de_passe;
	
	@OneToOne
	@JoinColumn(name = "id_personnel")
	private Personnel personnel;
	
	
	@ManyToMany
	@JoinTable(name = "posserde_role",
		joinColumns = @JoinColumn(name = "id_utilisateur"),
		inverseJoinColumns = @JoinColumn(name = "id_role")
	)
	private List<Role> roles;
	
	
	@ManyToOne
	@JoinColumn(name = "id_wkfOp")
	private WorkflowOperation workflowOperation;


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(Long id_utilisateur, String nom_utilisateur, String mot_de_passe) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
	}


	public Utilisateur(Long id_utilisateur, String nom_utilisateur, String mot_de_passe, Personnel personnel,
			List<Role> roles, WorkflowOperation workflowOperation) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_passe = mot_de_passe;
		this.personnel = personnel;
		this.roles = roles;
		this.workflowOperation = workflowOperation;
	}


	public Long getId_utilisateur() {
		return id_utilisateur;
	}


	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}


	public String getNom_utilisateur() {
		return nom_utilisateur;
	}


	public void setNom_utilisateur(String nom_utilisateur) {
		this.nom_utilisateur = nom_utilisateur;
	}


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	public Personnel getPersonnel() {
		return personnel;
	}


	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	public WorkflowOperation getWorkflowOperation() {
		return workflowOperation;
	}


	public void setWorkflowOperation(WorkflowOperation workflowOperation) {
		this.workflowOperation = workflowOperation;
	}
	
	
	
}
