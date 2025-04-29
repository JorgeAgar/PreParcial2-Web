package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ContinenteDTO;
import com.example.demo.entities.Continente;
import com.example.demo.entities.Seleccion;
import com.example.demo.repositories.ContinenteRepository;
import com.example.demo.repositories.SeleccionRepository;

@Service
public class ContinenteService {

	@Autowired
	private ContinenteRepository conRepo;
	
	@Autowired
	private SeleccionRepository selRepo;
	
	public List<ContinenteDTO> getAllContinentes() {
		List<Continente> continentes = conRepo.findAll(); 
		List<ContinenteDTO> continentesDTO = new ArrayList<ContinenteDTO>(continentes.size());
		
		for(Continente con : continentes) {
			List<Integer> ids_selecciones = new ArrayList<Integer>(con.getSelecciones().size());
			for(Seleccion sel : con.getSelecciones()) {
				ids_selecciones.add(sel.getId());
			}
			continentesDTO.add(new ContinenteDTO(con.getId(), con.getNombre(), ids_selecciones));
		}
		
		return continentesDTO;
	}
	
	public ContinenteDTO getContinenteById(int id) {
		Continente response = conRepo.getReferenceById(id);
		
		List<Integer> ids_selecciones = new ArrayList<Integer>(response.getSelecciones().size());
		for(Seleccion sel : response.getSelecciones()) {
			ids_selecciones.add(sel.getId());
		}
		
		ContinenteDTO conDTO = new ContinenteDTO(id, response.getNombre(), ids_selecciones);
		return conDTO;
	}
	
	public void addContinente(ContinenteDTO conDTO) { //ignora el id pasado en el DTO, ya que se crea automáticamente.
		List<Seleccion> selecciones = new ArrayList<Seleccion>(conDTO.getIds_selecciones().size());
		for(int idSel : conDTO.getIds_selecciones()) {
			selecciones.add(selRepo.getReferenceById(idSel));
		}
		
		Continente con = new Continente(conDTO.getNombre(), selecciones);
		conRepo.save(con);
	}
	
	public void deleteContinenteById(int id) {
		conRepo.deleteById(id);
	}
	
	public void deleteContinenteByReference(Continente con) {
		conRepo.delete(con);
	}
}
