package com.example.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partido {
	
	@Id
	private int id;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private int estadio_id;
}
