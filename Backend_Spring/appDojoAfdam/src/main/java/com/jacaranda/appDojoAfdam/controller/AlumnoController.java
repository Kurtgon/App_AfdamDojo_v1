package com.jacaranda.appDojoAfdam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;
import com.jacaranda.appDojoAfdam.repo.PersonaRepository;
import com.jacaranda.appDojoAfdam.services.AlumnoServices;
import com.jacaranda.appDojoAfdam.services.PersonaServices;

@CrossOrigin
@RestController
@RequestMapping(path = "/alumno")
public class AlumnoController {

	// Inyectamos el repositorio
	@Autowired
	private PersonaRepository personaRepository;

	// Inyectamos el servicio
	@Autowired
	private AlumnoServices alumnoServices;

	private CrudRepository<Alumno, Integer> crudRepository;

	// Método Get
	@GetMapping("/{id}")
	public ResponseEntity<?> getAlumnoId(@PathVariable int id) {
		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.status(HttpStatus.OK).body(crudRepository.findById(id));

		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe");
		}
		return response;
	}

	// Método Post
	@PostMapping
	public ResponseEntity<?> addAlumno(@RequestBody Alumno sent) {

		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.ok(alumnoServices.addAlumno(sent));

		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;

	}

	// Método Put
	@PutMapping
	public ResponseEntity<?> updateAlummno(@RequestBody Alumno sent) {
		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.ok(alumnoServices.updateAlumno(sent));

		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}

	// Método Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAlumno(@PathVariable int id){
		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.ok(alumnoServices.deleteAlumno(id));
		}catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
		}
	
}
