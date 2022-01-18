package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
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