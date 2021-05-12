package com.school.ingredientsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IngredientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngredientsServiceApplication.class, args);
	}

}
