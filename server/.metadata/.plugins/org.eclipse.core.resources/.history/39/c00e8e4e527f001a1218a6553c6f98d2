package com.udemy.backendninja;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.udemy.entity.User;
import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;


@SpringBootTest
class BackendninjaApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bryptPasswordEncoder;

	@Test
	public void createUserTest() {
		User user = new User();
		UserRole userRole = new UserRole();

		user.setUsername("nelcarto");
		user.setPassword(bryptPasswordEncoder.encode("123"));
		user.setEnabled(true);
		
		userRole.setRole("ROLE_USER");
		userRole.setUser(user);
		
		Set<UserRole> roles = new HashSet<UserRole>();
		roles.add(userRole);
		user.setUserRole(roles);
		
		User userReturn = userRepository.save(user);
		
		assertTrue(userReturn.getPassword().equals(user.getPassword()));
		
		
	}

}
