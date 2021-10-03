package com.dojo.cloudsql.example.cloudsqldemo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dojo.cloudsql.example.cloudsqldemo.domain.Orden;
import com.dojo.cloudsql.example.cloudsqldemo.domain.Pizza;
import com.dojo.cloudsql.example.cloudsqldemo.domain.Ingrediente;
import com.dojo.cloudsql.example.cloudsqldemo.service.OrdenService;

import com.dojo.cloudsql.example.cloudsqldemo.service.repository.OrdenRepository;
import com.dojo.cloudsql.example.cloudsqldemo.service.repository.PizzaRepository;
import com.dojo.cloudsql.example.cloudsqldemo.service.repository.IngredienteRepository;

import com.dojo.cloudsql.example.cloudsqldemo.publisher.PubSubPublisher;

import reactor.core.publisher.Mono;
@Service
@Repository
public class OrdenServiceImpl implements OrdenService{
    private final OrdenRepository ordenRepository;
    private final PizzaRepository pizzaRepository;
    private final IngredienteRepository ingredienteRepository;

    private PubSubPublisher psp = new PubSubPublisher();

    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, PizzaRepository pizzaRepository, IngredienteRepository ingredienteRepository){
        super();
        this.ordenRepository = ordenRepository;
        this.pizzaRepository = pizzaRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public Mono<List<Orden>> getAll() {
        List<Orden> list = ordenRepository.findAll();
        return Mono.just(list);
    }

    @Override
    public Mono<Orden> get(Integer id) {
        Optional<Orden> ordenDB = ordenRepository.findById(id);
        return Mono.just(ordenDB.get());
    }

    @Override
    public Mono<Orden> save(Orden orden) {
        Orden ordenNueva = ordenRepository.save(orden);
        for (Pizza pizza : orden.getPizzas()) {
            pizza.setOrden(ordenNueva);
            pizzaRepository.save(pizza);
        }
        //agregar ingredientes?
        psp.publicarMensaje("se ha guardado la orden: " + ordenNueva.getId());
        return Mono.just(ordenNueva);
    }

    @Override
    public Mono<Orden> update(Orden orden) {
        Optional<Orden> ordenDB = ordenRepository.findById(orden.getId());
        
        if (ordenDB.isPresent()) {
            for (Pizza pizza : orden.getPizzas()) {
                pizza.setOrden(orden);
                pizzaRepository.save(pizza);
            }
            psp.publicarMensaje("se ha actualizado la orden: " + orden.getId());
            return Mono.just(ordenRepository.save(orden));
        }else{
            return Mono.just(ordenDB.get());
        }
        
    }

    @Override
    public Mono<Object> delete(Integer id) {
        Optional<Orden> ordenDB = ordenRepository.findById(id);
        Orden temp = null;
        if (ordenDB.isPresent()) {
            temp = ordenDB.get();
            pizzaRepository.deleteByOrden(temp);
            ordenRepository.delete(temp);
        }
        psp.publicarMensaje("se ha actualizado la orden: " + id);
        return Mono.just(ordenRepository.findById(id));
    }
}
