package com.example.airlines.repository;

import com.example.airlines.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    Flight findById(long id);
    Flight findByAircraft(String aircraft);
    List<Flight> findAll();
}
