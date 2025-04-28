package com.example.demo.controllers;

import com.example.demo.entities.Continente;
import com.example.demo.services.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService service;

    @GetMapping
    public List<Continente> getAll() {
        return service.getAllContinentes();
    }

    @GetMapping("/{id}")
    public Continente getById(@PathVariable int id) {
        return service.getContinenteById(id);
    }

    @PostMapping
    public void create(@RequestBody Continente continente) {
        service.addContinente(continente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteContinenteById(id);
    }
}
