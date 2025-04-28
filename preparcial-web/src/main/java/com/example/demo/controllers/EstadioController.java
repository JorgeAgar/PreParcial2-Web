package com.example.demo.controllers;

import com.example.demo.entities.Estadio;
import com.example.demo.services.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    @Autowired
    private EstadioService service;

    @GetMapping
    public List<Estadio> getAll() {
        return service.getAllEstadios();
    }

    @GetMapping("/{id}")
    public Estadio getById(@PathVariable int id) {
        return service.getEstadioById(id);
    }

    @PostMapping
    public void create(@RequestBody Estadio estadio) {
        service.addEstadio(estadio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteEstadioById(id);
    }
}
