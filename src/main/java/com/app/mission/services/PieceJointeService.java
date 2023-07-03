package com.app.mission.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mission.model.PieceJointe;
import com.app.mission.repository.PieceJointeRepo;

import lombok.Data;

@Data
@Service
public class PieceJointeService {
	private final PieceJointeRepo pieceJointeRepo;
	
	@Autowired
	public PieceJointeService(PieceJointeRepo pieceJointeRepo) {
		this.pieceJointeRepo = pieceJointeRepo;
	}
	
	public PieceJointe addPieceJointe(PieceJointe pieceJointe) {
		return pieceJointeRepo.save(pieceJointe);
	}
	
	public Iterable<PieceJointe> getAllPieceJointe() {
		return pieceJointeRepo.findAll();
	}
	
	public Optional<PieceJointe>  getPieceJointeById(final Long id) {
		return pieceJointeRepo.findById(id);
	}
	
	public void deletePieceJointeById(final Long id) {
		pieceJointeRepo.deleteById(id);
	}
	
	public PieceJointe updatePieceJointe(PieceJointe pieceJointe) {
		return	pieceJointeRepo.save(pieceJointe);
	}
}
