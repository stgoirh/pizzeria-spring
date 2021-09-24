package com.dojo.cloudsql.example.cloudsqldemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pax;
import com.dojo.cloudsql.example.cloudsqldemo.domain.Travel;
import com.dojo.cloudsql.example.cloudsqldemo.service.PaxService;
import com.dojo.cloudsql.example.cloudsqldemo.service.repository.PaxRepository;
import com.dojo.cloudsql.example.cloudsqldemo.service.repository.TravelRepository;

import reactor.core.publisher.Mono;

@Service
public class PaxServiceImpl implements PaxService {

	private final PaxRepository paxRepository;
	private final TravelRepository travelRepository;

	@Autowired
	public PaxServiceImpl(PaxRepository paxRepository, TravelRepository travelRepository) {
		super();
		this.paxRepository = paxRepository;
		this.travelRepository = travelRepository;
	}

	@Override
	public Mono<List<Pax>> getAll() {
		List<Pax> list = paxRepository.findAll();
		return Mono.just(list);
	}

	@Override
	public Mono<Pax> get(String dni) {
		Optional<Pax> paxBD = paxRepository.findById(dni);
		return Mono.just(paxBD.get());
	}

	@Override
	public Mono<Pax> save(Pax pax) {
		Optional<Pax> paxBD = paxRepository.findById(pax.getDni());
		if (paxBD.isPresent()) {
			return Mono.just(paxBD.get());
		}
		for (Travel travel : pax.getTravels()) {
			travel.setPax(pax);
		}
		return Mono.just(paxRepository.save(pax));
	}

	@Override
	public Mono<Pax> update(Pax pax) {
		Optional<Pax> paxBD = paxRepository.findById(pax.getDni());
		if (paxBD.isPresent()) {
			for (Travel travel : pax.getTravels()) {
				travel.setPax(pax);
			}
			return Mono.just(paxRepository.save(pax));
		} else {
			return Mono.just(paxBD.get());
		}
	}

	@Override
	public Mono<Object> delete(String dni) {
		Optional<Pax> paxBD = paxRepository.findById(dni);
		Pax tempPax = null;
		if (paxBD.isPresent()) {
			tempPax = paxBD.get();
			travelRepository.deleteByPax(tempPax);
			paxRepository.delete(tempPax);
		}
		return Mono.just(paxRepository.findById(dni));
	}

}
