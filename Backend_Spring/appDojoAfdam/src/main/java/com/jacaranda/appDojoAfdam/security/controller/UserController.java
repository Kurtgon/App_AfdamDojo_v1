package com.jacaranda.appDojoAfdam.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jacaranda.appDojoAfdam.security.model.dto.RegistroDTO;
import com.jacaranda.appDojoAfdam.security.model.dto.UserDTO;
import com.jacaranda.appDojoAfdam.security.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/sign-up")
	public ResponseEntity<UserDTO> signUp(@RequestBody RegistroDTO registroDTO) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(registroDTO));
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
		// Created only to retrieve the Bearer token once authenticated
		return ResponseEntity.status(HttpStatus.OK).body(userDTO);
	}

	@PutMapping("/upPassUser")
	public ResponseEntity<?> upPasswordUser(@RequestBody UserDTO userDTO) {
		ResponseEntity<?> response;
		try {
			//if (userService.upPassOk(userDTO)) {
				response = ResponseEntity.status(HttpStatus.OK).body(userService.upUser(userDTO));
			//} else {
			//	response = ResponseEntity.status(HttpStatus.CONFLICT).body("Error, la contraseña es incorrecta");
			//}
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

}
