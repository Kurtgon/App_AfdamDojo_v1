package com.jacaranda.appDojoAfdam.security.filter;


import static com.jacaranda.appDojoAfdam.security.filter.jwt.JWTTokenProvider.generateToken;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacaranda.appDojoAfdam.model.entity.Persona;
import com.jacaranda.appDojoAfdam.repo.PersonaRepository;
import com.jacaranda.appDojoAfdam.security.common.SecurityConstants;
import com.jacaranda.appDojoAfdam.security.model.User;
import com.jacaranda.appDojoAfdam.security.model.dto.UserDTO;



@WebFilter
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	private PersonaRepository personaRepository;
	
	private static AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl(SecurityConstants.LOG_IN);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		UserDTO user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), UserDTO.class);
			

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return 	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), 
																						   user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User user = (User) authResult.getPrincipal();
		//getPersona(user);
		//Lo que devolveremos en la petición
		response.getWriter().print(generateToken(user));
		
		//response.addHeader(HEADER_STRING, TOKEN_PREFIX + generateToken((User) authResult.getPrincipal()));
	}
	
//	private Persona getPersona(User user) {
//		return personaRepository.findPersonaByUser(user);
//	}
}
