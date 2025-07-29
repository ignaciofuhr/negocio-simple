package com.softcon.negociosimple.service;

import com.softcon.negociosimple.dto.IngresoDTO;
import com.softcon.negociosimple.model.Ingreso;
import com.softcon.negociosimple.repository.IngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngresoService {
	
	@Autowired
	private IngresoRepository ingresoRepository;
	
	public Ingreso create(IngresoDTO dto) {
		Ingreso ingreso = new Ingreso();
		ingreso.setDescripcion(dto.getDescripcion());
		ingreso.setMonto(dto.getMonto());
		ingreso.setFecha(dto.getFecha());
		ingreso.setCategoria(dto.getCategoria());
		return ingresoRepository.save(ingreso);
	}
	
	public List<Ingreso> getAll() {
		return ingresoRepository.findAll();
	}
	
	public BigDecimal sumarMontos() {
		return ingresoRepository.findAll()
				.stream()
				.map(Ingreso::getMonto)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}