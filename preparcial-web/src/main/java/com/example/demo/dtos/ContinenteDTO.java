package com.example.demo.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContinenteDTO {

	private int id;
	private String nombre;
	private List<Integer> ids_selecciones;
	
}