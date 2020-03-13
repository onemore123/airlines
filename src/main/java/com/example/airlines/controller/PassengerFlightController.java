package com.example.airlines.controller;

import com.example.airlines.dto.PassengerSeat;
import com.example.airlines.enums.SeatType;
import com.example.airlines.feature.passengerFlight.passengersByFlightUseCase.GetPassengersByFlightFeature;
import com.example.airlines.repository.PassengerFlightRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("passenger-flight")
public class PassengerFlightController {
    private final PassengerFlightRepository passengerFlightRepository;
    private final GetPassengersByFlightFeature getPassengersByFlightFeature;

    public PassengerFlightController(
            PassengerFlightRepository passengerFlightRepository,
            GetPassengersByFlightFeature getPassengersByFlightFeature
    ) {
        this.passengerFlightRepository = passengerFlightRepository;
        this.getPassengersByFlightFeature = getPassengersByFlightFeature;
    }

    @GetMapping
    public String list() {
        return passengerFlightRepository.findAll().toString();
    }

    @GetMapping("{id}")
    public Map<Enum<SeatType>, List<PassengerSeat>> listByFlightId(@PathVariable String id) {
        //todo
    }
}
