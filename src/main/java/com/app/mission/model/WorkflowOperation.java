package com.app.mission.model;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/*Dans cet exemple, nous utilisons @Transient pour ignorer la colonne
 *  jsonData lors de la persistance. Au lieu de cela, nous stockons et
 *   récupérons les données JSON à l'aide de la colonne dataJson de 
 *   type TEXT.

Assure-toi d'inclure les dépendances nécessaires pour Jackson ou Gson 
dans ton projet.

Il est important de noter que ces approches sont des alternatives à 
la colonne de type JSON native dans MySQL. Elles impliquent des étapes
 supplémentaires de sérialisation/désérialisation manuelle ou l'utilisation de bibliothèques externes pour
  la gestion des objets JSON.
 * 
 * 
 * */

@Entity
public class WorkflowOperation implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_wkfOp;
	
	private Date date_creation;
	
	private Date date_miseAjour;
	
	private Long id_wkfOpParent;
	
	private Long id_userInsert;
	
	private Long id_userUpdate;
	
	private Boolean isActive;
	
	   @Transient
	    private JsonNode jsonData;

	    @Column(columnDefinition = "TEXT")
	    private String dataJson;

	    public JsonNode getJsonData() {
	        try {
	            return new ObjectMapper().readTree(dataJson);
	        } catch (IOException e) {
	            // Gérer l'exception appropriée
	            return null;
	        }
	    }

	    public void setJsonData(JsonNode jsonData) {
	        try {
	            this.dataJson = new ObjectMapper().writeValueAsString(jsonData);
	        } catch (JsonProcessingException e) {
	            // Gérer l'exception appropriée
	            this.dataJson = null;
	        }
	    }
	    
	    
	    @OneToOne
	    @JoinColumn(name = "id_etape")
	    private Etape etape;
	    
	    
	    @OneToOne
	    @JoinColumn(name = "id_mission")
	    private Mission mission;
	    
	    @OneToMany(mappedBy ="id_pieceJointe")
	    private List<PieceJointe> pieceJointes;
	    
	    @OneToMany(mappedBy ="id_utilisateur")
	    private List<Utilisateur> utilisateurs;

		public WorkflowOperation() {
			super();
			// TODO Auto-generated constructor stub
		}

		public WorkflowOperation(Long id_wkfOp, Date date_creation, Date date_miseAjour, Long id_wkfOpParent,
				Long id_userInsert, Long id_userUpdate, Boolean isActive, JsonNode jsonData, String dataJson) {
			super();
			this.id_wkfOp = id_wkfOp;
			this.date_creation = date_creation;
			this.date_miseAjour = date_miseAjour;
			this.id_wkfOpParent = id_wkfOpParent;
			this.id_userInsert = id_userInsert;
			this.id_userUpdate = id_userUpdate;
			this.isActive = isActive;
			this.jsonData = jsonData;
			this.dataJson = dataJson;
		}

		public WorkflowOperation(Long id_wkfOp, Date date_creation, Date date_miseAjour, Long id_wkfOpParent,
				Long id_userInsert, Long id_userUpdate, Boolean isActive, JsonNode jsonData, String dataJson,
				Etape etape, Mission mission, List<PieceJointe> pieceJointes, List<Utilisateur> utilisateurs) {
			super();
			this.id_wkfOp = id_wkfOp;
			this.date_creation = date_creation;
			this.date_miseAjour = date_miseAjour;
			this.id_wkfOpParent = id_wkfOpParent;
			this.id_userInsert = id_userInsert;
			this.id_userUpdate = id_userUpdate;
			this.isActive = isActive;
			this.jsonData = jsonData;
			this.dataJson = dataJson;
			this.etape = etape;
			this.mission = mission;
			this.pieceJointes = pieceJointes;
			this.utilisateurs = utilisateurs;
		}

		public Long getId_wkfOp() {
			return id_wkfOp;
		}

		public void setId_wkfOp(Long id_wkfOp) {
			this.id_wkfOp = id_wkfOp;
		}

		public Date getDate_creation() {
			return date_creation;
		}

		public void setDate_creation(Date date_creation) {
			this.date_creation = date_creation;
		}

		public Date getDate_miseAjour() {
			return date_miseAjour;
		}

		public void setDate_miseAjour(Date date_miseAjour) {
			this.date_miseAjour = date_miseAjour;
		}

		public Long getId_wkfOpParent() {
			return id_wkfOpParent;
		}

		public void setId_wkfOpParent(Long id_wkfOpParent) {
			this.id_wkfOpParent = id_wkfOpParent;
		}

		public Long getId_userInsert() {
			return id_userInsert;
		}

		public void setId_userInsert(Long id_userInsert) {
			this.id_userInsert = id_userInsert;
		}

		public Long getId_userUpdate() {
			return id_userUpdate;
		}

		public void setId_userUpdate(Long id_userUpdate) {
			this.id_userUpdate = id_userUpdate;
		}

		public Boolean getIsActive() {
			return isActive;
		}

		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}

		public String getDataJson() {
			return dataJson;
		}

		public void setDataJson(String dataJson) {
			this.dataJson = dataJson;
		}

		public Etape getEtape() {
			return etape;
		}

		public void setEtape(Etape etape) {
			this.etape = etape;
		}

		public Mission getMission() {
			return mission;
		}

		public void setMission(Mission mission) {
			this.mission = mission;
		}

		public List<PieceJointe> getPieceJointes() {
			return pieceJointes;
		}

		public void setPieceJointes(List<PieceJointe> pieceJointes) {
			this.pieceJointes = pieceJointes;
		}

		public List<Utilisateur> getUtilisateurs() {
			return utilisateurs;
		}

		public void setUtilisateurs(List<Utilisateur> utilisateurs) {
			this.utilisateurs = utilisateurs;
		}
	
	    
  
	
}
