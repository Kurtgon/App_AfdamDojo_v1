package com.jacaranda.appDojoAfdam.repo;

import org.springframework.data.repository.CrudRepository;

import com.jacaranda.appDojoAfdam.model.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer>{

	public Persona findPersonaById(int id);
	
	public Persona findPersonaByDni(String dni);
	
	
}
