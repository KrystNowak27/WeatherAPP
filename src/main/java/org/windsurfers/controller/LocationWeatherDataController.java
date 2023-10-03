package org.windsurfers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windsurfers.service.LocationWeatherDataService;
import org.windsurfers.service.dto.LocationResponse;

@RestController
@RequiredArgsConstructor
public class LocationWeatherDataController {
    private final LocationWeatherDataService service;

    @GetMapping(path = "/api/bestLocation")
    public ResponseEntity<LocationResponse> getLocationWeatherData(){
        final LocationResponse locationData= service.getLocationsWeatherData();
        return new ResponseEntity<>(locationData, HttpStatus.ACCEPTED);
    }
}
