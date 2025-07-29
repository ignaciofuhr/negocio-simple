package com.softcon.negociosimple.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Gasto {
	
	// Getters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	private BigDecimal monto;
	private LocalDate fecha;
	private String categoria;
	
	// Setters
	public void setId(Long id) { this.id = id; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public void setMonto(BigDecimal monto) { this.monto = monto; }
	public void setFecha(LocalDate fecha) { this.fecha = fecha; }
	public void setCategoria(String categoria) { this.categoria = categoria; }
}