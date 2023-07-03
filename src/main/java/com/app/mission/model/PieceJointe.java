package com.app.mission.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PieceJointe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_pieceJointe;
	
	private Blob contenuePiece;
	
	@ManyToOne
	@JoinColumn(name = "id_mission")
	private Mission mission;
	
	
	@ManyToOne
	@JoinColumn(name = "id_wkfOp")
	private WorkflowOperation  workflowOperation;


	public PieceJointe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PieceJointe(Long id_pieceJointe, Blob contenuePiece) {
		super();
		this.id_pieceJointe = id_pieceJointe;
		this.contenuePiece = contenuePiece;
	}


	public PieceJointe(Long id_pieceJointe, Blob contenuePiece, Mission mission, WorkflowOperation workflowOperation) {
		super();
		this.id_pieceJointe = id_pieceJointe;
		this.contenuePiece = contenuePiece;
		this.mission = mission;
		this.workflowOperation = workflowOperation;
	}


	public Long getId_pieceJointe() {
		return id_pieceJointe;
	}


	public void setId_pieceJointe(Long id_pieceJointe) {
		this.id_pieceJointe = id_pieceJointe;
	}


	public Blob getContenuePiece() {
		return contenuePiece;
	}


	public void setContenuePiece(Blob contenuePiece) {
		this.contenuePiece = contenuePiece;
	}


	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}


	public WorkflowOperation getWorkflowOperation() {
		return workflowOperation;
	}


	public void setWorkflowOperation(WorkflowOperation workflowOperation) {
		this.workflowOperation = workflowOperation;
	}
	
	
	
	
	
	
}
