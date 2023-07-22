package com.app.mission.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/*– @GeneratedValue l'annotation est utilisée pour définir la stratégie de génération de la clé primaire.
 *  GenerationType.SEQUENCE signifie utiliser la séquence de la base de données pour générer des valeurs uniques.
Nous indiquons également le nom de la clé primaire generator. Si vous ne lui donnez pas le nom, la valeur id sera
 générée avec la table hibernate_sequence (fournie par le fournisseur de persistance, pour toutes les entités) par défaut.
 * 
 * */

@Entity
@Getter
@Setter
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "client_generator")
	private Long id_client;
	
	@OneToMany(targetEntity = Mission.class , cascade = CascadeType.ALL)
	@JoinColumn(name = "idMission")
	private Set<Mission> missions = new HashSet<>();
	
		
	private String nom_client;
	private String contact;
	private String email;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

	

	public Client(Long id_client, String nom_client, String contact, String email) {
		super();
		this.id_client = id_client;
		this.nom_client = nom_client;
		this.contact = contact;
		this.email = email;
	}







	

	public Client(Long id_client, Set<Mission> missions, String nom_client, String contact, String email) {
		super();
		this.id_client = id_client;
		this.missions = missions;
		this.nom_client = nom_client;
		this.contact = contact;
		this.email = email;
	}







	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id) {
		this.id_client = id;
	}



	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getContact_client() {
		return contact;
	}

	public void setContact_client(String contact) {
		this.contact = contact;
	}







	public Set<Mission> getMissions() {
		return missions;
	}







	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}




	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	

}
