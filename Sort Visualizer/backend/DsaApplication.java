package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The DsaApplication class is the main entry point for the Spring Boot application.
 * It initializes and starts the Spring application context.
 */
@SpringBootApplication
public class DsaApplication {

	/**
	 * The main method that serves as the starting point for the Spring Boot application.
	 * It launches the application using SpringApplication.run.
	 *
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(DsaApplication.class, args);
	}
}
