package com.dojo.cloudsql.example.cloudsqldemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Pizza")
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "id")
    private Integer id;
    @Column(name = "tamano")
    private String tamano;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "pizza_ingrediente",
        joinColumns = @JoinColumn(name = "pizza_id"),
        inverseJoinColumns = @JoinColumn(name = "ingrediente_id") )
    private List<Ingrediente> listaIngredientes = new ArrayList<>();
    @ManyToOne
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnore
    @JoinColumn(name = "orden_id", nullable=false)
    private Orden orden;
    @Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
