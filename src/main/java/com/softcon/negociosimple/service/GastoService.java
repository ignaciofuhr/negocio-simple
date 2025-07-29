package com.softcon.negociosimple.service;

import com.softcon.negociosimple.dto.GastoDTO;
import com.softcon.negociosimple.model.Gasto;
import com.softcon.negociosimple.repository.GastoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GastoService {
	
	private final GastoRepository gastoRepository;
	
	public GastoService(GastoRepository gastoRepository) {
		this.gastoRepository = gastoRepository;
	}
	
	public List<Gasto> findAll() {
		return gastoRepository.findAll();
	}
	
	public Gasto create(GastoDTO dto) {
		Gasto gasto = new Gasto();
		gasto.setDescripcion(dto.getDescripcion());
		gasto.setMonto(dto.getMonto());
		gasto.setFecha(dto.getFecha());
		gasto.setCategoria(dto.getCategoria());
		return gastoRepository.save(gasto);
	}
	
	public BigDecimal sumarMontos() {
		return gastoRepository.findAll()
				.stream()
				.map(Gasto::getMonto)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}