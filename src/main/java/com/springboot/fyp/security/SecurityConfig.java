package com.springboot.fyp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, HandlerMappingIntrospector introspector)
			throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers(new MvcRequestMatcher(introspector, "/homecontroller/createUser"))
						.permitAll().requestMatchers(new MvcRequestMatcher(introspector, "/css/**")).permitAll()
						.requestMatchers(new MvcRequestMatcher(introspector, "/js/**")).permitAll()
						.requestMatchers(new MvcRequestMatcher(introspector, "/images/**")).permitAll()
						.requestMatchers(new MvcRequestMatcher(introspector, "/WEB-INF/views/login.jsp")).permitAll()
						.requestMatchers(new MvcRequestMatcher(introspector, "/logincontroller/signup")).permitAll()
						.requestMatchers(new MvcRequestMatcher(introspector, "/logincontroller/process")).permitAll()

						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/logincontroller/login").permitAll()
						.loginProcessingUrl("/homecontroller/home").usernameParameter("email")
						.passwordParameter("password").defaultSuccessUrl("/homecontroller/home", true)
						.failureUrl("/logincontroller/login?error").permitAll())
				.csrf(CsrfConfigurer::disable);

		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).authenticationProvider(authenticationProvider())
				.build();
	}
}
