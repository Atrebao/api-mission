package com.app.mission.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mission implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "mission_generator")
	private Long idMission;
	
	
	  @ManyToOne
	  @JoinColumn(name = "id_client", nullable = false)
	  @OnDelete(action = OnDeleteAction.CASCADE)
	  @JsonIgnore
	  private Client client;
	
	
	  /*	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.PERSIST,
		              CascadeType.MERGE
		          },
		          mappedBy = "missions")
	  @JsonIgnore
	  	private Set<Personnel> personnels = new HashSet<>();
	   * 
	   * */
	

	@OneToMany(mappedBy ="id_vol")
	@JsonIgnore
	private List<Vol> vols;
	
	/*
	 * 
	 * 	@OneToMany(targetEntity = Obstacle.class, cascade = CascadeType.ALL)
	@JoinColumn(name="id_obst", referencedColumnName = "idMission")
	private List<Obstacle> obstacles;
	 * */

	
	@OneToMany(mappedBy="id_mat")
	@JsonIgnore
	private List<Materiel> materiels;
	

	
	@ManyToOne
	@JoinColumn(name="id_ville")
	@JsonIgnore
	private Ville ville;
	
	
	@OneToMany(mappedBy="id_ckeckListConfig")
	private List<CheckListConfig> checkListConfigs;
	
	@OneToMany(mappedBy="id_pieceJointe")
	@JsonIgnore
	private List<PieceJointe> pieceJointes;
	

	@OneToOne
	@JoinColumn(name="id_wkfOp")
	@JsonIgnore
	private WorkflowOperation workflowOperation;
	
	@OneToMany(targetEntity = Personnel.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "id_personnel")
	@JsonIgnore
	private Set<Personnel> personnels = new HashSet<>();
	
	




	/*
	 * @OneToMany(mappedBy="id_personnel")
	private List<Personnel> personel;
	
	 * */
	private String nom_mission;
	private String type_mission;
	private String description_mission;
	private String code_mission;
	private String classe_espace_aerien;
	private String statut_zone_mission;
	private String scenario_mission;
	private String condition_humidite;
	private String condition_visibilite;
	private String surface_atterissage;
	private String surface_decollage;
	private String balisage;
	private String evenements;
	private String plage_horaire_mission_debut;
	private String plage_horaire_mission_fin;
	private Date date_estime_mission;
	private Date date_heure_mission;
	private String date_heure_arrive;
	private int latitude;
	private int longitude;
	private String condition_vent_critque_mission;
	private String autorite_informe;
	
	
	
	public int getLatitude() {
		return latitude;
	}





	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}





	public String getCondition_vent_critque_mission() {
		return condition_vent_critque_mission;
	}





	public void setCondition_vent_critque_mission(String condition_vent_critque_mission) {
		this.condition_vent_critque_mission = condition_vent_critque_mission;
	}





	public int getLongitude() {
		return longitude;
	}





	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}





	public Mission() {}

	


	


	public Mission(Long idMission, String nom_mission, String type_mission, String description_mission,
			String code_mission, String classe_espace_aerien, String statut_zone_mission, String scenario_mission,
			String condition_humidite, String condition_visibilite, String surface_atterissage,
			String surface_decollage, String balisage, String evenements, String difficultes,
			String plage_horaire_mission_debut, String plage_horaire_mission_fin, Date date_estime_mission,
			Date date_heure_effective_mission, String date_heure_arrive, int latitude, int longitude,
			String condition_vent_critque_mission, String autorite_informe) {
		super();
		this.idMission = idMission;
		this.nom_mission = nom_mission;
		this.type_mission = type_mission;
		this.description_mission = description_mission;
		this.code_mission = code_mission;
		this.classe_espace_aerien = classe_espace_aerien;
		this.statut_zone_mission = statut_zone_mission;
		this.scenario_mission = scenario_mission;
		this.condition_humidite = condition_humidite;
		this.condition_visibilite = condition_visibilite;
		this.surface_atterissage = surface_atterissage;
		this.surface_decollage = surface_decollage;
		this.balisage = balisage;
		this.evenements = evenements;
	
		this.plage_horaire_mission_debut = plage_horaire_mission_debut;
		this.plage_horaire_mission_fin = plage_horaire_mission_fin;
		this.date_estime_mission = date_estime_mission;
		this.date_heure_mission = date_heure_effective_mission;
		this.date_heure_arrive = date_heure_arrive;
		this.latitude = latitude;
		this.longitude = longitude;
		this.condition_vent_critque_mission = condition_vent_critque_mission;
		this.autorite_informe = autorite_informe;
	}



	public void addPersonnel(Personnel personnel) {
	    this.personnels.add(personnel);
	}






	public Mission(Long idMission, Client client, List<Vol> vols, List<Materiel> materiels, Ville ville,
			List<CheckListConfig> checkListConfigs, List<PieceJointe> pieceJointes, WorkflowOperation workflowOperation,
			Set<Personnel> personnels, String nom_mission, String type_mission, String description_mission,
			String code_mission, String classe_espace_aerien, String statut_zone_mission, String scenario_mission,
			String condition_humidite, String condition_visibilite, String surface_atterissage,
			String surface_decollage, String balisage, String evenements,
			String plage_horaire_mission_debut, String plage_horaire_mission_fin, Date date_estime_mission,
			Date date_heure_effective_mission, String date_heure_arrive, int latitude, int longitude,
			String condition_vent_critque_mission, String autorite_informe) {
		super();
		this.idMission = idMission;
		this.client = client;
		this.vols = vols;
		this.materiels = materiels;
		this.ville = ville;
		this.checkListConfigs = checkListConfigs;
		this.pieceJointes = pieceJointes;
		this.workflowOperation = workflowOperation;
		this.personnels = personnels;
		this.nom_mission = nom_mission;
		this.type_mission = type_mission;
		this.description_mission = description_mission;
		this.code_mission = code_mission;
		this.classe_espace_aerien = classe_espace_aerien;
		this.statut_zone_mission = statut_zone_mission;
		this.scenario_mission = scenario_mission;
		this.condition_humidite = condition_humidite;
		this.condition_visibilite = condition_visibilite;
		this.surface_atterissage = surface_atterissage;
		this.surface_decollage = surface_decollage;
		this.balisage = balisage;
		this.evenements = evenements;
		this.plage_horaire_mission_debut = plage_horaire_mission_debut;
		this.plage_horaire_mission_fin = plage_horaire_mission_fin;
		this.date_estime_mission = date_estime_mission;
		this.date_heure_mission = date_heure_effective_mission;
		this.date_heure_arrive = date_heure_arrive;
		this.latitude = latitude;
		this.longitude = longitude;
		this.condition_vent_critque_mission = condition_vent_critque_mission;
		this.autorite_informe = autorite_informe;
	}





	public Set<Personnel> getPersonnels() {
		return personnels;
	}





	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}





	public Long getId_mission() {
		return idMission;
	}


	public void setId_mission(Long idMission) {
		this.idMission = idMission;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}





	public List<Vol> getVols() {
		return vols;
	}


	public void setVols(List<Vol> vols) {
		this.vols = vols;
	}





	public List<Materiel> getMateriels() {
		return materiels;
	}


	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}


	public Ville getVille() {
		return ville;
	}


	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public List<CheckListConfig> getCheckListConfigs() {
		return checkListConfigs;
	}


	public void setCheckListConfigs(List<CheckListConfig> checkListConfigs) {
		this.checkListConfigs = checkListConfigs;
	}


	public List<PieceJointe> getPieceJointes() {
		return pieceJointes;
	}


	public void setPieceJointes(List<PieceJointe> pieceJointes) {
		this.pieceJointes = pieceJointes;
	}


	public WorkflowOperation getWorkflowOperation() {
		return workflowOperation;
	}


	public void setWorkflowOperation(WorkflowOperation workflowOperation) {
		this.workflowOperation = workflowOperation;
	}


	public String getNom_mission() {
		return nom_mission;
	}


	public void setNom_mission(String nom_mission) {
		this.nom_mission = nom_mission;
	}


	public String getType_mission() {
		return type_mission;
	}


	public void setType_mission(String type_mission) {
		this.type_mission = type_mission;
	}


	public String getDescription_mission() {
		return description_mission;
	}


	public void setDescription_mission(String description_mission) {
		this.description_mission = description_mission;
	}


	public String getCode_mission() {
		return code_mission;
	}


	public void setCode_mission(String code_mission) {
		this.code_mission = code_mission;
	}


	public String getClasse_espace_aerien() {
		return classe_espace_aerien;
	}


	public void setClasse_espace_aerien(String classe_espace_aerien) {
		this.classe_espace_aerien = classe_espace_aerien;
	}


	public String getStatut_zone_mission() {
		return statut_zone_mission;
	}


	public void setStatut_zone_mission(String statut_zone_mission) {
		this.statut_zone_mission = statut_zone_mission;
	}


	public String getScenario_mission() {
		return scenario_mission;
	}


	public void setScenario_mission(String scenario_mission) {
		this.scenario_mission = scenario_mission;
	}







	public String getCondition_humidite() {
		return condition_humidite;
	}


	public void setCondition_humidite(String condition_humidite) {
		this.condition_humidite = condition_humidite;
	}


	public String getCondition_visibilite() {
		return condition_visibilite;
	}


	public void setCondition_visibilite(String condition_visibilite) {
		this.condition_visibilite = condition_visibilite;
	}


	public String getSurface_atterissage() {
		return surface_atterissage;
	}


	public void setSurface_atterissage(String surface_atterissage) {
		this.surface_atterissage = surface_atterissage;
	}


	public String getSurface_decollage() {
		return surface_decollage;
	}


	public void setSurface_decollage(String surface_decollage) {
		this.surface_decollage = surface_decollage;
	}


	public String getBalisage() {
		return balisage;
	}


	public void setBalisage(String balisage) {
		this.balisage = balisage;
	}


	public String getEvenements() {
		return evenements;
	}


	public void setEvenements(String evenements) {
		this.evenements = evenements;
	}




	public String getPlage_horaire_mission_debut() {
		return plage_horaire_mission_debut;
	}


	public void setPlage_horaire_mission_debut(String plage_horaire_mission_debut) {
		this.plage_horaire_mission_debut = plage_horaire_mission_debut;
	}


	public String getPlage_horaire_mission_fin() {
		return plage_horaire_mission_fin;
	}


	public void setPlage_horaire_mission_fin(String plage_horaire_mission_fin) {
		this.plage_horaire_mission_fin = plage_horaire_mission_fin;
	}


	public Date getDate_estime_mission() {
		return date_estime_mission;
	}


	public void setDate_estime_mission(Date date_estime_mission) {
		this.date_estime_mission = date_estime_mission;
	}





	public Date getDate_heure_effective_mission() {
		return date_heure_mission;
	}


	public void setDate_heure_effective_mission(Date date_heure_effective_mission) {
		this.date_heure_mission = date_heure_effective_mission;
	}


	public String getDate_heure_arrive() {
		return date_heure_arrive;
	}


	public void setDate_heure_arrive(String date_heure_arrive) {
		this.date_heure_arrive = date_heure_arrive;
	}





	public Long getIdMission() {
		return idMission;
	}





	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}





	public String getAutorite_informe() {
		return autorite_informe;
	}





	public void setAutorite_informe(String autorite_informe) {
		this.autorite_informe = autorite_informe;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
