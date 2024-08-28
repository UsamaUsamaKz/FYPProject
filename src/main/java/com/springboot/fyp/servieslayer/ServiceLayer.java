package com.springboot.fyp.servieslayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fyp.dao.UserRepo;
import com.springboot.fyp.entities.Users;

@Service
public class ServiceLayer {
    @Autowired
    UserRepo repo;

    public Users saveStudent(Users user) {
        repo.save(user);
        return user;
    }

    public Users findByEmail(String email) {
        return repo.findByEmail(email);
    }

}
