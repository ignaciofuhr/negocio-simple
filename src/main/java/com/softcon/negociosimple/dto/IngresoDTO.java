package com.softcon.negociosimple.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IngresoDTO {
	public String descripcion;
	public BigDecimal monto;
	public LocalDate fecha;
	public String categoria;
}
