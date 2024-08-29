package com.springboot.fyp.servieslayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.fyp.dao.UserRepo;
import com.springboot.fyp.entities.Users;

@Service
public class ServiceLayer {
    @Autowired
    UserRepo userRepo;

    
    
	public Users createUser(Users user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		userRepo.save(user);
		return user;
	}

    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
