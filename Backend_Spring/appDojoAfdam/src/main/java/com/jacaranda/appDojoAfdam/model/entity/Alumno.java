package com.jacaranda.appDojoAfdam.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.jacaranda.appDojoAfdam.model.entity.enums.Disciplinas;

@Entity
@DiscriminatorValue(value = "Alumno")
public class Alumno extends Persona {

	// Atributos
	private String contact;
	private String allergy;
	private LocalDateTime paymentDate;
	@Enumerated(EnumType.STRING)
	private Disciplinas disciplina;

	//Relación con lista de pago, lista de clase y lista mensaje
	@OneToMany(mappedBy="idAlumno", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pago> pagos;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Clase> clases;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mensaje> mensajes;
	
	// Constructor
	public Alumno() {
		this.clases = new ArrayList<>();
		this.pagos = new ArrayList<>();
		this.mensajes = new ArrayList<>();
	}

	public Alumno(String contact, String allergy, LocalDateTime paymentDate, Disciplinas disciplina) {
		super();
		this.contact = contact;
		this.allergy = allergy;
		this.paymentDate = paymentDate;
		this.disciplina = disciplina;
		this.clases = new ArrayList<>();
		this.pagos = new ArrayList<>();
		this.mensajes = new ArrayList<>();
	}
	

	// Get y Set
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAllergy() {
		return allergy;
	}

	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}
	

	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	// Preguntar a José
	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	
}
