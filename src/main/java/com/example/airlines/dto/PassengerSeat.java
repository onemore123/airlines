package com.example.airlines.dto;

import com.example.airlines.entity.Flight;
import com.example.airlines.entity.Passenger;

public class PassengerSeat {
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;

    public PassengerSeat(Passenger passenger, Flight flight, int seatNumber) {
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
