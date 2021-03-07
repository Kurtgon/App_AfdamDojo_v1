package com.jacaranda.appDojoAfdam.model.entity.dto;

import org.springframework.stereotype.Component;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;

@Component
public class DatosPersonalesAlumnoDtoConverter {

	// Funcionalidad para modificar los datos personales del alumno
	// A partir del dto creamos el alumno que se guarda en la bbdd
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		Alumno alumno = new Alumno();
		alumno.setName(dto.getName());
		alumno.setSurnames(dto.getSurnames());
		alumno.setDni(dto.getDni());
		alumno.setTfl(dto.getTfl());
		alumno.setAddress(dto.getAddress());
		alumno.setBirthdate(dto.getBirthdate());
		alumno.setContact(dto.getContact());
		alumno.setAllergy(dto.getAllergy());
		alumno.setDisciplina(dto.getDisciplina());

		return alumno;
	}

	// A partir de un alumno creamos el dto
	public AlumnoDTO fromAlumnoToAlumnoDTO(Alumno alumno) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setName(alumno.getName());
		dto.setSurnames(alumno.getSurnames());
		dto.setDni(alumno.getDni());
		dto.setTfl(alumno.getTfl());
		dto.setAddress(alumno.getAddress());
		dto.setBirthdate(alumno.getBirthdate());
		dto.setContact(alumno.getContact());
		dto.setAllergy(alumno.getAllergy());
		dto.setDisciplina(alumno.getDisciplina());

		return dto;
	}

}
