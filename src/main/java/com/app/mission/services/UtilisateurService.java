package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.User;
import com.app.mission.repository.UtilisateurRepo;

import lombok.Data;

@Data
@Service
public class UtilisateurService {
	private final UtilisateurRepo utilisateurRepo;
	
	@Autowired
	public UtilisateurService(UtilisateurRepo utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	
	public User addUtilisateur(User utilisateur) {
		return utilisateurRepo.save(utilisateur);
	}
	
	public Iterable<User> getAllUtilisateur() {
		return utilisateurRepo.findAll();
	}
	
	public Optional<User>  getUtilisateurById(final Long id) {
		return utilisateurRepo.findById(id);
	}
	
	public void deleteUtilisateurById(final Long id) {
		utilisateurRepo.deleteById(id);
	}
	
	public User updateUtilisateur(User utilisateur) {
		return	utilisateurRepo.save(utilisateur);
	}
}
