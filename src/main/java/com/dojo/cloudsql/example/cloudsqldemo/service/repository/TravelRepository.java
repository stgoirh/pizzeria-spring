package com.dojo.cloudsql.example.cloudsqldemo.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pax;
import com.dojo.cloudsql.example.cloudsqldemo.domain.Travel;

public interface TravelRepository extends JpaRepository<Travel, String> {

	@Transactional
	@Modifying
	@Query("DELETE FROM Travel WHERE pax = :pax")
	void deleteByPax(@Param("pax") Pax pax);
}
