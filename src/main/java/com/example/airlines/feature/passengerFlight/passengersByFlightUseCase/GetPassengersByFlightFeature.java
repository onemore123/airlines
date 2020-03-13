package com.example.airlines.feature.passengerFlight.passengersByFlightUseCase;

import com.example.airlines.dto.PassengerSeat;
import com.example.airlines.entity.Flight;
import com.example.airlines.entity.Passenger;
import com.example.airlines.entity.PassengerFlight;
import com.example.airlines.enums.SeatType;
import com.example.airlines.exception.NotFoundException;
import com.example.airlines.repository.FlightRepository;
import com.example.airlines.repository.PassengerFlightRepository;
import com.example.airlines.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetPassengersByFlightFeature {
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;
    private final PassengerFlightRepository passengerFlightRepository;

    public GetPassengersByFlightFeature(
            FlightRepository flightRepository,
            PassengerRepository passengerRepository,
            PassengerFlightRepository passengerFlightRepository
    ) {
        this.flightRepository = flightRepository;
        this.passengerRepository = passengerRepository;
        this.passengerFlightRepository = passengerFlightRepository;
    }

    public Map<Enum<SeatType>, List<PassengerSeat>> getPassengersCountByFlightId(Long flightId) {
        Flight flight = flightRepository
                .findById(flightId)
                .orElseThrow(NotFoundException::new);

        List<PassengerFlight> businessClassPassengerFlightCount = passengerFlightRepository.findAllByFlightIdAndSeatType(flightId, SeatType.BUSINESS_CLASS);
        List<PassengerFlight> economyClassPassengerFlightCount = passengerFlightRepository.findAllByFlightIdAndSeatType(flightId, SeatType.ECONOMY_CLASS);

        Map<Enum<SeatType>, List<PassengerSeat>> passengersBySeatTypeCount = new HashMap<Enum<SeatType>, List<PassengerSeat>>();
        List<PassengerSeat> businessClassPassengersCount = getPassengersSeatCount(businessClassPassengerFlightCount, flight);
        List<PassengerSeat> economyClassPassengersCount = getPassengersSeatCount(economyClassPassengerFlightCount, flight);

        passengersBySeatTypeCount.put(SeatType.BUSINESS_CLASS, businessClassPassengersCount);
        passengersBySeatTypeCount.put(SeatType.ECONOMY_CLASS, economyClassPassengersCount);

        return passengersBySeatTypeCount;
    }

    private List<PassengerSeat> getPassengersSeatCount(List<PassengerFlight> passengerFlightCount, Flight flight) {
        List<PassengerSeat> passengerSeatsCount = new ArrayList<>();

        for (PassengerFlight passengerFlight:
                passengerFlightCount) {
            Passenger passenger = passengerRepository.findById(passengerFlight.getPassengerId()).orElseThrow(NotFoundException::new);
            PassengerSeat seat = PassengerSeat.create(
                    passenger,
                    flight,
                    passengerFlight.getSeatNumber(),
                    passengerFlight.getSeatType()
            );

            passengerSeatsCount.add(seat);
        }

        return passengerSeatsCount;
    }
}
