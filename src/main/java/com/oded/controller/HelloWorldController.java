package com.oded.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

	
	@RequestMapping({ "/test" })
	public String test() {
		return "Hello World";
	}
	@PreAuthorize ("hasRole('ROLE_USER')")
	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}
	@PreAuthorize ("hasRole('ROLE_ROOT')")
	@RequestMapping({ "/home" })
	public String home() {
		return "Hello World";
	}
	
	
	

}
