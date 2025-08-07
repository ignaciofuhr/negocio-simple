package com.softcon.negociosimple.controller;

import com.softcon.negociosimple.dto.GastoDTO;
import com.softcon.negociosimple.model.Gasto;
import com.softcon.negociosimple.service.GastoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {
	
	private final GastoService gastoService;
	
	public GastoController(GastoService gastoService) {
		this.gastoService = gastoService;
	}
	
	@Operation(summary = "Listar todos los gastos")
	@GetMapping
	public List<Gasto> findAll() {
		return gastoService.findAll();
	}
	
	@Operation(summary = "Crear un nuevo gasto")
	@PostMapping
	public Gasto crear(@RequestBody GastoDTO gastoDto) {
		return gastoService.create(gastoDto);
	}
}