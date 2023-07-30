	package com.app.mission.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users",
uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "utilisateur_generator")
	private Long id_user;
	
	private String username;

	private String password;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name = "id_personnel")
	private Personnel personnel;
	
	
	@ManyToMany
	@JoinTable(name = "user_roles",
		joinColumns = @JoinColumn(name = "id_user"),
		inverseJoinColumns = @JoinColumn(name = "id_role")
	)
	  private Set<Role> roles = new HashSet<>();
	
	
	  @ManyToOne
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	@JoinColumn(name = "id_wkfOp")
	private WorkflowOperation workflowOperation;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public User(Long id_utilisateur, String nom_utilisateur, String mot_de_passe, String email) {
		super();
		this.id_user = id_utilisateur;
		this.username = nom_utilisateur;
		this.password = mot_de_passe;
		this.email = email;
	}
	
	






	public User(String username, String mot_de_passe, String email) {
		super();
		this.username = username;
		this.password = mot_de_passe;
		this.email = email;
	}





	public User(Long id_utilisateur, String nom_utilisateur, String mot_de_passe, String email,
			Personnel personnel, Set<Role> roles, WorkflowOperation workflowOperation) {
		super();
		this.id_user = id_utilisateur;
		this.username = nom_utilisateur;
		this.password = mot_de_passe;
		this.email = email;
		this.personnel = personnel;
		this.roles = roles;
		this.workflowOperation = workflowOperation;
	}





	public Long getId_utilisateur() {
		return id_user;
	}


	public void setId_utilisateur(Long id_utilisateur) {
		this.id_user = id_utilisateur;
	}


	public String getNom_utilisateur() {
		return username;
	}


	public void setNom_utilisateur(String nom_utilisateur) {
		this.username = nom_utilisateur;
	}


	public String getMot_de_passe() {
		return password;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.password = mot_de_passe;
	}


	public Personnel getPersonnel() {
		return personnel;
	}


	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public WorkflowOperation getWorkflowOperation() {
		return workflowOperation;
	}


	public void setWorkflowOperation(WorkflowOperation workflowOperation) {
		this.workflowOperation = workflowOperation;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
