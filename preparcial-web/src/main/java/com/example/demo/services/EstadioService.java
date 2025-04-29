package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EstadioDTO;
import com.example.demo.entities.Estadio;
import com.example.demo.entities.Partido;
import com.example.demo.repositories.EstadioRepository;
import com.example.demo.repositories.PartidoRepository;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository repo;
    
    @Autowired
    private PartidoRepository parRepo;

    public List<EstadioDTO> getAllEstadios() {
        List<Estadio> estadios = repo.findAll();
        List<EstadioDTO> estadiosDTO = new ArrayList<EstadioDTO>(estadios.size());
        
        for(Estadio estadio : estadios) {
        	List<Partido> partidos = estadio.getPartidos();
        	List<Integer> idsPartidos = new ArrayList<Integer>(partidos.size());
        	
        	for(Partido partido : partidos) {
        		idsPartidos.add(partido.getId());
        	}
        	
        	estadiosDTO.add(new EstadioDTO(estadio.getId(), estadio.getNombre(), estadio.getCapacidad(), idsPartidos));
        }
        
    	return estadiosDTO;
    }

    public EstadioDTO getEstadioById(int id) {
        Estadio response = repo.getReferenceById(id);
        
        List<Partido> partidos = response.getPartidos();
    	List<Integer> idsPartidos = new ArrayList<Integer>(partidos.size());
    	
    	for(Partido partido : partidos) {
    		idsPartidos.add(partido.getId());
    	}
    	
        EstadioDTO estadioDTO = new EstadioDTO(id, response.getNombre(), response.getCapacidad(), idsPartidos);
    	return estadioDTO;
    }

    public void addEstadio(EstadioDTO estadioDTO) { //ignora el id pasado en el DTO, ya que se crea automáticamente.
    	List<Partido> partidos = new ArrayList<Partido>(estadioDTO.getIds_partidos().size());
    	
    	for(int idPartido : estadioDTO.getIds_partidos()) {
    		partidos.add(parRepo.getReferenceById(idPartido));
    	}
    	
    	Estadio estadio = new Estadio(estadioDTO.getNombre(), estadioDTO.getCapacidad(), partidos);
    	repo.save(estadio);
    }

    public void deleteEstadioById(int id) {
        repo.deleteById(id);
    }

    public void deleteEstadioByReference(Estadio estadio) {
        repo.delete(estadio);
    }
}
