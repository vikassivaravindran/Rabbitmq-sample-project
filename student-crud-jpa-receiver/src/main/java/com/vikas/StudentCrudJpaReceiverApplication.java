package com.vikas;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentCrudJpaReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudJpaReceiverApplication.class, args);
	}
}
