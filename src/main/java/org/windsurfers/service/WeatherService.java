package org.windsurfers.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    public WeatherData getBestLocation(String date){
        List<String> windsurfingLocation = List.of(
                "Jastarnia,PL",
                "Bridgetown,BB",
                "Frotaleza,BR",
                "Pissouri,CY",
                "Le Morne,MU"
        );

//        WeatherData bestLocationData= null;
//        double bestLocationValue= Double.NEGATIVE_INFINITY;
//
//        for (String location : windsurfingLocation){
//            String apiUrl= "http://api.weatherbit.io/v2.0/forecast/daily" +
//                    "city="+location +
//                    "&"
//        }

    }
}
