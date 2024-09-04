package com.springboot.fyp.controller;

import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.fyp.entities.Users;
import com.springboot.fyp.servieslayer.UserServicelayer;
import com.springboot.fyp.validationmapper.RegistrationMapper;
import com.springboot.fyp.validationmapper.UserValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/logincontroller")
public class LoginController {
	@Autowired
	UserValidator userValidator;
	@Autowired
	UserServicelayer serviceLayer;
	
	  @GetMapping("/login")
	    public String home(Model model) {
		  model.addAttribute("formtype", "login");
		  model.addAttribute("userForm", new RegistrationMapper());
		  System.out.println("login");
	        return "login";
	    }
	  
	  	@GetMapping("/signup")
	    public String signupForm(Model model) {
			  model.addAttribute("formtype", "signup");

	        model.addAttribute("userForm", new RegistrationMapper());
	        return "login";
	    }

	    @PostMapping("/process")
	    public String registerUser( @ModelAttribute("userForm") RegistrationMapper signupForm, 
	    							BindingResult result, Model model) {
	      userValidator.validate(signupForm, result);
	        if (result.hasErrors()) {
				  model.addAttribute("formtype", "signup");
	        	return "login";
	        }
	        Users users = serviceLayer.mapRegistrationMapperToUser(signupForm);
	        serviceLayer.createUser(users);
	        return "redirect:/login";
	    }
	}

