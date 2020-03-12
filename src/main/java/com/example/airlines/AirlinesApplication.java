package com.example.airlines;

import com.example.airlines.entity.Passenger;
import com.example.airlines.repository.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirlinesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PassengerRepository repository) {
		return (args) -> {
			repository.save(new Passenger("Jack", "Bauer", 25, "+79998887780"));
			repository.save(new Passenger("Chloe", "O'Brian", 25, "+79998887781"));
			repository.save(new Passenger("Kim", "Bauer", 25, "+79998887782"));
			repository.save(new Passenger("David", "Palmer", 25, "+79998887783"));
			repository.save(new Passenger("Michelle", "Dessler", 25, "+79998887784"));
		};
	}
}
