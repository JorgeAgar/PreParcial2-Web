package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Continente;
import com.example.demo.repositories.ContinenteRepository;

@Service
public class ContinenteService {

	@Autowired
	private ContinenteRepository conRepo;
	
	public List<Continente> getAllContinentes() {
		return conRepo.findAll();
	}
	
	public Continente getContinenteById(int id) {
		return conRepo.getReferenceById(id);
	}
	
	public void addContinente(Continente con) {
		conRepo.save(con);
	}
	
	public void deleteContinenteById(int id) {
		conRepo.deleteById(id);
	}
	
	public void deleteContinenteByReference(Continente con) {
		conRepo.delete(con);
	}
}
