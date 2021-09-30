package com.dojo.cloudsql.example.cloudsqldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Pax;
import com.dojo.cloudsql.example.cloudsqldemo.service.PaxService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/dal/v1")
public class PaxController {

	private PaxService service;

	@Autowired
	public PaxController(PaxService service) {
		this.service = service;
	}

	@GetMapping(value = "/pax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<List<Pax>>> getAll() {
		log.info("Entering the getAll Pax method in the controller");
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/pax/{paxDni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Pax>> getDerivationV1(@PathVariable String paxDni) {
		log.info("Entering the get Pax by dni method in the controller");
		return new ResponseEntity<>(service.get(paxDni), HttpStatus.OK);
	}

	@PostMapping(value = "/pax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Pax>> save(@RequestBody Pax pax) {
		log.info("Entering the save Pax method in the controller");
		return new ResponseEntity<>(service.save(pax), HttpStatus.OK);
	}

	@PutMapping(value = "/pax", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Pax>> update(@RequestBody Pax pax) {
		log.info("Entering the update Pax method in the controller");
		return new ResponseEntity<>(service.update(pax), HttpStatus.OK);
	}

	@DeleteMapping(value = "/pax/{paxDni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Mono<Object>> delete(@PathVariable String paxDni) {
		log.info("Entering the delete Pax by dni method in the controller");
		return new ResponseEntity<>(service.delete(paxDni), HttpStatus.OK);
	}
}
