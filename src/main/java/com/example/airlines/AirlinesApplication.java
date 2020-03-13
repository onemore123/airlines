package com.example.airlines;

import com.example.airlines.entity.Passenger;
import com.example.airlines.helper.PassengerGeneratorHelper;
import com.example.airlines.repository.PassengerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AirlinesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}

	Logger logger = LoggerFactory.getLogger(AirlinesApplication.class);
	@Bean
	public CommandLineRunner demo(PassengerRepository repository) {
		return (args) -> {
			List<Passenger> fakePassengersCount = PassengerGeneratorHelper.generatePassengersCount(5);
			for (Passenger passenger : fakePassengersCount) {
				repository.save(passenger);

				logger.info(passenger.toString());
			}
		};
	}
}
