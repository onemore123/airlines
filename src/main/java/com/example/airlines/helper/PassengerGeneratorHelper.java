package com.example.airlines.helper;

import com.example.airlines.entity.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PassengerGeneratorHelper {
    public static List<Passenger> generatePassengersCount(int count) {
        List<String> firstNamesCount = new ArrayList<String>() {{
            add("Jack");
            add("Chloe");
            add("Kim");
            add("David");
            add("Michelle");
        }};

        List<String> lastNamesCount = new ArrayList<String>() {{
            add("Bauer");
            add("O'Brian");
            add("Bauer");
            add("Palmer");
            add("Dessler");
        }};

        Random rand = new Random();
        List<Passenger> passengerCount = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Passenger passenger = new Passenger(
                    firstNamesCount.get(rand.nextInt(firstNamesCount.size())),
                    lastNamesCount.get(rand.nextInt(lastNamesCount.size())),
                    rand.nextInt(100),
                    "+79998888" + (rand.nextInt(1501) + 8499)
            );

            passengerCount.add(passenger);
        }

        return passengerCount;
    }
}
