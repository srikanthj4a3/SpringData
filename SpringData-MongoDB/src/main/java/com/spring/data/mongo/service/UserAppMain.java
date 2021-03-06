package com.spring.data.mongo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.spring.data.mongo.service")
@SpringBootApplication
public class UserAppMain {

	public static void main(String[] args) {

		SpringApplication.run(UserAppMain.class, args);

	}

}
