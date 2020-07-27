package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.emp.controller","com.emp.service","com.emp.config"})
@EntityScan("com.emp.entity.model")
@EnableJpaRepositories("com.emp.dao")
@EnableSwagger2
public class DatanomistApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DatanomistApplication.class, args);
	}

}
