package com.jacaranda.appDojoAfdam.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.jacaranda.appDojoAfdam.model.entity.enums.Disciplinas;

@Entity
public class Clase {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private Disciplinas disciplina;

	private String starHour;

	private String endHour;

	// relación con una lista de alumnos, objeto profesor
	@ManyToMany(mappedBy = "clases")
	private List<Alumno> students;

	@ManyToOne
	@JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "FK_Profesor_clases"))
	private Profesor idProfesor;

	// Constructor
	public Clase() {
		this.students = new ArrayList<>();
	}

	public Clase(Disciplinas disciplina, String starHour, String endHour) {
		super();
		this.disciplina = disciplina;
		this.starHour = starHour;
		this.endHour = endHour;
		this.students = new ArrayList<>();
	}

	// Get y Set
	public Disciplinas getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplinas disciplina) {
		this.disciplina = disciplina;
	}

	public String getStarHour() {
		return starHour;
	}

	public void setStarHour(String starHour) {
		this.starHour = starHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public List<Alumno> getStudents() {
		return students;
	}

	public void setStudents(List<Alumno> students) {
		this.students = students;
	}

	public Profesor getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Profesor idProfesor) {
		this.idProfesor = idProfesor;
	}
	
	

}
