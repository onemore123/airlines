package com.example.airlines.controller;

import com.example.airlines.entity.Passenger;
import com.example.airlines.repository.PassengerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("passenger")
public class PassengerController {
    private final PassengerRepository passengerRepository;

    PassengerController(
            PassengerRepository passengerRepository
    ) {
        this.passengerRepository = passengerRepository;
    }

    @GetMapping
    public String list() {
        return passengerRepository.findAll().toString();
    }

    @PostMapping()
    public String newPassenger(@RequestBody Passenger newPassenger) {
        Passenger passenger = passengerRepository.findByPhone(newPassenger.getPhone());
        if (passenger != null) {
            throw new RuntimeException("Non unique phone.");
        }
        passengerRepository.save(newPassenger);

        return newPassenger.toString();
    }
}
