package com.dojo.cloudsql.example.cloudsqldemo.service;

import java.util.List;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Orden;

import reactor.core.publisher.Mono;

public interface OrdenService {
    Mono<List<Orden>> getAll();

    Mono<Orden> get(Integer id);

    Mono<Orden> save(Orden orden);

    Mono<Orden> update(Orden orden);

	Mono<Object> delete(Integer id);
}
