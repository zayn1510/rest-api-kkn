package com.api.kkn.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication
@EnableCaching
public class ApiKknApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiKknApplication.class, args);
	}
}
