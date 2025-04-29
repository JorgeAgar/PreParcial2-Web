package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoDTO {
	
	private int id;
	private int partido_id;
	private int seleccion_id;
	private int goles;
	private int amarillas;
	private int rojas;
}
