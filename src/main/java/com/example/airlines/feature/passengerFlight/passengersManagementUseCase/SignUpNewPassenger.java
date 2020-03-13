package com.example.airlines.feature.passengerFlight.passengersManagementUseCase;

import com.example.airlines.entity.Passenger;
import com.example.airlines.repository.PassengerRepository;

import java.util.Map;

public class SignUpNewPassenger {
    private final PassengerRepository passengerRepository;

    public SignUpNewPassenger(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

//    public Passenger signUp(Map<String, String> passengerToSignUp) {
//
//    }
}
