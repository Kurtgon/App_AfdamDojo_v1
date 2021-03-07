package com.jacaranda.appDojoAfdam.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.appDojoAfdam.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByUsername(String username);
	
	public User findUserByUsername(String username);

}
