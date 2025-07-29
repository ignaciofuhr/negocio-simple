package com.softcon.negociosimple.repository;

import com.softcon.negociosimple.model.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
