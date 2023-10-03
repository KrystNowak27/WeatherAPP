package org.windsurfers.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.windsurfers.service.dto.LocationResponse;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class LocationWeatherDataService {
    public static final String API_URL = "https://api.weatherbit.io/v2.0/forecast/daily";
    public static final String API_KEY = "f709035defd94163a868b75ef560bbbd";
    private final RestTemplate restTemplate;

    public LocationResponse getLocationsWeatherData(){
    final RestTemplate restTemplate = new RestTemplate();
    final HashMap<String,String> uriVariables = new HashMap<>();
    uriVariables.put("city_name","jastarnia");

    final ResponseEntity<LocationResponse> response = restTemplate
            .getForEntity(API_URL + "?city={city_name}&key=" + API_KEY,LocationResponse.class, "jastarnia"
            );
    return response.getBody();
}



}