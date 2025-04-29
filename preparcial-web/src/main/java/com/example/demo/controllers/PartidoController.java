package com.example.demo.controllers;

import com.example.demo.dtos.PartidoDTO;
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
    public List<PartidoDTO> getAll() {
        return service.getAllPartidos();
    }

    @GetMapping("/{id}")
    public PartidoDTO getById(@PathVariable int id) {
        return service.getPartidoById(id);
    }

    @PostMapping
    public void create(@RequestBody PartidoDTO partido) {
        service.addPartido(partido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deletePartidoById(id);
    }
}
