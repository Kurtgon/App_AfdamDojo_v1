package com.jacaranda.appDojoAfdam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

	public Alumno findAlumnoById(int id);

	public Alumno findAlumnoByDni(String dni);
	
	
	
	@Query(value = "select * from alumno order by birthdate desc", nativeQuery = true)
	public List<Alumno> findAllOrderedByAge();
	
	//Funcionalidad para el admin
//	@Query(value = "select * from alumno where disciplina = KICKBOXING", nativeQuery= true)
//	public List<Alumno> findByDisciplina();
	
	
}
