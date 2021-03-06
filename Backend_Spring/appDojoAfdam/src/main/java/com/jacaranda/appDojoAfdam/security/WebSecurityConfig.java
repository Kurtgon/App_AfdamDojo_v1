package com.jacaranda.appDojoAfdam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.jacaranda.appDojoAfdam.security.common.SecurityConstants;
import com.jacaranda.appDojoAfdam.security.filter.JWTAuthenticationFilter;
import com.jacaranda.appDojoAfdam.security.filter.JWTAuthorizationFilter;
import com.jacaranda.appDojoAfdam.security.model.UserRole;
import com.jacaranda.appDojoAfdam.security.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTAuthorizationFilter jwtAuthorizationFilter;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
				.antMatchers(HttpMethod.POST, SecurityConstants.LOG_IN).permitAll()
				.antMatchers(HttpMethod.GET, "/disciplinas").permitAll()
				// acotando con los roles lo que se va necesitando con el antMatchers por ejemplo HttpMethod.POST, "/mensajes/*").hasRole(UserRole.ADMIN.name()
				.anyRequest().authenticated().and().addFilter(new JWTAuthenticationFilter(authenticationManagerBean()))
				.addFilterBefore(jwtAuthorizationFilter, BasicAuthenticationFilter.class).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}

}
