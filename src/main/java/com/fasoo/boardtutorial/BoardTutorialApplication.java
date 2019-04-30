package com.fasoo.boardtutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoardTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardTutorialApplication.class, args);
	}

}
