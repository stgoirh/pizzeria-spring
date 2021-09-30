package com.dojo.cloudsql.example.cloudsqldemo.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pizza;
import com.dojo.cloudsql.example.cloudsqldemo.domain.Orden;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    @Transactional
	@Modifying
	@Query("DELETE FROM Pizza WHERE orden = :orden")
	void deleteByOrden(@Param("orden") Orden orden);
}
