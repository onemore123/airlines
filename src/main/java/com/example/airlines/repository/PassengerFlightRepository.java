package com.example.airlines.repository;

import com.example.airlines.entity.PassengerFlight;
import org.springframework.data.repository.CrudRepository;

public interface PassengerFlightRepository extends CrudRepository<PassengerFlight, Long> {
    PassengerFlight findById(long id);
    PassengerFlight findAllByFlightId(long flightId);
    PassengerFlight findByFlightIdAndPassengerId(long flightId, long passengerId);
}
