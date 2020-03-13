package com.example.airlines.request;

import com.example.airlines.enums.SeatType;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CheckInRequest {
    private String phone;
    private long flightId;
    private Enum<SeatType> seatType;

    public CheckInRequest() {}

    public CheckInRequest(String phone, long flightId, Enum<SeatType> seatType) {
        this.phone = phone;
        this.flightId = flightId;
        this.seatType = seatType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckInRequest)) return false;
        CheckInRequest that = (CheckInRequest) o;
        return getFlightId() == that.getFlightId() &&
                getPhone().equals(that.getPhone()) &&
                getSeatType().equals(that.getSeatType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhone(), getFlightId(), getSeatType());
    }

    @Override
    public String toString() {
        return "CheckInRequest{" +
                "phone='" + phone + '\'' +
                ", flightId=" + flightId +
                ", seatType=" + seatType +
                '}';
    }
}
