package com.app.mission.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etape implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etape_generator")
	private Long id_etape;
	
	private String libelle_etape;
	
	private Integer id_etape_prec;
	
	private Integer id_etape_suiv;
	
	private Boolean isActive;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	@JoinColumn(name="id_workflow")
	private Workflow workflow;
	
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	@JoinColumn(name="id_wkfOp")
	private WorkflowOperation workflow_operation;
	
	@ManyToMany
	@JoinTable(name="destiner_a",
		joinColumns = @JoinColumn(name="id_etape"),
		inverseJoinColumns = @JoinColumn(name="id_role")
		
	)
	private List<Role> roles;

	public Etape() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etape(Long id_etape, String libelle_etape, Integer id_etape_prec, Integer id_etape_suiv, Boolean isActive) {
		super();
		this.id_etape = id_etape;
		this.libelle_etape = libelle_etape;
		this.id_etape_prec = id_etape_prec;
		this.id_etape_suiv = id_etape_suiv;
		this.isActive = isActive;
	}

	public Etape(Long id_etape, String libelle_etape, Integer id_etape_prec, Integer id_etape_suiv, Boolean isActive,
			Workflow workflow, WorkflowOperation workflow_operation, List<Role> roles) {
		super();
		this.id_etape = id_etape;
		this.libelle_etape = libelle_etape;
		this.id_etape_prec = id_etape_prec;
		this.id_etape_suiv = id_etape_suiv;
		this.isActive = isActive;
		this.workflow = workflow;
		this.workflow_operation = workflow_operation;
		this.roles = roles;
	}

	public Long getId_etape() {
		return id_etape;
	}

	public void setId_etape(Long id_etape) {
		this.id_etape = id_etape;
	}

	public String getLibelle_etape() {
		return libelle_etape;
	}

	public void setLibelle_etape(String libelle_etape) {
		this.libelle_etape = libelle_etape;
	}

	public Integer getId_etape_prec() {
		return id_etape_prec;
	}

	public void setId_etape_prec(Integer id_etape_prec) {
		this.id_etape_prec = id_etape_prec;
	}

	public Integer getId_etape_suiv() {
		return id_etape_suiv;
	}

	public void setId_etape_suiv(Integer id_etape_suiv) {
		this.id_etape_suiv = id_etape_suiv;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public WorkflowOperation getWorkflow_operation() {
		return workflow_operation;
	}

	public void setWorkflow_operation(WorkflowOperation workflow_operation) {
		this.workflow_operation = workflow_operation;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
