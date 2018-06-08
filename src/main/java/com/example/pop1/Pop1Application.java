package com.example.pop1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pop1Application {

	public static void main(String[] args) {
		SpringApplication.run(Pop1Application.class, args);
	}
}
