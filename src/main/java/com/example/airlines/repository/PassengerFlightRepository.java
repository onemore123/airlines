package com.example.airlines.repository;

import com.example.airlines.entity.PassengerFlight;
import com.example.airlines.enums.SeatType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerFlightRepository extends CrudRepository<PassengerFlight, Long> {
    PassengerFlight findById(long id);
    List<PassengerFlight> findAllByFlightIdAndSeatType(Long flightId, Enum<SeatType> seatType);
    PassengerFlight findByFlightIdAndPassengerId(long flightId, long passengerId);
}
