package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "partido_id")
	private Partido partido_id;
	
	@ManyToOne
	@JoinColumn(name = "seleccion_id")
	private Seleccion seleccion_id;
	
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;
}
