package com.jacaranda.appDojoAfdam.repo;

import org.springframework.data.repository.CrudRepository;

import com.jacaranda.appDojoAfdam.model.entity.Persona;
import com.jacaranda.appDojoAfdam.security.model.User;

public interface PersonaRepository extends CrudRepository<Persona, Integer>{

	public Persona findPersonaById(int id);
	
	public Persona findPersonaByDni(String dni);
	
	public Persona findPersonaByUser(User user);
	
	
}
