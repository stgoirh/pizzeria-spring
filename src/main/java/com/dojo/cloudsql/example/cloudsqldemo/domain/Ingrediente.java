package com.dojo.cloudsql.example.cloudsqldemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Ingrediente")
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    private int id;
    @Column(name = "nombre")
    private String nombre;

    @Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
