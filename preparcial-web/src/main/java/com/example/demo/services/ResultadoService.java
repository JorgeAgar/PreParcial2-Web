package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ResultadoDTO;
import com.example.demo.entities.Resultado;
import com.example.demo.repositories.PartidoRepository;
import com.example.demo.repositories.ResultadoRepository;
import com.example.demo.repositories.SeleccionRepository;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository repo;
    
    @Autowired
    private PartidoRepository parRepo;
    
    @Autowired
    private SeleccionRepository selRepo;

    public List<ResultadoDTO> getAllResultados() {
        List<Resultado> resultados = repo.findAll();
        List<ResultadoDTO> resultadosDTO = new ArrayList<ResultadoDTO>(resultados.size());
        
        for(Resultado resultado : resultados) {
        	resultadosDTO.add(new ResultadoDTO(resultado.getId(), resultado.getPartido_id().getId(), resultado.getSeleccion_id().getId(), resultado.getGoles(), resultado.getAmarillas(), resultado.getRojas()));
        }
        
    	return resultadosDTO;
    }

    public ResultadoDTO getResultadoById(int id) {
        Resultado resultado = repo.getReferenceById(id);
        ResultadoDTO resultadoDTO = new ResultadoDTO(id, resultado.getPartido_id().getId(), resultado.getSeleccion_id().getId(), resultado.getGoles(), resultado.getAmarillas(), resultado.getRojas());
    	return resultadoDTO;
    }

    public void addResultado(ResultadoDTO resultadoDTO) { //ignora el id pasado en el DTO, ya que se crea automáticamente.
        Resultado resultado = new Resultado(parRepo.getReferenceById(resultadoDTO.getPartido_id()), selRepo.getReferenceById(resultadoDTO.getSeleccion_id()), resultadoDTO.getGoles(), resultadoDTO.getAmarillas(), resultadoDTO.getRojas());
    	repo.save(resultado);
    }

    public void deleteResultadoById(int id) {
        repo.deleteById(id);
    }

    public void deleteResultadoByReference(Resultado resultado) {
        repo.delete(resultado);
    }
}
