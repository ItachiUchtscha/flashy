package com.patric.flashcard_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlashcardAppApplication {

	public static void main(String[] args) {
		System.out.println("DB_URL=" + System.getenv("DB_URL"));
		System.out.println("DB_PASS=" + System.getenv("DB_PASS"));
		System.out.println("DB_URL=" + System.getenv("DB_USER"));
		SpringApplication.run(FlashcardAppApplication.class, args);
	}

}
