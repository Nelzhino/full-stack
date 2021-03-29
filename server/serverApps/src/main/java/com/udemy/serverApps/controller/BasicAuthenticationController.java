package com.udemy.serverApps.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.serverApps.models.AutenticationBean;

@RestController
@CrossOrigin("http://localhost:4200")
public class BasicAuthenticationController {

	
	@GetMapping(path = "/basicAuth")
	public AutenticationBean autenticationBean() {
		return new AutenticationBean("You are authenticated");
	}
	
}
