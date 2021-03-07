package com.jacaranda.appDojoAfdam.model.entity.dto;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;

public class MensajesAlumnosDtoConverter {

	// Funcionalidad para los mensajes de los alumnos a partir del dto
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		Alumno alumno = new Alumno();
		alumno.setMensajes(dto.getMensajes());
		return alumno;
	}

	// Funcionalidad para los mensajes de los alumnos a partir de un alumno
	public AlumnoDTO fromAlumnoToAlumnoDTO(Alumno alumno) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setMensajes(alumno.getMensajes());
		return dto;
	}

}
