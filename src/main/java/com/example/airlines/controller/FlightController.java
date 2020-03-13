package com.example.airlines.controller;

import com.example.airlines.entity.Flight;
import com.example.airlines.enums.SeatType;
import com.example.airlines.exception.NotFoundException;
import com.example.airlines.repository.FlightRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController {
    private final FlightRepository flightRepository;

    FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public String list() {
        return flightRepository.findAll().toString();
    }

    @GetMapping("/info")
    public int getAvailableSeats(@RequestParam Long flightId, @RequestParam String type) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(NotFoundException::new);

        if (SeatType.BUSINESS_CLASS.name().equals(type)) {
            return flight.getBusinessSeatsAvailableNumber();
        } else if (SeatType.ECONOMY_CLASS.name().equals(type)) {
            return flight.getEconomySeatsAvailableNumber();
        }

        return -1;
    }
}
