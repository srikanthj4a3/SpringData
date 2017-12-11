package com.boot.mongodb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.boot.mongodb")
public class UserProfileApp {

	public static void main(String[] args) {

		SpringApplication.run(UserProfileApp.class, args);

	}

}
