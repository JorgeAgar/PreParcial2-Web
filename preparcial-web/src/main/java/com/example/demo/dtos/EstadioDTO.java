package com.example.demo.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadioDTO {
	
	private int id;	
	private String nombre;
	private int capacidad;
	private List<Integer> ids_partidos;
}
