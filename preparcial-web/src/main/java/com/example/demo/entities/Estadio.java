package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadio {
	
	public Estadio(String nombre, int capacidad, List<Partido> partidos) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.partidos = partidos;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String nombre;
	private Integer capacidad;
	
	@OneToMany(mappedBy = "estadio_id")
	private List<Partido> partidos;
}
