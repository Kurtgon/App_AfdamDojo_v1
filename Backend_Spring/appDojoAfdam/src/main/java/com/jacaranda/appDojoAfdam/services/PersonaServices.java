package com.jacaranda.appDojoAfdam.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;
import com.jacaranda.appDojoAfdam.model.entity.Persona;
import com.jacaranda.appDojoAfdam.model.entity.Profesor;

@Service
public class PersonaServices {
	
	
	//Comprobamos que si la persona existe en la BBDD
	public Persona comprobarPersona(List<Persona>personas, String dni) {
		boolean encontrado = false;
		Persona resultado = null;
		Iterator<Persona> iterator = personas.iterator();
		
		while(!encontrado && iterator.hasNext()) {
			Persona nuevaPersonas = iterator.next();
			if(nuevaPersonas.getDni()==dni) {
				encontrado = true;
				resultado = nuevaPersonas;
			}
		}
		return resultado;
	}
	

}
