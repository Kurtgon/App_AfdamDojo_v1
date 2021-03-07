package com.jacaranda.appDojoAfdam.security.model.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jacaranda.appDojoAfdam.security.model.User;
import com.jacaranda.appDojoAfdam.security.model.UserRole;

@Component
public class UserDTOConverter {

	// Inyectamos el servicio PasswordEncoder
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Creamos el método para convertir de un usuario a un dto
	public User fromUserDTOToUser(UserDTO dto) {
		// Creamos un objeto User
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRoles(Set.of(UserRole.STUDENT));
		user.setCreateTime(LocalDateTime.now());
		user.setUpdateTime(LocalDateTime.now());
		user.setLastPasswordChange(LocalDateTime.now());
		user.setLocked(false);
		user.setEnabled(true);
		user.setAuthenticationAttempts(0);
		user.setPasswordPolicyExpDate(LocalDateTime.now().plusDays(180));
		return user;
	}

	// Creamos el método para convetir de un dto a un usuario
	public UserDTO fromUserToUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setRoles(user.getRoles());
		return dto;
	}

}
