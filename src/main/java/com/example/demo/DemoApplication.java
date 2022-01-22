package com.example.demo;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			// Add some Roles
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			// Add some base Users
			userService.saveUser(new User(null, "Ludovick", "Ludovick", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Rheinardt", "Rheinardt", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Talleyrand", "Talleyrand", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Rita", "Rita", "password", new ArrayList<>()));

			// Affect Roles to Users
			userService.addRoleToUser( "Ludovick", "ROLE_USER");

			userService.addRoleToUser( "Rheinardt", "ROLE_USER");
			userService.addRoleToUser( "Rheinardt", "ROLE_MANAGER");

			userService.addRoleToUser( "Talleyrand", "ROLE_USER");
			userService.addRoleToUser( "Talleyrand", "ROLE_ADMIN");

			userService.addRoleToUser("Rita", "ROLE_USER");
			userService.addRoleToUser("Rita", "ROLE_SUPER_ADMIN");
		};
	}
}

// Scheme
/*
* ---------------------------------
*	API Layer (App) [@SpringBootApplication] & (Controllers) [@RestController]
*		|
*		V
*	Service Layer (Services) [@Service]
*		|
*		V
*	Data Access Layer (Interfaces) [@Repository]
*		|
*		V
*	Database
*
* ---------------------------------
*
*
* */