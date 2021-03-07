package com.jacaranda.appDojoAfdam.model.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pago {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private static final int PAYDAY = 28;
	private String mensaje;

	// relación objeto alumno
	@ManyToOne
	@JoinColumn(name="idAlumno", foreignKey = @ForeignKey(name="FK_Alumno_pagos"))
	private Alumno idAlumno;

	// Constructor
	public Pago() {
	}

	public Pago(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	// Get y Set
	public String getMensaje() {
		LocalDate fechaHoy = LocalDate.now();

		if (PAYDAY == fechaHoy.getDayOfMonth()) {
			mensaje = "Hoy es el día del cobro";
		}
		if (fechaHoy.getDayOfMonth() == PAYDAY - 3) {
			mensaje = "Quedan 3 días para el cobro";
		}
		if (fechaHoy.getDayOfMonth() == PAYDAY - 5) {
			mensaje = "Quedan 5 días para el cobro";
		}
		if (fechaHoy.getDayOfMonth() == PAYDAY - 7) {
			mensaje = "Quedan 7 días para el cobro";
		}
		return mensaje;
	}

	public int getId() {
		return id;
	}

}
