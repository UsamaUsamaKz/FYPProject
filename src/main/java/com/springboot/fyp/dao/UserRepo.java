package com.springboot.fyp.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.fyp.entities.Users;

public interface UserRepo extends CrudRepository<Users, Integer> {
    Users findByEmail(String name);
}
