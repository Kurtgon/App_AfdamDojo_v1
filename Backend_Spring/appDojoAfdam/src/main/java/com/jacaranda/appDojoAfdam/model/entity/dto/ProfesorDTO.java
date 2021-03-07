package com.jacaranda.appDojoAfdam.model.entity.dto;

import java.util.List;

import com.jacaranda.appDojoAfdam.model.entity.Clase;
import com.jacaranda.appDojoAfdam.model.entity.Mensaje;

public class ProfesorDTO {

	// Atributos
	private int id;
	private String name;
	private String surnames;
	private String dni;
	private String tfl;
	private List<Clase> clases;
	
	//Get y Set
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
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	public int getId() {
		return id;
	}
	
	
}

