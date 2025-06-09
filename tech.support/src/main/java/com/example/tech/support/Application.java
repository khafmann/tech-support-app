package com.example.tech.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.tech.support")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
