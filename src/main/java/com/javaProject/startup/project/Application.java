package com.javaProject.startup.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.javaProject.startup")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}