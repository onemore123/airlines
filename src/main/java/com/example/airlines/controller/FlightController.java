package com.example.airlines.controller;

import com.example.airlines.repository.FlightRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flight")
public class FlightController {
    private final FlightRepository flightRepository;

    FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @RequestMapping
    public String list() {
        return flightRepository.findAll().toString();
    }
}
