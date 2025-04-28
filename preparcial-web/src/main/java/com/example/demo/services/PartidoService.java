package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Partido;
import com.example.demo.repositories.PartidoRepository;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository repo;

    public List<Partido> getAllPartidos() {
        return repo.findAll();
    }

    public Partido getPartidoById(int id) {
        return repo.getReferenceById(id);
    }

    public void addPartido(Partido partido) {
        repo.save(partido);
    }

    public void deletePartidoById(int id) {
        repo.deleteById(id);
    }

    public void deletePartidoByReference(Partido partido) {
        repo.delete(partido);
    }
}
