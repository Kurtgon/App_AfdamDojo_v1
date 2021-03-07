package com.jacaranda.appDojoAfdam.model.entity.dto;

import com.jacaranda.appDojoAfdam.model.entity.Profesor;

public class DatosPersonalesProfesorDtoConverter {

	// Funcionalidad para modificar los datos personales del profesor
	// A partir del dto creamos el profesor que se guarda en la bbdd
	public Profesor fromProfesorDTOToProfesor(ProfesorDTO dto) {
		Profesor profesor = new Profesor();
		profesor.setName(dto.getName());
		profesor.setSurnames(dto.getSurnames());
		profesor.setDni(dto.getDni());
		profesor.setTfl(dto.getTfl());
		profesor.setClases(dto.getClases());
		return profesor;
	}
	
	// A partir del profesor creamos el dto
	public ProfesorDTO fromProfesorToProfesorDTO(Profesor profesor) {
		ProfesorDTO dto = new ProfesorDTO();
		dto.setName(profesor.getName());
		dto.setSurnames(profesor.getSurnames());
		dto.setDni(profesor.getDni());
		dto.setTfl(profesor.getTfl());
		dto.setClases(dto.getClases());
		return dto;
	}
}