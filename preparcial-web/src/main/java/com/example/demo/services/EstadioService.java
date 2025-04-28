package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Estadio;
import com.example.demo.repositories.EstadioRepository;

@Service
public class EstadioService {

    @Autowired
    private EstadioRepository repo;

    public List<Estadio> getAllEstadios() {
        return repo.findAll();
    }

    public Estadio getEstadioById(int id) {
        return repo.getReferenceById(id);
    }

    public void addEstadio(Estadio estadio) {
        repo.save(estadio);
    }

    public void deleteEstadioById(int id) {
        repo.deleteById(id);
    }

    public void deleteEstadioByReference(Estadio estadio) {
        repo.delete(estadio);
    }
}
