package com.example.demo.controllers;

import com.example.demo.entities.Resultado;
import com.example.demo.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    @Autowired
    private ResultadoService service;

    @GetMapping
    public List<Resultado> getAll() {
        return service.getAllResultados();
    }

    @GetMapping("/{id}")
    public Resultado getById(@PathVariable int id) {
        return service.getResultadoById(id);
    }

    @PostMapping
    public void create(@RequestBody Resultado resultado) {
        service.addResultado(resultado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteResultadoById(id);
    }
}
