package com.scaler.BookMyMovie;

import com.scaler.BookMyMovie.Controller.RegisterUserController;
import com.scaler.BookMyMovie.DTOs.RegisterUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyMovieApplication implements CommandLineRunner {

	@Autowired
	private RegisterUserController registerUserController;

	public static void main(String[] args) {
		SpringApplication.run(BookMyMovieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
		registerUserRequestDTO.setName("ABC");
		registerUserRequestDTO.setPassword("abc");
		registerUserRequestDTO.setEmail("abc@gmail.com");

		registerUserController.registerUser(registerUserRequestDTO);
	}
}
