package com.springboot.fyp.servieslayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.fyp.dao.UserRepo;
import com.springboot.fyp.entities.Users;
import com.springboot.fyp.validationmapper.RegistrationMapper;

@Service
public class UserServicelayer {
    @Autowired
    UserRepo userRepo;

	public Users createUser(Users user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(password);
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		userRepo.save(user);
		return user;
	}

    public Users findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public boolean existByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
    public Users mapRegistrationMapperToUser(RegistrationMapper registrationMapper) {
        Users users = new Users();
        users.setEmail(registrationMapper.getFormemail());
        users.setName(registrationMapper.getName());
        users.setPhoneNo(registrationMapper.getPhoneNo());
        users.setPassword(registrationMapper.getPasswordConfirm());
        return users;
    }
}
