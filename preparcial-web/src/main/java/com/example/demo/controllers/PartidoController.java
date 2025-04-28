package com.example.demo.controllers;

import com.example.demo.entities.Partido;
import com.example.demo.services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService service;

    @GetMapping
    public List<Partido> getAll() {
        return service.getAllPartidos();
    }

    @GetMapping("/{id}")
    public Partido getById(@PathVariable int id) {
        return service.getPartidoById(id);
    }

    @PostMapping
    public void create(@RequestBody Partido partido) {
        service.addPartido(partido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deletePartidoById(id);
    }
}
