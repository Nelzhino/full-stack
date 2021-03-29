package com.udemy.serverApps.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.udemy.serverApps.dto.UserDto;
import com.udemy.serverApps.entities.User;
import com.udemy.serverApps.entities.UserRol;
import com.udemy.serverApps.repositories.UserRepository;
import com.udemy.serverApps.services.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	public  UserRepository userRepository; 
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public void save(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(bcryptEncoder.encode(userDto.getPassword()));

		Set<UserRol> userRoles = new HashSet<>();
		userDto.getRoles().forEach( nameRol -> {
			UserRol rol = new UserRol();
			rol.setRol(nameRol);
			rol.setUser(user);
			userRoles.add(rol);			
		});	
		
		userRepository.save(user);
	}

	
	
}
