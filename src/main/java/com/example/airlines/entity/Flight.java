package com.example.airlines.entity;

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

    protected Flight() {
    }

    public Flight(
            String name,
            String aircraft,
            int businessSeatsNumber,
            int economySeatsNumber
    ) {
        this.name = name;
        this.aircraft = aircraft;
        this.businessSeatsNumber = businessSeatsNumber;
        this.economySeatsNumber = economySeatsNumber;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return businessSeatsNumber == flight.businessSeatsNumber &&
                economySeatsNumber == flight.economySeatsNumber &&
                businessSeatsAvailableNumber == flight.businessSeatsAvailableNumber &&
                economySeatsAvailableNumber == flight.economySeatsAvailableNumber &&
                id.equals(flight.id) &&
                name.equals(flight.name) &&
                aircraft.equals(flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, aircraft, businessSeatsNumber, economySeatsNumber, businessSeatsAvailableNumber, economySeatsAvailableNumber);
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
                '}';
    }
}
