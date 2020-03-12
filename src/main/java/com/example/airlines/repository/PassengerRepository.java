package com.example.airlines.repository;

import com.example.airlines.entity.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
    Passenger findById(long id);
    Passenger findByPhone(String phone);
    List<Passenger> findAll();
}
