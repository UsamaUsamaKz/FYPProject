package com.springboot.fyp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.fyp.dao.UserRepo;
import com.springboot.fyp.entities.CustomUserDetails;
import com.springboot.fyp.entities.Users;

@Service("userDetailsService")
public class UserDetailsConfig implements UserDetailsService {
	@Autowired
	UserRepo dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("Custom UserDetailsService is being called...");

		Users user = dao.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		} else {
			return new CustomUserDetails(user);
		}

	}
}
