package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seleccion {
	
	public Seleccion(String nombre, Continente continente, String grupo, List<Resultado> resultados) {
		this.nombre = nombre;
		this.continente_id = continente;
		this.grupo = grupo;
		this.resultados = resultados;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "continente_id")
	private Continente continente_id;
	
	private String grupo;
	
	@OneToMany(mappedBy = "seleccion_id")
	private List<Resultado> resultados;
}
