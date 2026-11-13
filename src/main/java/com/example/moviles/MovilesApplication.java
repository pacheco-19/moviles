package com.example.moviles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.example.moviles",
		"controller",
		"service",
		"exception"
})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class MovilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovilesApplication.class, args);
	}

}
//http://localhost:8082/moviles