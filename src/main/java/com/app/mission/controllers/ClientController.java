package com.app.mission.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mission.model.Client;
import com.app.mission.repository.ClientRepo;
import com.app.mission.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
   @Autowired
   private ClientService clientService;
   
   @Autowired
   private ClientRepo clientRepo;
   
   @PostMapping("/add")
   public ResponseEntity<Client> addClient(@RequestBody Client client) {
       Client newClient = clientService.addClient(client);
       return new ResponseEntity<>(newClient, HttpStatus.CREATED);
   }
	
	@PutMapping("/update/{id}")
	public Client updateClientById(@PathVariable("id") final Long id, @RequestBody Client client) {
		Optional<Client> e = clientService.getClient(id);
		if(e.isPresent()) {
			Client currentClient = e.get();
			
			String nom = client.getNom_client();
			if(nom != null) {
				currentClient.setNom_client(nom);
				currentClient.setEmail(client.getEmail());
				
			}
			
			currentClient.setContact_client(client.getContact_client());

			clientService.addClient(currentClient);
			return currentClient;
		} else {
			return null;
		}
	}
	
	@PutMapping("/updateAll/{id}")
	public Client updateAllClientById(@PathVariable("id") final Long id, @RequestBody Client client) {
		Optional<Client> e = clientService.getClient(id);
		if(e.isPresent()) {
			Client currentClient = e.get();
			
			String nom = client.getNom_client();
			if(nom != null) {
				currentClient.setNom_client(nom);
				
			}
		
			
			currentClient.setContact_client(client.getContact_client());

			clientService.addClient(currentClient);
			return currentClient;
		} else {
			return null;
		}
	}

	@GetMapping("/clients")
	public Iterable<Client> getAllClients() {
		return clientService.getClients();
	}
	
	@GetMapping("/{id}")
	public Client getClientById(@PathVariable("id") final Long id) {
		Optional<Client> client = clientService.getClient(id);
		if(client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}
	
	
	@GetMapping("/contact/{contact}")
	public Client getClientByContact(@PathVariable("contact") final String contact) {
		Optional<Client> client = clientRepo.findClientByContact(contact);
		if(client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteClientById(@PathVariable("id") final Long id) {
		try {
			clientService.deleteClient(id);
		} catch (Exception e) {
			System.out.println("Client " + id + " n'existe pas");
		}
	}

}
