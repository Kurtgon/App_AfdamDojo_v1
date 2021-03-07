package com.jacaranda.appDojoAfdam.model.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Profesor")
public class Profesor extends Persona {

	// Atributos

	// Relación lista de clase
	@OneToMany(mappedBy = "idProfesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Clase> clases;

	// Constructor
	public Profesor() {
		this.clases = new ArrayList<>();
	}

	public Profesor(String name, String surnames, String tfl, String address, String birthdate) {
		super(name, surnames, tfl, address, birthdate);
		this.clases = new ArrayList<>();

	}

	// Get y Set lista de clases
	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

}
