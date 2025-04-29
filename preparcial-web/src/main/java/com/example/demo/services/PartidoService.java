package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PartidoDTO;
import com.example.demo.entities.Partido;
import com.example.demo.entities.Resultado;
import com.example.demo.repositories.EstadioRepository;
import com.example.demo.repositories.PartidoRepository;
import com.example.demo.repositories.ResultadoRepository;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository repo;
    
    @Autowired
    private EstadioRepository estadioRepo;
    
    @Autowired
    private ResultadoRepository resulRepo;

    public List<PartidoDTO> getAllPartidos() {
        List<Partido> partidos = repo.findAll();
        List<PartidoDTO> partidosDTO = new ArrayList<PartidoDTO>(partidos.size());
        
        for(Partido partido : partidos) {
        	List<Integer> idsResultados = new ArrayList<Integer>(partido.getResultados().size());
        	for(Resultado resultado : partido.getResultados()) {
        		idsResultados.add(resultado.getId());
        	}
        	
        	partidosDTO.add(new PartidoDTO(partido.getId(), partido.getFecha(), partido.getEstadio_id().getId(), idsResultados));
        }
        
    	return partidosDTO;
    }

    public PartidoDTO getPartidoById(int id) {
        Partido response = repo.getReferenceById(id);
        
        List<Integer> idsResultados = new ArrayList<Integer>(response.getResultados().size());
    	for(Resultado resultado : response.getResultados()) {
    		idsResultados.add(resultado.getId());
    	}
    	
        PartidoDTO partidoDTO = new PartidoDTO(id, response.getFecha(), response.getEstadio_id().getId(), idsResultados);
    	return partidoDTO;
    }

    public void addPartido(PartidoDTO partidoDTO) {
    	List<Resultado> resultados = new ArrayList<Resultado>(partidoDTO.getIds_resultados().size());
    	for(int idResultado : partidoDTO.getIds_resultados()) {
    		resultados.add(resulRepo.getReferenceById(idResultado));
    	}
        
    	Partido partido = new Partido(partidoDTO.getFecha(), estadioRepo.getReferenceById(partidoDTO.getEstadio_id()), resultados);
    	repo.save(partido);
    }

    public void deletePartidoById(int id) {
        repo.deleteById(id);
    }

    public void deletePartidoByReference(Partido partido) {
        repo.delete(partido);
    }
}
