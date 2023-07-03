package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.Utilisateur;
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
	
	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepo.save(utilisateur);
	}
	
	public Iterable<Utilisateur> getAllUtilisateur() {
		return utilisateurRepo.findAll();
	}
	
	public Optional<Utilisateur>  getUtilisateurById(final Long id) {
		return utilisateurRepo.findById(id);
	}
	
	public void deleteUtilisateurById(final Long id) {
		utilisateurRepo.deleteById(id);
	}
	
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		return	utilisateurRepo.save(utilisateur);
	}
}
