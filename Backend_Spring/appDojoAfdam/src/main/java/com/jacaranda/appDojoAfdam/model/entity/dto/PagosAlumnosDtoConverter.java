package com.jacaranda.appDojoAfdam.model.entity.dto;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;

public class PagosAlumnosDtoConverter {

	// Funcionalidad para el pago de los alumnos a partir del dto
	public Alumno fromAlumnoDTOToAlumno(AlumnoDTO dto) {
		Alumno alumno = new Alumno();
		alumno.setPaymentDate(dto.getPaymentDate());
		alumno.setPagos(dto.getPagos());
		return alumno;
	}

	// Funcionalidad para el pago de los alumnos a partir de un alumno
	public AlumnoDTO fromAlumnoToAlumnoDTO(Alumno alumno) {
		AlumnoDTO dto = new AlumnoDTO();
		dto.setPaymentDate(alumno.getPaymentDate());
		dto.setPagos(alumno.getPagos());

		return dto;
	}

}
