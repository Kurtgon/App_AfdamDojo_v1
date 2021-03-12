package com.jacaranda.appDojoAfdam.model.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.jacaranda.appDojoAfdam.model.entity.Clase;
import com.jacaranda.appDojoAfdam.model.entity.Mensaje;
import com.jacaranda.appDojoAfdam.model.entity.Pago;
import com.jacaranda.appDojoAfdam.model.entity.enums.Disciplinas;

public class AlumnoDTO {

	// Atributos
	private int id;
	private String name;
	private String surnames;
	private String dni;
	private String tfl;
	private String address;
	private String birthdate;
	private String contact;
	private String allergy;
	private LocalDateTime paymentDate;
	private Disciplinas disciplina;
	private List<Pago> pagos;
	private List<Clase> clases;
	private List<Mensaje> mensajes;

	
	
	public AlumnoDTO() {
	}

	// Get y Set
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTfl() {
		return tfl;
	}

	public void setTfl(String tfl) {
		this.tfl = tfl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

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