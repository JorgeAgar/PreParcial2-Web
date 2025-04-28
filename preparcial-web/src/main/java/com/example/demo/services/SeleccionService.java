package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Seleccion;
import com.example.demo.repositories.SeleccionRepository;

@Service
public class SeleccionService {

    @Autowired
    private SeleccionRepository repo;

    public List<Seleccion> getAllSelecciones() {
        return repo.findAll();
    }

    public Seleccion getSeleccionById(int id) {
        return repo.getReferenceById(id);
    }

    public void addSeleccion(Seleccion seleccion) {
        repo.save(seleccion);
    }

    public void deleteSeleccionById(int id) {
        repo.deleteById(id);
    }

    public void deleteSeleccionByReference(Seleccion seleccion) {
        repo.delete(seleccion);
    }
}
