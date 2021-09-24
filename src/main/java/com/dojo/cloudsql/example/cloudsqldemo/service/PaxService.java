package com.dojo.cloudsql.example.cloudsqldemo.service;

import java.util.List;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pax;

import reactor.core.publisher.Mono;

public interface PaxService {
	Mono<List<Pax>> getAll();

	Mono<Pax> get(String dni);

	Mono<Pax> save(Pax pax);

	Mono<Pax> update(Pax pax);

	Mono<Object> delete(String dni);
}
