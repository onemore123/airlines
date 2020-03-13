package com.example.airlines.dto;

import com.example.airlines.entity.Flight;
import com.example.airlines.entity.Passenger;
import com.example.airlines.enums.SeatType;

import java.util.Objects;

public class PassengerSeat {
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;
    private Enum<SeatType> seatType;

    public PassengerSeat() {}

    public static PassengerSeat create(
            Passenger passenger,
            Flight flight,
            int seatNumber,
            Enum<SeatType> seatType
    ) {
        PassengerSeat seat = new PassengerSeat();
        seat.passenger = passenger;
        seat.flight = flight;
        seat.seatNumber = seatNumber;
        seat.seatType = seatType;

        return seat;
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

    public Enum<SeatType> getSeatType() {
        return seatType;
    }

    public void setSeatType(Enum<SeatType> seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerSeat)) return false;
        PassengerSeat that = (PassengerSeat) o;
        return getSeatNumber() == that.getSeatNumber() &&
                getPassenger().equals(that.getPassenger()) &&
                getFlight().equals(that.getFlight()) &&
                getSeatType().equals(that.getSeatType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassenger(), getFlight(), getSeatNumber(), getSeatType());
    }

    @Override
    public String toString() {
        return "PassengerSeat{" +
                "passenger=" + passenger +
                ", flight=" + flight +
                ", seatNumber=" + seatNumber +
                ", seatType=" + seatType +
                '}';
    }
}
