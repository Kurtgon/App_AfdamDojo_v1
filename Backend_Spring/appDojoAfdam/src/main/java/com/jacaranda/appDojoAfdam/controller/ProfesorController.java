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


import com.jacaranda.appDojoAfdam.model.entity.Profesor;
import com.jacaranda.appDojoAfdam.repo.ProfesorRepository;
import com.jacaranda.appDojoAfdam.services.ProfesorServices;
@CrossOrigin
@RestController
@RequestMapping(path = "/profesor")
public class ProfesorController {

	@Autowired
	private ProfesorRepository profesorRepository;

	@Autowired
	private ProfesorServices profesorServices;

	@Autowired
	private CrudRepository<Profesor, Integer> crudRepository;

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
	public ResponseEntity<?> addProfesor(@RequestBody Profesor sent) {

		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.ok(profesorServices.addProfesor(sent));

		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}

	// Método Put
	@PutMapping
	public ResponseEntity<?> updateProfesor(@RequestBody Profesor sent) {
		ResponseEntity<?> response = null;
		try {
			response = ResponseEntity.ok(profesorServices.updateProfesor(sent));

		} catch (Exception e) {
			response = ResponseEntity.badRequest().body(e.getMessage());
		}
		return response;
	}
	
	// Método Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProfesor(@PathVariable int id){
		ResponseEntity<?> response = null;
		try {
			
		}catch (Exception e) {
			
		}
		return response;
		}
}
