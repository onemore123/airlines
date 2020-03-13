package com.example.airlines.entity;

import com.example.airlines.enums.SeatType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String aircraft;
    private int businessSeatsNumber;
    private int economySeatsNumber;
    private int businessSeatsAvailableNumber;
    private int economySeatsAvailableNumber;
    private String departure = "OVB";
    private String destination;

    protected Flight() {
    }

    public Flight(
            String name,
            String aircraft,
            int businessSeatsNumber,
            int economySeatsNumber,
            String destination
    ) {
        this.name = name;
        this.aircraft = aircraft;
        this.businessSeatsNumber = businessSeatsNumber;
        this.economySeatsNumber = economySeatsNumber;
        this.businessSeatsAvailableNumber = businessSeatsNumber;
        this.economySeatsAvailableNumber = economySeatsNumber;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getBusinessSeatsNumber() {
        return businessSeatsNumber;
    }

    public void setBusinessSeatsNumber(int businessSeatsNumber) {
        this.businessSeatsNumber = businessSeatsNumber;
    }

    public int getEconomySeatsNumber() {
        return economySeatsNumber;
    }

    public void setEconomySeatsNumber(int economySeatsNumber) {
        this.economySeatsNumber = economySeatsNumber;
    }

    public int getBusinessSeatsAvailableNumber() {
        return businessSeatsAvailableNumber;
    }

    public void setBusinessSeatsAvailableNumber(int businessSeatsAvailableNumber) {
        this.businessSeatsAvailableNumber = businessSeatsAvailableNumber;
    }

    public int getEconomySeatsAvailableNumber() {
        return economySeatsAvailableNumber;
    }

    public void setEconomySeatsAvailableNumber(int economySeatsAvailableNumber) {
        this.economySeatsAvailableNumber = economySeatsAvailableNumber;
    }

    public void decrementAvailableSeatsNumberBySeatType(Enum<SeatType> seatType) {
        if (seatType.equals(SeatType.BUSINESS_CLASS) && this.getBusinessSeatsAvailableNumber() > 0) {
            this.setBusinessSeatsAvailableNumber(this.getBusinessSeatsAvailableNumber() - 1);
        } else if (seatType.equals(SeatType.ECONOMY_CLASS) && this.getEconomySeatsAvailableNumber() > 0) {
            this.setEconomySeatsAvailableNumber(this.getEconomySeatsAvailableNumber() - 1);
        }
    }

    public int getAvailableSeatsTotalNumber() {
        return this.getBusinessSeatsAvailableNumber() + this.getEconomySeatsAvailableNumber();
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getBusinessSeatsNumber() == flight.getBusinessSeatsNumber() &&
                getEconomySeatsNumber() == flight.getEconomySeatsNumber() &&
                getBusinessSeatsAvailableNumber() == flight.getBusinessSeatsAvailableNumber() &&
                getEconomySeatsAvailableNumber() == flight.getEconomySeatsAvailableNumber() &&
                getId().equals(flight.getId()) &&
                getName().equals(flight.getName()) &&
                getAircraft().equals(flight.getAircraft()) &&
                getDeparture().equals(flight.getDeparture()) &&
                getDestination().equals(flight.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAircraft(), getBusinessSeatsNumber(), getEconomySeatsNumber(), getBusinessSeatsAvailableNumber(), getEconomySeatsAvailableNumber(), getDeparture(), getDestination());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aircraft='" + aircraft + '\'' +
                ", businessSeatsNumber=" + businessSeatsNumber +
                ", economySeatsNumber=" + economySeatsNumber +
                ", businessSeatsAvailableNumber=" + businessSeatsAvailableNumber +
                ", economySeatsAvailableNumber=" + economySeatsAvailableNumber +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
