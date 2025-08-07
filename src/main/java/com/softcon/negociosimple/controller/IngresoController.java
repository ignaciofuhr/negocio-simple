package com.softcon.negociosimple.controller;

import com.softcon.negociosimple.dto.IngresoDTO;
import com.softcon.negociosimple.model.Ingreso;
import com.softcon.negociosimple.service.IngresoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {
	
	@Autowired
	private IngresoService ingresoService;
	
	@Operation(summary = "Crear un nuevo ingreso")
	@PostMapping
	public Ingreso create(@RequestBody IngresoDTO ingresoDto) {
		return ingresoService.create(ingresoDto);
	}
	
	@Operation(summary = "Listar todos los ingresos")
	@GetMapping
	public List<Ingreso> findAll() {
		return ingresoService.findAll();
	}
}