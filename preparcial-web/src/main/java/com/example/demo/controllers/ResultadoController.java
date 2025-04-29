package com.example.demo.controllers;

import com.example.demo.dtos.ResultadoDTO;
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
    public List<ResultadoDTO> getAll() {
        return service.getAllResultados();
    }

    @GetMapping("/{id}")
    public ResultadoDTO getById(@PathVariable int id) {
        return service.getResultadoById(id);
    }

    @PostMapping
    public void create(@RequestBody ResultadoDTO resultado) {
        service.addResultado(resultado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteResultadoById(id);
    }
}
