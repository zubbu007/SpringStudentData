package com.cg.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerMain {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerMain.class, args);
		System.out.println("Server Started successfully at 8083............");
	}

}
