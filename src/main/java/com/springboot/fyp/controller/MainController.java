package com.springboot.fyp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.springboot.fyp.entities.Users;
import com.springboot.fyp.servieslayer.ServiceLayer;

@Controller
@RequestMapping("/homecontroller")
public class MainController {

	@Autowired
	ServiceLayer service;

	@PostMapping("/createUser")
	public HttpEntity<?> saveStudent(@RequestBody Users user) {
		try {
			Users users = service.createUser(user);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/home")
	public String check() {
		return "index";
	}

}
