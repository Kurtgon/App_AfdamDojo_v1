package com.jacaranda.appDojoAfdam.model.entity;



import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.lang.NonNull;

import com.jacaranda.appDojoAfdam.security.model.User;


@Entity
@Table(name="Persona")
@Inheritance (strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Persona_Puesto")
public abstract class Persona {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	private String surnames;
	@Column(unique = true)
	private String dni;
	private String tfl;
	private String address;
	private String birthdate;

	// private byte[]imagen;

	//Relación con Usuario one to one unidireccional
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	// Constructor
	public Persona() {

	}

	public Persona(String name, String surnames, String tfl, String address, String birthdate) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.tfl = tfl;
		this.address = address;
		this.birthdate = birthdate;
	}

	// Get y Set
	public int getId() {
		return id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

}
