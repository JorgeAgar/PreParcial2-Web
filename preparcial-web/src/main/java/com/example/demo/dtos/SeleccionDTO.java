package com.example.demo.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeleccionDTO {

	private int id;	
	private String nombre;
	private int continente_id;
	private String grupo;
	private List<Integer> ids_resultados;
}