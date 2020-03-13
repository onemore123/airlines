package com.example.airlines.feature.passengerFlight.passengersByFlightUseCase;

import com.example.airlines.entity.Flight;
import com.example.airlines.entity.Passenger;
import com.example.airlines.entity.PassengerFlight;
import com.example.airlines.enums.SeatType;
import com.example.airlines.exception.NotFoundException;
import com.example.airlines.repository.FlightRepository;
import com.example.airlines.repository.PassengerFlightRepository;
import com.example.airlines.repository.PassengerRepository;
import com.example.airlines.request.CheckInRequest;
import org.springframework.stereotype.Service;

@Service
public class CheckInPassengerFeature {
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final PassengerFlightRepository passengerFlightRepository;

    public CheckInPassengerFeature(
            FlightRepository flightRepository,
            PassengerRepository passengerRepository,
            PassengerFlightRepository passengerFlightRepository
    ) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.passengerFlightRepository = passengerFlightRepository;
    }

    public String checkIn(CheckInRequest request) {
        Flight flight = this.flightRepository.findById(request.getFlightId());
        if (flight == null) {
            throw new NotFoundException();
        }

        Passenger passenger = this.passengerRepository.findByPhone(request.getPhone());
        if (passenger == null) {
            throw new NotFoundException();
        }

        int seatNumber = 0;
        boolean seatAvailable = false;
        if (request.getSeatType().equals(SeatType.BUSINESS_CLASS)) {
            if (flight.getBusinessSeatsAvailableNumber() > 0) {
                seatAvailable = true;
                seatNumber = flight.getBusinessSeatsNumber() - flight.getBusinessSeatsAvailableNumber() + 1;
            }
        } else if (request.getSeatType().equals(SeatType.ECONOMY_CLASS)) {
            if (flight.getEconomySeatsAvailableNumber() > 0) {
                seatAvailable = true;
                seatNumber = flight.getEconomySeatsNumber() - flight.getEconomySeatsAvailableNumber() + 1;
            }
        }

        if (!seatAvailable) {
            throw new RuntimeException("No seats available.");
        }

        PassengerFlight passengerFlight = PassengerFlight.create(
                flight.getId(),
                passenger.getId(),
                request.getSeatType(),
                seatNumber
        );
        this.passengerFlightRepository.save(passengerFlight);

        return passengerFlight.toString();
    }
}
