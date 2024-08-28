package com.springboot.fyp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.springboot.fyp.entities.Users;
import com.springboot.fyp.servieslayer.ServiceLayer;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    ServiceLayer service;

    @PostMapping("/createUser")
    public ResponseEntity<Users> saveStudent(@RequestBody Users user) {
        try {
            Users users = service.saveStudent(user);
            return ResponseEntity.of(Optional.of(users));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/User/{email}")
    public ResponseEntity<Users> getAllStudent(@PathVariable("email") String email) {
        try {
            Users users = service.findByEmail(email);
            return ResponseEntity.of(Optional.of(users));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/home")
    public String home() {
        return "index";
    }

}
