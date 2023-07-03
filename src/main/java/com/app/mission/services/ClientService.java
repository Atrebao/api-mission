package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Client;
import com.app.mission.repository.ClientRepo;

import lombok.Data;

@Data
@Service
public class ClientService {
	
	
	private final ClientRepo clientRepo;
	
	@Autowired
	public ClientService(ClientRepo clientRepo) {
		this.clientRepo = clientRepo;
	}
	
	public Client addClient(Client client) {
		return clientRepo.save(client);
	}
	
	public Iterable<Client> getClients() {
		return clientRepo.findAll();
	}
	
	public Optional<Client> getClient(final Long id) {
		return clientRepo.findById(id);
	}
	
	public void deleteClient(final Long id) {
		clientRepo.deleteById(id);
	}
	
	public Client updateClient(Client client) {
		return clientRepo.save(client);
	}
	

}
