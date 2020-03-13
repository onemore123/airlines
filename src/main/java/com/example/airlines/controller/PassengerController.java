package com.example.airlines.controller;

import com.example.airlines.repository.PassengerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passenger")
public class PassengerController {
    private final PassengerRepository passengerRepository;

    PassengerController(
            PassengerRepository passengerRepository
    ) {
        this.passengerRepository = passengerRepository;
    }

    @RequestMapping
    public String list() {
        return passengerRepository.findAll().toString();
    }
}
