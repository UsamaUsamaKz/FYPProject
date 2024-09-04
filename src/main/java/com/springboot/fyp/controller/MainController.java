package com.springboot.fyp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.springboot.fyp.entities.Users;
import com.springboot.fyp.servieslayer.UserServicelayer;

@Controller
@RequestMapping("/homecontroller")
public class MainController {

	@Autowired
	UserServicelayer service;

	@GetMapping("/home")
	public String check() {
		return "index";
	}

}
