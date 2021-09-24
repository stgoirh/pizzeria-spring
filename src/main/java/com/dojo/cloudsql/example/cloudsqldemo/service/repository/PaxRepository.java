package com.dojo.cloudsql.example.cloudsqldemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pax;

public interface PaxRepository extends JpaRepository<Pax, String> {

}
