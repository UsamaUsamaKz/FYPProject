package com.springboot.fyp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logincontroller")
public class LoginController {
	  @GetMapping("/login")
	    public String home() {
		  System.out.println("login");
	        return "login";
	    }
	  
	  @GetMapping("/processing")
	    public String processing() {
		  System.out.println("processing");
	      System.out.println("processing");  
		  return "";
	    }
}
