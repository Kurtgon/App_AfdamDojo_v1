package com.jacaranda.appDojoAfdam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;
import com.jacaranda.appDojoAfdam.repo.AlumnoRepository;

@Service
public class AlumnoServices {
	
	//Inyectamos el repositorio el alumno
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	//Añadimos el alumno
	public Alumno addAlumno(Alumno sent)throws Exception{
		
		String alumnoDni = sent.getDni();
		Alumno alumno = alumnoRepository.findAlumnoByDni(alumnoDni);
		if(alumno != null) {
			throw new Exception("El alumno ya existe");
		}
		alumnoRepository.save(sent);
		return sent;
	}

	
	//Modificamos al alumno
	public Alumno updateAlumno(Alumno sent) throws Exception {
		
		Alumno alumno = alumnoRepository.findAlumnoByDni(sent.getDni());
		if(alumno == null) {
			throw new Exception("El alumno no existe");
		}
		alumno.setName((sent.getName()== null)? alumno.getName(): sent.getName());
		alumno.setSurnames((sent.getSurnames()==null)? alumno.getSurnames(): sent.getSurnames());
		alumno.setTfl((sent.getTfl()==null)? alumno.getTfl(): sent.getTfl());
		alumno.setAddress((sent.getAddress()==null)? alumno.getAddress(): sent.getAddress());
		alumno.setBirthdate((sent.getBirthdate()==null)? alumno.getBirthdate(): sent.getBirthdate());
		alumno.setContact((sent.getContact()==null)? alumno.getContact(): alumno.getContact());
		alumno.setAllergy((sent.getAllergy()==null)? alumno.getAllergy(): alumno.getAllergy());
		
		return alumnoRepository.save(sent); 
	}
	
	//Eliminar un alumno
	public Alumno deleteAlumno(int id) throws Exception {
		Alumno alumno = alumnoRepository.findAlumnoById(id);
		if(alumno == null) {
			throw new Exception("El alumno no existe");
		}
		alumnoRepository.delete(alumno);
		return alumno;
	}
}
