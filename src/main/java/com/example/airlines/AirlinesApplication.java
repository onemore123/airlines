package com.example.airlines;

import com.example.airlines.entity.Flight;
import com.example.airlines.entity.Passenger;
import com.example.airlines.entity.PassengerFlight;
import com.example.airlines.enums.SeatType;
import com.example.airlines.helper.PassengerGeneratorHelper;
import com.example.airlines.repository.FlightRepository;
import com.example.airlines.repository.PassengerFlightRepository;
import com.example.airlines.repository.PassengerRepository;
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

	@Bean
	public CommandLineRunner demo(
			PassengerRepository passengerRepository,
			FlightRepository flightRepository,
			PassengerFlightRepository passengerFlightRepository
	) {
		// Set up dummy data to test the application
		return (args) -> {
			Flight testFlight = new Flight(
					"S7 2502",
					"A-321",
					8,
					156,
					"DOM"
			);
			flightRepository.save(testFlight);

			List<Passenger> fakePassengersCount = PassengerGeneratorHelper.generatePassengersCount(5);
			int luckyPassengersCount = 0;
			SeatType seatType = SeatType.ECONOMY_CLASS;
			for (Passenger passenger : fakePassengersCount) {
				if (testFlight.getAvailableSeatsTotalNumber() > 0) {
					passengerRepository.save(passenger);
					if (luckyPassengersCount < 8) {
						seatType = SeatType.BUSINESS_CLASS;
					}

					PassengerFlight passengerFlight = PassengerFlight.create(
							testFlight.getId(),
							passenger.getId(),
							seatType,
							luckyPassengersCount
					);
					passengerFlightRepository.save(passengerFlight);
					testFlight.decrementAvailableSeatsNumberBySeatType(seatType);

					luckyPassengersCount++;
				} else {
					break;
				}
			}
			flightRepository.save(testFlight);
		};
	}
}
