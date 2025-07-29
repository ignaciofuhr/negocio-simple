package com.softcon.negociosimple.repository;

import com.softcon.negociosimple.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
}