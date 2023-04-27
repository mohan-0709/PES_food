package com.pes_food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class pes_foodApplication {
	public static void main(String[] args) {
		SpringApplication.run(pes_foodApplication.class, args);
	}
}
