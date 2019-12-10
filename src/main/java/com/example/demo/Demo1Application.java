package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.*")
public class Demo1Application {

	public static void main(String[] args) {
		//test
		SpringApplication.run(Demo1Application.class, args);
		//branch test
		//test123
	}
}
