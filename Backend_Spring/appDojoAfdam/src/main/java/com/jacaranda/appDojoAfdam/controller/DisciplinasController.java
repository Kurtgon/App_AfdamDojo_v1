package com.jacaranda.appDojoAfdam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.appDojoAfdam.model.entity.enums.Disciplinas;
@CrossOrigin
@RestController
@RequestMapping(path = "/disciplinas")
public class DisciplinasController {
	

	// Método Get
	@GetMapping
	public ResponseEntity<?> getAllDisciplinas(){
		ResponseEntity<?> resp = null;
		List<String>disciplinas = new ArrayList<>();
		
		disciplinas.add(Disciplinas.CARDIOFITBAG.name());
		disciplinas.add(Disciplinas.JIUJITSU.name());
		disciplinas.add(Disciplinas.KICKBOXING.name());
		disciplinas.add(Disciplinas.MMA.name());
		disciplinas.add(Disciplinas.NINJUSTSU.name());
		disciplinas.add(Disciplinas.TAICHI.name());
		
		resp = ResponseEntity.ok(disciplinas);
		
		return resp;
		
	}
}
