package com.example.demo.dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDTO {
	
	private int id;
	private Date fecha;
	private int estadio_id;
	private List<Integer> ids_resultados;
}
