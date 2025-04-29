package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
	
	public Partido(Date fecha, Estadio estadio, List<Resultado> resultados) {
		this.fecha = fecha;
		this.estadio_id = estadio;
		this.resultados = resultados;
	}
	
	@Id
	private Integer id;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "estadio_id")
	private Estadio estadio_id;
	
	@OneToMany(mappedBy = "partido_id")
	private List<Resultado> resultados;
}
