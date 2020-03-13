package com.example.airlines.controller;

import com.example.airlines.repository.PassengerFlightRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passenger-flight")
public class PassengerFlightController {
    private final PassengerFlightRepository passengerFlightRepository;

    public PassengerFlightController(PassengerFlightRepository passengerFlightRepository) {
        this.passengerFlightRepository = passengerFlightRepository;
    }

    @RequestMapping
    public String list() {
        return passengerFlightRepository.findAll().toString();
    }
}
