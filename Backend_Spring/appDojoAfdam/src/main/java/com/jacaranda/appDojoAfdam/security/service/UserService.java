package com.jacaranda.appDojoAfdam.security.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jacaranda.appDojoAfdam.model.entity.Alumno;
import com.jacaranda.appDojoAfdam.model.entity.dto.DatosPersonalesAlumnoDtoConverter;
import com.jacaranda.appDojoAfdam.repo.AlumnoRepository;
import com.jacaranda.appDojoAfdam.security.model.User;
import com.jacaranda.appDojoAfdam.security.model.dto.RegistroDTO;
import com.jacaranda.appDojoAfdam.security.model.dto.RegistroDTOConverter;
import com.jacaranda.appDojoAfdam.security.model.dto.UserDTO;
import com.jacaranda.appDojoAfdam.security.model.dto.UserDTOConverter;
import com.jacaranda.appDojoAfdam.security.repo.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {
	
	//Inyectamos los repositorios
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private UserDTOConverter converter;
	
	@Autowired
	private DatosPersonalesAlumnoDtoConverter alumnoConverter;
	
	@Autowired
	private RegistroDTOConverter registroDTOConverter;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found"));
	}
	
	public UserDetails loadUserById(int idUser) throws AuthenticationException {
		return userRepository.findById(idUser)
				.orElseThrow(()-> new AuthenticationException("Id/username not found"));
	}
	
	public UserDTO createNewUser(RegistroDTO registroDTO) {
		//Obtenemos el user
		User nuevoUser = registroDTOConverter.FromRegistroDTOToUser(registroDTO);
		userRepository.save(nuevoUser);
		//Creamos el Alumno
		Alumno nuevoAlumno = registroDTOConverter.FromRegistroDTOToAlumno(registroDTO);
		alumnoRepository.save(nuevoAlumno);

		return converter.fromUserToUserDTO(nuevoUser);
	}

	
	
	//Actualizamos el username, password
	public void upUser (User u, User sent) {
		u.setUsername((sent.getUsername()== null)? u.getUsername(): sent.getUsername());
		u.setPassword((sent.getPassword()== null)? u.getPassword(): sent.getPassword());
	}
}
