package com.jacaranda.appDojoAfdam.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;
import com.jacaranda.appDojoAfdam.model.entity.enums.Disciplinas;
import com.jacaranda.appDojoAfdam.security.model.User;
import com.jacaranda.appDojoAfdam.security.model.UserRole;
import com.jacaranda.appDojoAfdam.security.repo.UserRepository;

@Component
public class RegistroDTOConverter {
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Registro a User
	public User FromRegistroDTOToUser(RegistroDTO dto) {
		//Creamos el objeto
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setEmail(dto.getEmail());
		user.setRoles(Set.of(UserRole.STUDENT));
		user.setAuthenticationAttempts(0);
		user.setCreateTime(LocalDateTime.now());
		user.setEnabled(true);
		user.setLastPasswordChange(LocalDateTime.now());
		user.setLocked(false);
		user.setPasswordPolicyExpDate(LocalDateTime.now().plusMonths(6));
		user.setUpdateTime(LocalDateTime.now());
		
		return user;
		
	}
	
	//Registro a Alumno
	public Alumno FromRegistroDTOToAlumno(RegistroDTO dto) {
		//Creamos el alumno
		Alumno alumno = new Alumno();
		alumno.setName(dto.getName());
		alumno.setSurnames(dto.getSurnames());
		alumno.setDni(dto.getDni());
		alumno.setTfl(dto.getTfl());
		alumno.setAddress(dto.getAddress());
		alumno.setBirthdate(dto.getBirthdate());
		alumno.setContact(dto.getContact());
		alumno.setAllergy(dto.getAllergy());
		alumno.setPaymentDate(dto.getPaymentDate());
		alumno.setDisciplina(Disciplinas.valueOf(dto.getDisciplinas()));
		String username = dto.getUsername();
		User user = userRepository.findUserByUsername(username);
		alumno.setUser(user);
		return alumno;
		
	}

}
