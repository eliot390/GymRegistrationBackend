package com.example.GymRegistrationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GymRegistrationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymRegistrationServerApplication.class, args);
	}
}
