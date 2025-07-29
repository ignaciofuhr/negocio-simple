package com.softcon.negociosimple.service;

import com.softcon.negociosimple.model.Gasto;
import com.softcon.negociosimple.repository.GastoRepository;
import org.springframework.stereotype.Service;

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
	
	public Gasto create(Gasto gasto) {
		return gastoRepository.save(gasto);
	}
}