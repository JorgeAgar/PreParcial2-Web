package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.SeleccionDTO;
import com.example.demo.entities.Continente;
import com.example.demo.entities.Resultado;
import com.example.demo.entities.Seleccion;
import com.example.demo.repositories.ContinenteRepository;
import com.example.demo.repositories.ResultadoRepository;
import com.example.demo.repositories.SeleccionRepository;

@Service
public class SeleccionService {

    @Autowired
    private SeleccionRepository repo;
    
    @Autowired
    private ContinenteRepository conRepo;
    
    @Autowired
    private ResultadoRepository resRepo;

    public List<SeleccionDTO> getAllSelecciones() {
        List<Seleccion> sels = repo.findAll();
    	List<SeleccionDTO> selsDTO = new ArrayList<SeleccionDTO>(sels.size());
    	
    	for(Seleccion sel : sels) {
    		List<Integer> idsResultados = new ArrayList<Integer>();
            sel.getResultados().forEach((Resultado resultado) -> {
            	idsResultados.add(resultado.getId());
            });
        	selsDTO.add(new SeleccionDTO(sel.getId(), sel.getNombre(), sel.getContinente_id().getId(), sel.getGrupo(), idsResultados));
    	}
    	
        return selsDTO;
    }
    
    public List<SeleccionDTO> getSeleccionByGroup(String grupo) {
    	List<SeleccionDTO> selecciones = getAllSelecciones();
    	List<SeleccionDTO> seleccionesGrupo = new ArrayList<SeleccionDTO>();
    	for(SeleccionDTO seleccion : selecciones) {
    		if(seleccion.getGrupo().equalsIgnoreCase(grupo))
    			seleccionesGrupo.add(seleccion);
    	}
    	return seleccionesGrupo;
    }

    public SeleccionDTO getSeleccionById(int id) {
        Seleccion sel = repo.getReferenceById(id);
        List<Integer> idsResultados = new ArrayList<Integer>();
        sel.getResultados().forEach((Resultado resultado) -> {
        	idsResultados.add(resultado.getId());
        });
    	return new SeleccionDTO(id, sel.getNombre(), sel.getContinente_id().getId(), sel.getGrupo(), idsResultados);
    }

    public void addSeleccion(SeleccionDTO seleccionDTO) { //ignora el id pasado en el DTO, ya que se crea automáticamente.
    	Continente continente = conRepo.getReferenceById(seleccionDTO.getContinente_id());
    	
    	List<Resultado> resultados = new ArrayList<Resultado>(seleccionDTO.getIds_resultados().size());
    	for(int idRes : seleccionDTO.getIds_resultados()) {
    		resultados.add(resRepo.getReferenceById(idRes));
    	}
    	
    	Seleccion seleccion = new Seleccion(seleccionDTO.getNombre(), continente, seleccionDTO.getGrupo(), resultados);
        repo.save(seleccion);
    }

    public void deleteSeleccionById(int id) {
        repo.deleteById(id);
    }

    public void deleteSeleccionByReference(Seleccion seleccion) {
        repo.delete(seleccion);
    }
}
