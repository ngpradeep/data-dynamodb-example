package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataDynamodbExampleApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DataDynamodbExampleApplication.class, args);
		System.out.println("----------------->Hello dynamodb---------------->");
	}
}
