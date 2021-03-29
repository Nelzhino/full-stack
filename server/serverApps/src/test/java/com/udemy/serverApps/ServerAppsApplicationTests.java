package com.udemy.serverApps;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ServerAppsApplicationTests {


	@Test
	public void createUserTest() {
		BCryptPasswordEncoder bryptPasswordEncoder = new BCryptPasswordEncoder();
		
		for (int i = 0; i < 10; i++) {
			String encodedString = bryptPasswordEncoder.encode("password@!123@#!");
			System.out.println(encodedString);
		}
		
		
		assertTrue(Boolean.TRUE);
	}

}
