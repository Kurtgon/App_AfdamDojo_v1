package com.jacaranda.appDojoAfdam.model.entity.dto;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;

public class ClasesAlumnosDtoConverter {
	
	//Funcionalidad para las clases de los alumnos a partir del dto
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		Alumno alumno = new Alumno();
		alumno.setClases(dto.getClases());
		
		return alumno;
	}
	
	//Funcionalidad para las clases de los alumnos a partir de un alumno
	public AlumnoDTO fromAlumnoToAlumnoDTO(Alumno alumno) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setClases(alumno.getClases());
		
		return dto;
	}

}