package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Estadio;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Integer>{

}
