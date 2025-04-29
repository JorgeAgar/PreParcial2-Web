package com.example.demo.controllers;

import com.example.demo.dtos.ContinenteDTO;
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
    public List<ContinenteDTO> getAll() {
        return service.getAllContinentes();
    }

    @GetMapping("/{id}")
    public ContinenteDTO getById(@PathVariable int id) {
        return service.getContinenteById(id);
    }

    @PostMapping
    public void create(@RequestBody ContinenteDTO continente) {
        service.addContinente(continente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteContinenteById(id);
    }
}
