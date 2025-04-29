package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.SeleccionDTO;
import com.example.demo.services.SeleccionService;

@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
	
	@Autowired
	SeleccionService selService;
	
	@GetMapping
    public List<SeleccionDTO> getAll() {
        return selService.getAllSelecciones();
    }

    @GetMapping("/{id}")
    public SeleccionDTO getById(@PathVariable int id) {
        return selService.getSeleccionById(id);
    }

    @PostMapping
    public void create(@RequestBody SeleccionDTO seleccion) {
        selService.addSeleccion(seleccion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        selService.deleteSeleccionById(id);
    }
	
}
