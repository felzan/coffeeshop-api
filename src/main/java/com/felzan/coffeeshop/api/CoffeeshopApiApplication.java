package com.felzan.coffeeshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class CoffeeshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeshopApiApplication.class, args);
	}

}
