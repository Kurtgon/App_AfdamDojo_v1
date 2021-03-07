package com.jacaranda.appDojoAfdam.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Mensaje {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String subject;
	private String description;

	// Relaciones con una lista de estudiantes y un objeto profesor
	@ManyToOne
	@JoinColumn(name="idRemitente", foreignKey = @ForeignKey(name="FK_Profesor_mensaje"))
	private Profesor remitente;
	
	@ManyToMany(mappedBy = "mensajes")
	private List<Alumno>students;

	// Constructor
	public Mensaje() {
		this.students = new ArrayList<>();
	}

	public Mensaje(String title, String subject, String description) {
		super();
		this.title = title;
		this.subject = subject;
		this.description = description;
		this.students = new ArrayList<>();
	}

	// Get y Set
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
