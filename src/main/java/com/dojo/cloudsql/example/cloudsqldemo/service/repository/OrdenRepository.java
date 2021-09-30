package com.dojo.cloudsql.example.cloudsqldemo.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer>{
    
}
