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

import com.dojo.cloudsql.example.cloudsqldemo.domain.Orden;
import com.dojo.cloudsql.example.cloudsqldemo.service.OrdenService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/pizzeria")
public class OrdenController {
    private OrdenService service;

    @Autowired
    public OrdenController(OrdenService service){
        this.service = service;
    }

    @GetMapping(value = "/ordenes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<List<Orden>>> getAll(){
        log.info("Entering the getAll Orden method in the controller");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/orden/{ordenId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Orden>> getDerivationV1(@PathVariable Integer ordenId){
        log.info("Entering the get Order by id method in the controller");
        return new ResponseEntity<>(service.get(ordenId), HttpStatus.OK);
    }

    @PostMapping(value = "/orden", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Orden>> save(@RequestBody Orden orden){
        log.info("Entering the save Orden method in the controller");
        return new ResponseEntity<>(service.save(orden), HttpStatus.OK);
    }

    @PutMapping(value = "/orden", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Orden>> update(@RequestBody Orden orden){
        log.info("Entering the update Orden method in the controller");
        return new ResponseEntity<>(service.update(orden), HttpStatus.OK);
    }

    @DeleteMapping(value = "/orden/{ordenId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Object>> delete(@PathVariable Integer ordenId){
        log.info("Entering the delete Orden by dni method in the controller");
        return new ResponseEntity<>(service.delete(ordenId), HttpStatus.OK);
    }
}
