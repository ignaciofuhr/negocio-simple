package com.softcon.negociosimple.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class GastoDTO {
	private String descripcion;
	private BigDecimal monto;
	private LocalDate fecha;
	private String categoria;
}
