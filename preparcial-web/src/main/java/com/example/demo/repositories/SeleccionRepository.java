package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer>{

}
