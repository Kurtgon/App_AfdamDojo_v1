package com.jacaranda.appDojoAfdam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.appDojoAfdam.model.entity.Profesor;
import com.jacaranda.appDojoAfdam.repo.ProfesorRepository;

@Service
public class ProfesorServices {

	// Inyectamos el repositorio
	@Autowired
	private ProfesorRepository profesorRepository;

	// Añadimos un profesor
	public Profesor addProfesor(Profesor sent) throws Exception {
		String dniProfesor = sent.getDni();
		Profesor profesor = profesorRepository.findProfesorByDni(dniProfesor);
		if (profesor != null) {
			throw new Exception("El profesor ya existe");
		}
		profesorRepository.save(sent);
		return sent;
	}

	// Modificar un profesor
	public Profesor updateProfesor(Profesor sent) throws Exception {
		Profesor profesor = profesorRepository.findProfesorByDni(sent.getDni());
		if (profesor == null) {
			throw new Exception("El profesor no existe");
		}
		profesor.setName((sent.getName() == null ? profesor.getName() : sent.getName()));
		profesor.setSurnames((sent.getSurnames() == null ? profesor.getSurnames() : sent.getSurnames()));
		profesor.setTfl((sent.getTfl() == null ? profesor.getTfl() : sent.getTfl()));
		profesor.setAddress((sent.getAddress() == null ? profesor.getAddress() : sent.getAddress()));
		profesor.setBirthdate((sent.getBirthdate() == null ? profesor.getBirthdate() : sent.getBirthdate()));

		return profesorRepository.save(sent);
		}

	// Eliminar un profesor
	public Profesor deleteProfesor(int id) throws Exception {
		Profesor profesor = profesorRepository.findProfesorById(id);
		if( profesor == null) {
			throw new Exception("El profesor no existe");
			}
		profesorRepository.delete(profesor);
		return profesor;
		}
}

