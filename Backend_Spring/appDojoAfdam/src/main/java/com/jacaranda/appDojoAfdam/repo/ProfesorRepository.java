package com.jacaranda.appDojoAfdam.repo;

import org.springframework.data.repository.CrudRepository;


import com.jacaranda.appDojoAfdam.model.entity.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Integer>{
	
	public Profesor findProfesorById(int id);

	public Profesor findProfesorByDni(String dni);

}
