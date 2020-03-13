package com.example.airlines.request;

import com.example.airlines.enums.SeatType;

public class FlightRequest {
    public long flightId;
    public Enum<SeatType> seatType;

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public Enum<SeatType> getSeatType() {
        return seatType;
    }

    public void setSeatType(Enum<SeatType> seatType) {
        this.seatType = seatType;
    }
}
