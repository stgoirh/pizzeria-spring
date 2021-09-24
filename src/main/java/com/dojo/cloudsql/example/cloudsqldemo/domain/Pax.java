package com.dojo.cloudsql.example.cloudsqldemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.Gson;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Pax")
@Table(name = "pax")
public class Pax {
	@Id
	private String dni;
	private String name;
	@Column(name = "last_name")
	private String lastName;
	private Integer status;
	@OneToMany(mappedBy = "pax", cascade = CascadeType.MERGE)
	private List<Travel> travels = new ArrayList<>();

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
