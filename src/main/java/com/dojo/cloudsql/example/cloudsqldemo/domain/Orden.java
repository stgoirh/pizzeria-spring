package com.dojo.cloudsql.example.cloudsqldemo.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Orden")
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private Integer id;
    @Column(name = "monto_total")
    private int montoTotal;
    @Column(name = "nombre_cliente")
    private String nombreCliente;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "orden", cascade = CascadeType.MERGE)
    private List<Pizza> pizzas = new ArrayList<>();

    @Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
