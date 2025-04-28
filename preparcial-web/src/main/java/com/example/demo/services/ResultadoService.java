package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Resultado;
import com.example.demo.repositories.ResultadoRepository;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository repo;

    public List<Resultado> getAllResultados() {
        return repo.findAll();
    }

    public Resultado getResultadoById(int id) {
        return repo.getReferenceById(id);
    }

    public void addResultado(Resultado resultado) {
        repo.save(resultado);
    }

    public void deleteResultadoById(int id) {
        repo.deleteById(id);
    }

    public void deleteResultadoByReference(Resultado resultado) {
        repo.delete(resultado);
    }
}
