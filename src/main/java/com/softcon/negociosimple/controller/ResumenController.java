package com.softcon.negociosimple.controller;

import com.softcon.negociosimple.service.GastoService;
import com.softcon.negociosimple.service.IngresoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/resumen")
public class ResumenController {
	
	private final GastoService gastoService;
	private final IngresoService ingresoService;
	
	public ResumenController(GastoService gastoService, IngresoService ingresoService) {
		this.gastoService = gastoService;
		this.ingresoService = ingresoService;
	}
	
	@GetMapping
	public Map<String, BigDecimal> obtenerResumen() {
		BigDecimal totalGastos = gastoService.sumarMontos();
		BigDecimal totalIngresos = ingresoService.sumarMontos();
		BigDecimal resultado = totalIngresos.subtract(totalGastos);
		
		Map<String, BigDecimal> resumen = new HashMap<>();
		resumen.put("totalGastos", totalGastos);
		resumen.put("totalIngresos", totalIngresos);
		resumen.put("resultadoNeto", resultado);
		
		return resumen;
	}
}
