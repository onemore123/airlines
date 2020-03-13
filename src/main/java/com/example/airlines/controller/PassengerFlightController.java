package com.example.airlines.controller;

import com.example.airlines.dto.PassengerSeat;
import com.example.airlines.enums.SeatType;
import com.example.airlines.feature.passengerFlight.passengersByFlightUseCase.CheckInPassengerFeature;
import com.example.airlines.feature.passengerFlight.passengersByFlightUseCase.GetPassengersByFlightFeature;
import com.example.airlines.repository.PassengerFlightRepository;
import com.example.airlines.request.CheckInRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("passenger-flight")
public class PassengerFlightController {
    private final PassengerFlightRepository passengerFlightRepository;
    private final GetPassengersByFlightFeature getPassengersByFlightFeature;
    private final CheckInPassengerFeature checkInPassengerFeature;

    public PassengerFlightController(
            PassengerFlightRepository passengerFlightRepository,
            GetPassengersByFlightFeature getPassengersByFlightFeature,
            CheckInPassengerFeature checkInPassengerFeature
    ) {
        this.passengerFlightRepository = passengerFlightRepository;
        this.getPassengersByFlightFeature = getPassengersByFlightFeature;
        this.checkInPassengerFeature = checkInPassengerFeature;
    }

    @PostMapping()
    public String newCheckIn(@RequestBody HashMap<String, String> checkInRequestData) {
        //TODO: this is a workaround since the CheckInRequest in the RequestBody returns error
        CheckInRequest checkInRequest = new CheckInRequest();
        for (Map.Entry<String, String> field:
             checkInRequestData.entrySet()) {
            switch (field.getKey()) {
                case "phone":
                    checkInRequest.setPhone(field.getValue());
                    break;
                case "flightId":
                    checkInRequest.setFlightId(Long.parseLong(field.getValue()));
                    break;
                case "seatType":
                    if (SeatType.BUSINESS_CLASS.name().equals(field.getValue())) {
                        checkInRequest.setSeatType(SeatType.BUSINESS_CLASS);
                    } else {
                        checkInRequest.setSeatType(SeatType.ECONOMY_CLASS);
                    }
            }
        }

        return this.checkInPassengerFeature.checkIn(checkInRequest);
    }

    @GetMapping
    public String list() {
        return passengerFlightRepository.findAll().toString();
    }

    @GetMapping("{id}")
    public Map<Enum<SeatType>, List<PassengerSeat>> listByFlightId(@PathVariable String id) {
        return this.getPassengersByFlightFeature.getPassengersCountByFlightId(Long.parseLong(id));
    }
}
