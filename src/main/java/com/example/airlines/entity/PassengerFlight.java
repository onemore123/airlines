package com.example.airlines.entity;

import com.example.airlines.enums.SeatType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PassengerFlight {
    @Id
    @GeneratedValue
    private Long id;
    private Long flightId;
    private Long passengerId;
    private Enum<SeatType> seatType;
    private int seatNumber;

    public PassengerFlight() {
    }

    public static PassengerFlight create(
            Long flightId,
            Long passengerId,
            Enum<SeatType> seatType,
            int seatNumber
    ) {
        PassengerFlight passengerFlight = new PassengerFlight();
        passengerFlight.flightId = flightId;
        passengerFlight.passengerId = passengerId;
        passengerFlight.seatType = seatType;
        passengerFlight.seatNumber = seatNumber;

        return passengerFlight;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Enum<SeatType> getSeatType() {
        return seatType;
    }

    public void setSeatType(Enum<SeatType> seatType) {
        this.seatType = seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerFlight)) return false;
        PassengerFlight that = (PassengerFlight) o;
        return getSeatNumber() == that.getSeatNumber() &&
                getId().equals(that.getId()) &&
                getFlightId().equals(that.getFlightId()) &&
                getPassengerId().equals(that.getPassengerId()) &&
                getSeatType().equals(that.getSeatType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFlightId(), getPassengerId(), getSeatType(), getSeatNumber());
    }

    @Override
    public String toString() {
        return "PassengerFlight{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", seatType=" + seatType +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
